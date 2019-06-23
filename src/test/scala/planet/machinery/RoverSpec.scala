package planet.machinery

import org.scalatest.{MustMatchers, WordSpec}

class RoverSpec extends WordSpec with MustMatchers {

  import Rover._
  import planet.machinery.orientation.North

  "Rover parser" must {

    "succeed on a well formatted string" in {

      val rover = parseAll(expr, "1 2 N")

      rover mustBe 'successful

      rover.get.direction mustEqual North

      val coordinates = rover.get.coordinates
      val xAxe = coordinates.x
      val yAxe = coordinates.y

      xAxe.x mustEqual 1
      yAxe.y mustEqual 2
    }

    "fail on a corrupted string" in {

      val seq: List[String] = "5" :: "5 3 2" :: "cd e" :: Nil

      all(seq.map(parseAll(expr, _))) mustNot be('successful)
    }
  }
}
