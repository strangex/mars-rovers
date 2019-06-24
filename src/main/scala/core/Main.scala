package core

import cats.data.EitherT
import cats.effect.IO

import scala.io.BufferedSource

object Main extends App {

  import util.StreamUtil._

  def streamGadget(
    source: Either[String, BufferedSource]
  ): EitherT[IO, String, Unit] =
    for {
      stream <- linesStream(source)
      plateau <- plateauDim(stream)
      end <- mission(stream.tail, plateau)
    } yield end

  val program: IO[Unit] =
    acquire(args).value.bracket { source =>
      streamGadget(source).value.flatMap {
        case Right(_) => IO.unit
        case Left(error) => IO(println(s"Exception: $error"))
      }
    } {
      case Right(source) => IO(source.close())
      case Left(_)       => IO.unit
    }

  program.unsafeRunSync()
}
