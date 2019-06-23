package planet.machinery.orientation

import planet.plateau.Plateau

object Axes {

  class XAxis private[machinery](val x: Int) extends AnyVal {

    def decrement(): XAxis = {
      val update = x - 1

      if(update < 0) this else new XAxis(update)
    }

    def increment()(implicit plateau: Plateau): XAxis = {
      val update = x + 1

      if(plateau.width < update) this else new XAxis(update)
    }

    override def toString: String = s"$x"
  }

  class YAxis private[machinery](val y: Int) extends AnyVal {

    def decrement(): YAxis = {
      val update = y - 1

      if(update < 0) this else new YAxis(update)
    }

    def increment()(implicit plateau: Plateau): YAxis = {
      val update = y + 1

      if(plateau.height < update) this else new YAxis(update)
    }

    override def toString: String = s"$y"
  }
}
