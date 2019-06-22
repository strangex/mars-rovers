package planet.plateau

import core.Main

object Dimension {

  class Height private[Dimension] (private val height: Int) extends AnyVal {

    def <(y: Int): Boolean = height < y
  }

  class Width private[Dimension] (private val width: Int) extends AnyVal {

    def <(x: Int): Boolean = width < x
  }

  val height: Height = new Height(Main.height)
  val width: Width = new Width(Main.width)
}
