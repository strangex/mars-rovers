package planet.machinery.orientation

import Axes._
import planet.plateau.Plateau

case class Coordinates private (x: XAxis, y: YAxis) {

  def up()(implicit plateau: Plateau): Coordinates =
    copy(y = y.increment())

  def right()(implicit plateau: Plateau): Coordinates =
    copy(x = x.increment())

  def down(): Coordinates = copy(y = y.decrement())

  def left(): Coordinates = copy(x = x.decrement())

  override def toString: String = s"$x $y"
}

object Coordinates {

  private[machinery] def apply(x: XAxis, y: YAxis): Coordinates =
    new Coordinates(x, y)
}
