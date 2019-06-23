package planet.plateau

object Dimension {

  case class Width private[plateau] (width: Int) extends AnyVal {

    def <(x: Int): Boolean = width < x
  }

  case class Height private[plateau] (height: Int) extends AnyVal {

    def <(y: Int): Boolean = height < y
  }
}
