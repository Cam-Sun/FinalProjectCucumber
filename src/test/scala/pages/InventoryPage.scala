package pages

import locators.InventoryLocators.{DropDown, ProductDescription, ProductImg, ProductLabel, ProductPrice}
import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.ui.Select


object InventoryPage extends BasePage {

  def elementFound(selector:By): Unit = {
    try{
      driver.findElement(selector)
      return true
    } catch{
      case e:NoSuchElementException => println

    }
  }

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
}
