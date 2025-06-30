package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{LogoutLink, MenuDropdown}
import locators.LoginLocators.{LoginLogo, expectedLoginLogoText}
import pages.LoginPage.{clickOn, verifyText, verifyUrl}

class LogoutStepDefs extends ScalaDsl with EN {

  When("""^the user opens the dropdown menu by clicking the three-line icon in the top left corner$""") { () =>
    clickOn(MenuDropdown)
  }

  And("""^the user clicks on the "Logout" option$""") { () =>
    clickOn(LogoutLink)
  }

  Then("""^the user should be redirected back to the the Swag Labs login page$""") {() =>
    verifyText(LoginLogo, expectedLoginLogoText)
    verifyUrl("https://www.saucedemo.com/")
  }

}