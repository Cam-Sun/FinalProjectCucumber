package support

import com.aventstack.extentreports.{ExtentTest, Status}
import io.cucumber.scala.{EN, ScalaDsl, Scenario}

object ExtendReportHook extends ScalaDsl with EN {
    var test: ExtentTest = _

    Before { scenario: Scenario =>
      test = ExtentManager.extent.createTest(scenario.getName)
    }


    After { scenario: Scenario =>
      if (scenario.isFailed) {
        test.log(Status.FAIL, "Scenario Failed")
      } else {
        test.log(Status.PASS, "Scenario Passed")
      }
      ExtentManager.extent.flush()
    }

}
