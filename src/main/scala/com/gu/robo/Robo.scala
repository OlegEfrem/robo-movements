package com.gu.robo

case class Robo(position: Position = Position()) {
  def move(direction: Direction.Value): Robo = {
    val newPosition = position.move(direction)
    if (isOffBoundaries(newPosition))
      this
    else
      Robo(newPosition)
  }

  private def isOffBoundaries(newPosition: Position): Boolean = {
    import newPosition._
    List(eastWest, northSouth).exists(pos => pos < 0 || pos > 10)
  }
}
