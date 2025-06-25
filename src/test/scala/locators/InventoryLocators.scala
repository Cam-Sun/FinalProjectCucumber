package locators

import org.openqa.selenium.By

object InventoryLocators {

  val inventoryTitle: By = By.cssSelector("span[data-test='title']")
  val expectedTitle: String = "Products"


}
