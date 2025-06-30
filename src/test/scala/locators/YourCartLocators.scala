package locators

import org.openqa.selenium.By

object YourCartLocators {

  val CartTitle: By = By.cssSelector("span[data-test='title']")
  val expectedCartTitle: String = "Your Cart"
  val Checkout: By = By.id("checkout")
  val CartItemContainer: By = By.className("cart_item")

}
