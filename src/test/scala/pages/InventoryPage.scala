package pages

import locators.InventoryLocators._
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.{By, WebElement}

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
    //println("nameList: " + nameList)
    val priceList = products.map(product=>product.findElement(ProductPrice).getText.drop(1).toDouble)
    println("priceList: " + priceList)
    sortingOption match {
      case "Name (A to Z)" => assert(nameList.sorted == nameList, s"products are not sorted in $sortingOption order")
      case "Name (Z to A)" => assert(nameList.sorted.reverse == nameList, s"products are not sorted in $sortingOption order")
      case "Price (low to high)" => assert(priceList.sorted == priceList, s"products are not sorted in $sortingOption order")
      case "Price (high to low)" => println(priceList.sorted.reverse == priceList,s"products are not sorted in $sortingOption order" )
    }
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
