package stepdefs

import locators.InventoryLocators.Product
import io.cucumber.scala.{EN, ScalaDsl}
import pages.InventoryPage.verifyProductList

class BrowseringStepDefs extends ScalaDsl with EN {

  Then("""the user can view all products with images, names, and prices""") { () =>
    verifyProductList(Product)
  }
}