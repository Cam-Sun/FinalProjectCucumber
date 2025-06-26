package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{expectedTitle, inventoryTitle}
import locators.LoginLocators.{LoginButton, errorMsgLocator, expectedErrorMsg}
import pages.LoginPage.{browserLaunch, clickOn, inputPassword, inputUsername, verifyText, verifyUrl}
import testdata.LoginData.{passwordData, usernameData}

class LoginStepDefs extends ScalaDsl with EN {

  Given("""^the user is on the Swag Labs login page$""") { () =>
    browserLaunch()
  }

  When("""^the user enters valid username and password$""") { () =>
    inputUsername(usernameData)
    inputPassword(passwordData)
  }

  And("""^the user clicks the login button$""") { () =>
    clickOn(LoginButton)
  }

  Then("""^the user should be logged in successfully$""") { () =>
    verifyText(inventoryTitle, expectedTitle)
  }

  And("""redirected to the product listing page""") { () =>
    verifyUrl("inventory.html")
  }

  When("""user enters invalid username: {string} and, or password: {string}""") { (username: String, password: String) =>
    inputUsername(username)
    inputPassword(password)
  }

  Then("""^the login should fail and an error message should be displayed$""") { () =>
    verifyText(errorMsgLocator, expectedErrorMsg)
  }
}