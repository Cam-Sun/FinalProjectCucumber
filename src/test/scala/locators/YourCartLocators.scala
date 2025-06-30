package locators

import org.openqa.selenium.By

object YourCartLocators {

  val CartTitle: By = By.cssSelector("span[data-test='title']")
  val expectedCartTitle: String = "Your Cart"

}
