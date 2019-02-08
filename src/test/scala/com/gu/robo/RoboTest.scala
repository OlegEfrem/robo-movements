package com.gu.robo
import org.scalatest.{FreeSpec, Matchers, OptionValues}

class RoboTest extends FreeSpec with Matchers with OptionValues {
  import Direction._

  "Robo should" - {

    "be able to move north" in {
      val robo = Robo(Position(northSouth = 10))
      robo.move(N).position shouldBe Position(northSouth = 9)
    }

    "be able to move south" in {
      val robo = Robo(Position(northSouth = 1))
      robo.move(S).position shouldBe Position(northSouth = 2)
    }

    "be able to move east" in {
      val robo = Robo(Position(eastWest = 2))
      robo.move(E).position shouldBe Position(eastWest = 1)
    }

    "be able to move west" in {
      val robo = Robo(Position(eastWest = 2))
      robo.move(W).position shouldBe Position(eastWest = 3)
    }

    "not go outside boundaries" in {
      val robo10_10 = Robo(Position(10, 10))
      robo10_10.move(S).position shouldBe robo10_10.position
      robo10_10.move(W).position shouldBe robo10_10.position
      val robo_0_0 = Robo()
      robo_0_0.move(N).position shouldBe robo_0_0.position
      robo_0_0.move(E).position shouldBe robo_0_0.position
    }

  }

}
