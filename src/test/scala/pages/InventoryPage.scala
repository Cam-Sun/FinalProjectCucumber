package pages

import locators.InventoryLocators.{DropDown, ProductDescription, ProductImg, ProductLabel, ProductPrice}
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.ui.Select
import pages.LoginPage.{clickOn, driver, getText}

object InventoryPage extends BasePage {

 def verifyProductList(selector: By): Unit = {
   
   val products: List[WebElement] = getListOfWebElements(selector)
   println(products.size)
  val result: Boolean = products.forall(product=>{
     val img = product.findElement(ProductImg)
     val description = product.findElement(ProductDescription)
     val price = product.findElement(ProductPrice)
    if (img.isDisplayed && description.isDisplayed && price.isDisplayed) true
    else false
   })
   assert(result, "Product listing is empty")
 }


  def clickSortingOption(option: String): Unit = {
    //use the option string to find the option web element
    // and click on the web element
    val dropDownMenu: WebElement = getWebElement(DropDown)
    val select = new Select(dropDownMenu)
    select.selectByVisibleText(option)
  }


  def verifySortingOrder(sortingOption: String, selector: By): Unit = {
    val products: List[WebElement] = getListOfWebElements(selector)
    val nameList = products.map(product=>product.findElement(ProductLabel).getText)
      println(nameList)
//ascending
//    assert(nameList.sortBy((name))


    //nameListAZ, nameListZA, priceListAZ, priceListZA

  }



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
