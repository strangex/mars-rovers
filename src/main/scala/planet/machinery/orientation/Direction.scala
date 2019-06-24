package planet.machinery.orientation

sealed trait Direction {

  def right: Direction

  def left: Direction
}

object Direction {

  private[machinery] def apply(direction: Char): Direction = direction match {
    case 'N' => North
    case 'W' => West
    case 'S' => South
    case 'E' => East
    case _ => UndefinedDirection
  }
}

object UndefinedDirection extends Direction {

  def right: Direction = UndefinedDirection

  def left: Direction = UndefinedDirection

  override def toString: String = "U"
}

object North extends Direction {

  def right: Direction = East

  def left: Direction = West

  override def toString: String = "N"
}

object West extends Direction {

  def right: Direction = North

  def left: Direction = South

  override def toString: String = "W"
}

object South extends Direction {

  def right: Direction = West

  def left: Direction = East

  override def toString: String = "S"
}

object East extends Direction {

  def right: Direction = South

  def left: Direction = North

  override def toString: String = "E"
}
