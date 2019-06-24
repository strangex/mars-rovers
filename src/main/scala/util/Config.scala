package util

import org.rogach.scallop.exceptions.{Help, RequiredOptionNotFound, Version}
import org.rogach.scallop.{ScallopConf, ScallopOption}

class Config private[util](args: Seq[String]) extends ScallopConf(args) {

  version("mars-rovers:0.0 2019")
  banner(
    """
      |Usage: mars-rovers [OPTION]
      |
      |mars-rovers aims to control a set of rovers in a plateau, and output
      |their final positions.
      |
      |Options:
      |""".stripMargin
  )
  footer("\nFor specific details, please contact the author!")

  override def onError(e: Throwable): Unit = e match {
    case _: Help                   => super.onError(e)
    case Version                   => super.onError(e)
    case _: RequiredOptionNotFound => super.onError(e)
    case other                     => throw other
  }

  val path: ScallopOption[String] =
    opt[String](
      short = 'F',
      default = Some("./universe.dat"),
      descr = "universe data file")

  verify()
}
