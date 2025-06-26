package pages

import org.openqa.selenium.By
import pages.LoginPage.{clickOn, driver, getText}

object InventoryPage {

  def selectProductByName(productName: String): Unit = {
    driver.findElement(By.xpath(s"//div[contains(text(),'$productName')]")).click()
  }

  def addToCartSpecificProduct(itemName: String): Unit = {
    val AddToCartSpecificProductButton: By = By.id(s"add-to-cart-$itemName")
    clickOn(AddToCartSpecificProductButton)
  }

  def verifyCartItemCount(cartBadgeLocator: By): Unit = {
    val numberOfItems: Int = getText(cartBadgeLocator).toInt
    assert(numberOfItems > 0 , s"Sorry try again, Cart is empty")
    println(numberOfItems)
  }

}
