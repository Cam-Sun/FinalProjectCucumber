package locators

import org.openqa.selenium.By

object CartPageLocators {
  val TitleOfCartPage: By = By. cssSelector("span[class='title']")
  val Checkout:By = By.id("checkout")
  val CartItemContainer :By = By.className("cart_item")
  val CartItem :By = By.className("cart_item")
}

