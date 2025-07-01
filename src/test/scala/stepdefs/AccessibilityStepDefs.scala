package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.AboutLocators.{AboutHeader, expectedAboutHeaderText}
import locators.InventoryLocators.{AboutLink, InventoryLink, InventoryTitle, ShoppingCart, expectedTitle}
import locators.ProductDetailLocators.{BackToProductsButton, expectedBackToProductsButtonText}
import pages.InventoryPage.{goToProductDetailPage, hoversOverProductName, verifyHoverChangesOnProductName}
import pages.LoginPage.{clickOn, hoversOver, verifyHoverChanges, verifyText, verifyUrl}

class AccessibilityStepDefs extends ScalaDsl with EN {

  Given("""^the user is logged in successfully and is in the product listings page$""") { () =>
    verifyText(InventoryTitle, expectedTitle)
    verifyUrl("inventory.html")
  }


  When("""the user hovers over the product {string} name""") { (product_name: String) =>
    hoversOverProductName(product_name)
  }

  Then("""the product {string} name should visibly indicate it is clickable with a colour change""") { (product_name: String) =>
    verifyHoverChangesOnProductName(product_name)
  }

  When("""the user clicks the product {string} name""") { (product_name: String) =>
    goToProductDetailPage(product_name)
  }

  Then("""^the user is redirected to the selected product detail page$""") { () =>
    verifyText(BackToProductsButton, expectedBackToProductsButtonText)
    verifyUrl("inventory-item.html")
  }


  When("""^the user hovers over the "Back to products" link$""") { () =>
    hoversOver(BackToProductsButton)
  }

  Then("""^the link should visibly indicate it is clickable with colour change$""") { () =>
    verifyHoverChanges(BackToProductsButton)
  }

  When("""^the user clicks the "Back to products" link$""") { () =>
    clickOn(BackToProductsButton)
  }

  Then("""^the user should be redirected to the product listings page$""") { () =>
    verifyText(InventoryTitle, expectedTitle)
    verifyUrl("inventory.html")
  }

  And("""^the user clicks on the "About" option$""") { () =>
    clickOn(AboutLink)
  }

  Then("""the user should be redirected to the the "About" page""") { () =>
    verifyText(AboutHeader, expectedAboutHeaderText)
    verifyUrl("saucelabs.com")
  }

  Given("""^the user is in a different page from "Product listings"$""") { () =>
    clickOn(ShoppingCart)
    verifyUrl("cart.html")
  }

  And("""^the user clicks on the "All items" option$""") { () =>
    clickOn(InventoryLink)
  }


}