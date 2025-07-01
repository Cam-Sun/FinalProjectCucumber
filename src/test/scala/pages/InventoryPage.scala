package pages

import locators.InventoryLocators._
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, JavascriptExecutor, WebElement}
import utils.FormatConversion.normalizeProductName
import utils.WaitUtils.waitForElementVisible

object InventoryPage extends BasePage {


  def verifyProductList(selector: By): Unit = {

    val products: List[WebElement] = getListOfWebElements(selector)
    println(products.size)
    val result: Boolean = products.forall(product => {
      val img = product.findElement(ProductImg)
      val description = product.findElement(ProductDescription)
      val price = product.findElement(ProductPrice)
      if (img.isDisplayed && description.isDisplayed && price.isDisplayed) true
      else false
    })
    assert(result, "Product listing is empty")
  }


  def clickSortingOption(option: String): Unit = {
    val dropDownMenu: WebElement = getWebElement(DropDown)
    val select = new Select(dropDownMenu)
    select.selectByVisibleText(option)
  }


  def verifySortingOrder(sortingOption: String, selector: By): Unit = {
    val products: List[WebElement] = getListOfWebElements(selector)
    val nameList = products.map(product => product.findElement(ProductLabel).getText)
    val priceList = products.map(product => product.findElement(ProductPrice).getText.drop(1).toDouble)
    sortingOption match {
      case "Name (A to Z)" => assert(nameList.sorted == nameList, s"products are not sorted in $sortingOption order")
      case "Name (Z to A)" => assert(nameList.sorted.reverse == nameList, s"products are not sorted in $sortingOption order")
      case "Price (low to high)" => assert(priceList.sorted == priceList, s"products are not sorted in $sortingOption order")
      case "Price (high to low)" => assert(priceList.sorted.reverse == priceList, s"products are not sorted in $sortingOption order")
    }
  }


  def goToProductDetailPage(productName: String): Unit = {
    driver.findElement(By.xpath(s"//div[contains(text(),'$productName')]")).click()
  }

  def addToCartSpecificProduct(itemName: String): Unit = {
    if(itemName.isEmpty) {}
    else {
      val idItemName: String = normalizeProductName(itemName)
      val AddToCartSpecificProductButton: By = By.id(s"add-to-cart-$idItemName")
      clickOn(AddToCartSpecificProductButton)
    }
  }

  def removeFromCartSpecificProduct(itemName: String): Unit = {
    val idItemName: String = normalizeProductName(itemName)
    val RemoveFromCartSpecificProductButton: By = By.id(s"remove-$idItemName")
    clickOn(RemoveFromCartSpecificProductButton)
  }



  def verifyCartItemCount(expectedCount: Int, cartBadgeLocator: By): Unit = {
    if (expectedCount == 0) {
      assert(getListOfWebElements(cartBadgeLocator).isEmpty, "Expected empty cart, but cart is not empty.")
    }
    else {
      val numberOfItems: Int = getText(cartBadgeLocator).toInt
      assert(numberOfItems == expectedCount, s"Expected $expectedCount items, but found $numberOfItems")
    }
  }

    def hoversOverProductName(productName: String): Unit = {
      val element: WebElement = waitForElementVisible(driver, getWebElement(By.xpath(s"//div[contains(text(),'$productName')]")), 10)
      val actions = new Actions(driver)
      actions.moveToElement(element).perform()
    }

  def verifyHoverChangesOnProductName(productName: String): Unit = {
    val js = driver.asInstanceOf[JavascriptExecutor]

    val nameLink: WebElement = waitForElementVisible(driver, getWebElement(By.xpath(s"//div[contains(text(),'$productName')]")), 10)
    js.executeScript("arguments[0].style.color = '#18583a';", nameLink)

    val initialColour: String = nameLink.getCssValue("color")
    hoversOverProductName(productName)

    js.executeScript("arguments[0].style.color = '';", nameLink)
    val hoverColour: String = nameLink.getCssValue("color")

    assert(initialColour != hoverColour, s"Expected colour to change on hover, but it did not. Value remained '$initialColour'")
  }


}
