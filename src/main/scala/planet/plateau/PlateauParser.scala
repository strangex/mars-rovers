package planet.plateau

import scala.util.parsing.combinator.RegexParsers

import Dimension._

object PlateauParser extends RegexParsers {

  val width: Parser[Int] = "[0-9]+".r ^^ { _.toInt }
  val height: Parser[Int] = "[0-9]+".r ^^ { _.toInt }

  def expr: Parser[Plateau] = width ~ height ^^ {
    case w ~ h => new Plateau(Width(w), Height(h))
  }
}
