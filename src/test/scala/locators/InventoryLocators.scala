package locators

import org.openqa.selenium.By

object InventoryLocators {

  val InventoryTitle: By = By.cssSelector("span[data-test='title']")
  val expectedTitle: String = "Products"

  val ShoppingCartBadge: By = By.className("shopping_cart_badge")

  val RemoveButton: By = By.xpath("//button[contains(@name, 'remove')]")
  val expectedRemoveButtonText: String = "Remove"




}
