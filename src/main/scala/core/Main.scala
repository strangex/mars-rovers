package core

import cats.effect.IO
import cats.implicits._

object Main extends App {

  import util.StreamUtil._

  val program: IO[Either[String, Unit]] =
    acquire(args).value.bracket {
      case Right(source) =>
        (for {
          stream <- linesStream(source)
          plateau <- plateauDim(stream)
          end <- mission(stream, plateau)
          printer <- output(end)
        } yield printer).value

      case Left(error) => IO.pure(error.asLeft)
    } {
      case Right(source) => IO(source.close())
      case Left(_) => IO.unit
    }

  program.unsafeRunSync() match {
    case Right(()) =>
    case Left(error) => println(s"Exception: $error")
  }
}
