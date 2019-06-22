package control

sealed trait Command

object Move extends Command

sealed trait Spin extends Command

object Left extends Spin

object Right extends Spin
