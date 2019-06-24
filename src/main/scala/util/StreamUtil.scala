package util

import scala.io.{BufferedSource, Source}
import scala.util.control.NonFatal

import cats.data.EitherT
import cats.effect.IO
import cats.implicits._

import control.center.Command
import planet.machinery.Rover
import planet.plateau.Plateau

object StreamUtil {

  /** Attempt to acquire BufferedSource. */
  def acquire(args: Seq[String]): EitherT[IO, String, BufferedSource] =
    EitherT {
      IO {
        val config: Config = new Config(args)

        Source.fromFile(config.path())
      }.attempt
    }.leftMap {
      case NonFatal(e) => e.getMessage
    }

  /** Get lines stream. */
  def linesStream(
      buffer: Either[String, BufferedSource]
  ): EitherT[IO, String, Stream[String]] =
    EitherT {
      IO {
        buffer.map(_.getLines().toStream)
      }
    }

  /** Get plateau's dimensions. */
  def plateauDim(stream: Stream[String]): EitherT[IO, String, Plateau] = {

    import Plateau._

    EitherT {
      IO {
        parseAll(expr, stream.head) match {
          case Success(plateau, _) => Right(plateau)
          case err: NoSuccess      => Left(err.msg)
        }
      }
    }
  }

  /** Rover's mission description. */
  def mission(
      stream: Stream[String],
      plateau: Plateau
  ): EitherT[IO, String, Unit] = {

    import planet.machinery.Rover._

    /** Output stream. */
    def output(result: Parser.ParseResult[Rover], commands: List[Command]): Unit =
      result match {
        case Parser.Success(rover, _) =>
          println(Rover.discover(rover, commands)(plateau))
        case err: Parser.NoSuccess =>
          println(s"Exception: ${err.msg}")
      }

    EitherT {
      IO {
        stream
          .sliding(2, 2)
          .toStream
          .foreach { task =>
            val (position: String, controls: String) = (task.head, task.last)

            val commands = controls.map(Command(_)).toList

            output(Parser.parseAll(position), commands)
          }

        ().asRight
      }
    }
  }
}
