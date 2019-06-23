package util

import org.rogach.scallop.exceptions.UnknownOption
import org.scalacheck.Gen
import org.scalacheck.Gen.alphaStr
import org.scalatest.prop.PropertyChecks
import org.scalatest.{MustMatchers, WordSpec}
import wolfendale.scalacheck.regexp.RegexpGen

class ConfigSpec extends WordSpec with MustMatchers with PropertyChecks {

  "Config" must {

    "have ./universe.dat as default path" in {

      val config = new Config(Nil)

      config.path() mustEqual "./universe.dat"
    }

    "successfully parse the provided path" in {

      val flag: Gen[String] = Gen.oneOf("-F", "--path")

      forAll((flag, "flag"), (alphaStr, "path")) { (flag: String, path: String) =>

        val config = new Config(flag :: path :: Nil)

        config.path() mustEqual path
      }
    }

    "throw an UnknownOption exception on invalid short arguments" in {

      val flagGen: Gen[String] =
        RegexpGen.from("^-{1,2}[[:word:]]{1,6}$")

      forAll((flagGen, "flag")) { flag =>

        whenever(flag != "-F" && flag != "--path") {

          an[UnknownOption] must be thrownBy
            new Config(flag :: "path" :: Nil)
        }
      }
    }
  }
}

