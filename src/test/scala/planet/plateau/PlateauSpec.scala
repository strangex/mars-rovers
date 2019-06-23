package planet.plateau

import org.scalatest.{MustMatchers, WordSpec}

class PlateauSpec extends WordSpec with MustMatchers {

  import Plateau._

  "Plateau parser" must {

    "succeed on a well formatted string" in {

      val plateau = parseAll(expr, "2 5")

      plateau mustBe 'successful

      plateau.get.width.w mustEqual 2
      plateau.get.height.h mustEqual 5
    }

    "fail on a corrupted string" in {

      val seq: List[String] = "5" :: "5 3 2" :: "cd e" :: Nil

      all(seq.map(parseAll(expr, _))) mustNot be('successful)
    }
  }
}
