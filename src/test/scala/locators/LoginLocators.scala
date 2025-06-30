package locators

import org.openqa.selenium.By

object LoginLocators {

  val UsernameLocator: By = By.id("user-name")
  val PasswordLocator: By = By.id("password")
  val LoginButton: By = By.id("login-button")

  val ErrorMsgLocator: By = By.cssSelector("h3[data-test='error']")
  val expectedErrorMsg: String = "Epic sadface:"
  val expectedBlockedUserErrorMsg: String = "this user has been locked out"


}
