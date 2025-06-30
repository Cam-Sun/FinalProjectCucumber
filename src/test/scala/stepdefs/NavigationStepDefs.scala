package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{InventoryTitle, expectedTitle}
import locators.ProductDetailLocators.{BackToProductsButton, expectedBackToProductsButtonText}
import pages.InventoryPage.goToProductDetailPage
import pages.LoginPage.{verifyText, verifyUrl}

class NavigationStepDefs extends ScalaDsl with EN {

  Given("""^the user is logged in successfully and is in the product listings page$""") { () =>
    verifyText(InventoryTitle, expectedTitle)
    verifyUrl("inventory.html")
  }

  When("""the user clicks on the product {string} photo or name""") { (productName: String) =>
    goToProductDetailPage(productName)
  }

  Then("""^the user is redirected to the selected product detail page$""") { () =>
    verifyUrl("inventory-item.html")
    verifyText(BackToProductsButton, expectedBackToProductsButtonText)
  }

}