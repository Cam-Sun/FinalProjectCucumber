package pages

import org.openqa.selenium.By

import scala.jdk.CollectionConverters.CollectionHasAsScala

object YourCartPage extends BasePage {

  def verifyCartProducts(expectedProductNames: List[String]): Unit = {
    val actualCartItems: List[String] = driver.findElements(By.cssSelector(".inventory_item_name")).asScala
      .map(_.getText)
      .toList
    actualCartItems.foreach { actualName =>
      assert(expectedProductNames.contains(actualName), s"Expected product $actualName not found")
    }
    assert(actualCartItems.size == expectedProductNames.size, s"Expected ${expectedProductNames.size} products in the cart, but found ${actualCartItems.size}.")
  }
}
