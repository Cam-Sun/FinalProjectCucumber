package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{RemoveButton, ShoppingCartBadge, expectedRemoveButtonText}
import pages.InventoryPage.{addToCartSpecificProduct, selectProductByName, verifyCartItemCount}
import pages.LoginPage.{clickOn, verifyText, verifyUrl}
import pages.ProductDetailPage.AddToCartButton

class AddToCartStepDefs extends ScalaDsl with EN {

  When("""the user clicks on the product {string} photo or name""") { (productName: String) =>
    selectProductByName(productName)
  }

  Then("""^the user should be redirected to the selected product detail page$""") { () =>
    verifyUrl("inventory-item.html")
  }

  When("""^the user clicks the "Add to cart" button$""") { () =>
    clickOn(AddToCartButton)
  }

  Then("""^the item should be added to the shopping cart$""") { () =>
    verifyCartItemCount(ShoppingCartBadge)
  }

  And("""the "Add to cart" button should change to "Remove"""") { () =>
    verifyText(RemoveButton, expectedRemoveButtonText)
  }

  When("""the user clicks the "Add to cart" button for product {string}""") { (itemName: String) =>
    addToCartSpecificProduct(itemName)
  }

}