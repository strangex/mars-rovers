package planet.space

object Axes {

  import planet.plateau.Dimension

  class XAxis(private val x: Int) extends AnyVal {

    def decrement(): XAxis = {
      val update = x - 1

      if(update < 0) this else new XAxis(update)
    }

    def increment(): XAxis = {
      val update = x + 1

      if(Dimension.width < update) this else new XAxis(update)
    }
  }

  class YAxis(private val y: Int) extends AnyVal {

    def decrement(): YAxis = {
      val update = y - 1

      if(update < 0) this else new YAxis(update)
    }

    def increment(): YAxis = {
      val update = y + 1

      if(Dimension.height < update) this else new YAxis(update)
    }
  }
}
