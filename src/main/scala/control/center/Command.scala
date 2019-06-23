package control.center

sealed trait Command

object Command {

  def apply(command: Char): Command = command match {
    case 'M' => Move
    case 'L' => Left
    case 'R' => Right
    case _ => UndefinedCommand
  }
}

object UndefinedCommand extends Command

object Move extends Command

sealed trait Spin extends Command

object Left extends Spin

object Right extends Spin
