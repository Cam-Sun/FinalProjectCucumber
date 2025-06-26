package stepdefs

import locators.InventoryLocators.Product
import io.cucumber.scala.{EN, ScalaDsl}
import pages.InventoryPage.verifyProductList

class BrowseringStepDefs extends ScalaDsl with EN {

  When("""the user is on the inventory page""") { () =>
    println("On the inventory page")
  }
  Then("""the user can view all products with images, names, and prices""") { () =>
    verifyProductList(Product)
  }
}