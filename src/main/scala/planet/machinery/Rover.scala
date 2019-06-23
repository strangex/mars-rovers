package planet.machinery

import control.center._
import planet.machinery.orientation.Axes.{XAxis, YAxis}
import planet.machinery.orientation._
import planet.plateau.Plateau

import scala.util.parsing.combinator.RegexParsers

case class Rover private (
    coordinates: Coordinates,
    direction: Direction
) {

  def update(command: Command)(implicit plateau: Plateau): Rover =
    command match {
      case command: Spin => spin(command)
      case UndefinedComamnd => this
      case Move          => move()
    }

  private def spin(spin: Spin): Rover = spin match {
    case Left  => copy(direction = direction.left)
    case Right => copy(direction = direction.right)
  }

  private def move()(implicit plateau: Plateau): Rover = direction match {
    case North => copy(coordinates = coordinates.up())
    case West  => copy(coordinates = coordinates.right())
    case South => copy(coordinates = coordinates.down())
    case East  => copy(coordinates = coordinates.left())
    case UndefinedDirection  => this
  }

  override def toString: String = s"$coordinates $direction"
}

object Rover extends RegexParsers {

  val xAxis: Parser[Int] = "[0-9]+".r ^^ { _.toInt }
  val yAxis: Parser[Int] = "[0-9]+".r ^^ { _.toInt }
  val direction: Parser[Char] = "[NWSE]".r ^^ { _.head }

  def expr: Parser[Rover] = xAxis ~ yAxis ~ direction ^^ {
    case x ~ y ~ d =>
      Rover(
        Coordinates(new XAxis(x), new YAxis(y)),
        Direction(d)
      )
  }

  def discover(rover: Rover, commands: List[Command])(
    implicit plateau: Plateau
  ): Rover =
    commands match {
      case command :: tail => discover(rover.update(command), tail)
      case Nil             => rover
    }
}
