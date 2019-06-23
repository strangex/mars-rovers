package control.center

import org.scalatest.prop.PropertyChecks
import org.scalatest.{MustMatchers, WordSpec}

class CommandSpec extends WordSpec with MustMatchers with PropertyChecks {

  "Command" must {

    "be a Move Command upon M flag" in {

      Command('M') mustEqual Move
    }

    "be a Left Spin upon L flag" in {

      Command('L') mustEqual Left
    }

    "be a Right spin upon R flag" in {

      Command('R') mustEqual Right
    }

    "be an UndefinedCommand upon any other flag" in {

      forAll("flag") { flag: Char =>

        whenever(flag != 'M' && flag != 'L' && flag != 'R') {

          Command(flag) mustEqual UndefinedCommand
        }
      }
    }
  }
}
