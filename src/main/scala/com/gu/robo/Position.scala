package com.gu.robo

/**
  * @param northSouth north extreme is 0, south extreme is 10
  * @param eastWest east extreme is 0, west extreme is 10
  * */
case class Position(northSouth: Int = 0, eastWest: Int = 0) {

  def move(direction: Direction.Value): Position = {
    import Direction._
    direction match {
      case N => Position(northSouth - 1, eastWest)
      case S => Position(northSouth + 1, eastWest)
      case E => Position(northSouth, eastWest - 1)
      case W => Position(northSouth, eastWest + 1)
    }
  }
}
