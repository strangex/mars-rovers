package planet.space

sealed trait Direction {

  def right: Direction

  def left: Direction
}

object North extends Direction {

  def right: Direction = West

  def left: Direction = East

  override def toString: String = "N"
}

object West extends Direction {

  def right: Direction = South

  def left: Direction = North

  override def toString: String = "W"
}

object South extends Direction {

  def right: Direction = East

  def left: Direction = West

  override def toString: String = "S"
}

object East extends Direction {

  def right: Direction = North

  def left: Direction = South

  override def toString: String = "E"
}
