package planet

import control._
import planet.space._

case class Rover(coordinates: Coordinates, direction: Direction) {

  def update(command: Command): Rover =
    command match {
      case direction: Spin => spin(direction)
      case Move            => move()
    }

  private def spin(spin: Spin): Rover = spin match {
    case Left  => copy(direction = direction.left)
    case Right => copy(direction = direction.right)
  }

  private def move(): Rover = direction match {
    case North => copy(coordinates = coordinates.up())
    case West  => copy(coordinates = coordinates.right())
    case South => copy(coordinates = coordinates.down())
    case East  => copy(coordinates = coordinates.left())
  }
}
