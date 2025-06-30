package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{AddToCartButton, InventoryTitle, RemoveButton, ShoppingCartBadge, expectedRemoveButtonText, expectedTitle}
import pages.InventoryPage.{addToCartSpecificProduct, goToProductDetailPage, verifyCartItemCount}
import pages.LoginPage.{clickOn, verifyText, verifyUrl}

class AddToCartStepDefs extends ScalaDsl with EN {

  Given("""the the user is on the selected product {string} detail page""") { (productName: String) =>
    verifyText(InventoryTitle, expectedTitle)
    goToProductDetailPage(productName)
    verifyUrl("inventory-item.html")
  }

  When("""^the user clicks the "Add to cart" button$""") { () =>
    clickOn(AddToCartButton)
  }

  Then("""^the item should be added to the shopping cart$""") { () =>
    verifyCartItemCount(1, ShoppingCartBadge)
  }

  And("""the "Add to cart" button should change to "Remove"""") { () =>
    verifyText(RemoveButton, expectedRemoveButtonText)
  }

  When("""the user clicks the "Add to cart" button for product {string}""") { (itemName: String) =>
    addToCartSpecificProduct(itemName)
  }

}