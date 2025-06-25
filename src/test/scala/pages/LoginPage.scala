package pages

import locators.LoginLocators.{PasswordLocator, UsernameLocator}

object LoginPage extends BasePage {

  def inputUsername(text: String): Unit =
    inputText(UsernameLocator, text)

  def inputPassword(text: String): Unit = {
    inputText(PasswordLocator, text)
  }

}
