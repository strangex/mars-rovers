package planet.space

import Axes.{XAxis, YAxis}

case class Coordinates(x: XAxis, y: YAxis) {

  def up(): Coordinates = copy(y = y.increment())

  def right(): Coordinates = copy(x = x.increment())

  def down(): Coordinates = copy(y = y.decrement())

  def left(): Coordinates = copy(x = x.decrement())
}
