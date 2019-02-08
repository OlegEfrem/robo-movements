package com.gu.robo
import scala.annotation.tailrec

case class Robo(position: Position = Position()) {
  def move(direction: Direction.Value): Robo = {
    val newPosition = position.move(direction)
    if (isOffBoundaries(newPosition))
      this
    else
      Robo(newPosition)
  }

  def move(directions: List[Direction.Value]): Robo = recursiveMove(directions, this)

  @tailrec
  private def recursiveMove(directions: List[Direction.Value], robo: Robo): Robo = {
    directions match {
      case Nil    => robo
      case h :: t => recursiveMove(t, robo.move(h))
    }
  }

  private def isOffBoundaries(newPosition: Position): Boolean = {
    import newPosition._
    List(eastWest, northSouth).exists(pos => pos < 0 || pos > 10)
  }
}
