package planet.plateau

object Dimension {

  case class Width private[plateau] (w: Int) extends AnyVal {

    def <(x: Int): Boolean = w < x
  }

  case class Height private[plateau] (h: Int) extends AnyVal {

    def <(y: Int): Boolean = h < y
  }
}
