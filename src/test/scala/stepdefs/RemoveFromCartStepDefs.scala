package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{AddToCartButton, InventoryTitle, RemoveButton, ShoppingCartBadge, expectedAddToCartButtonText, expectedRemoveButtonText, expectedTitle}
import pages.InventoryPage.{addToCartSpecificProduct, goToProductDetailPage, removeFromCartSpecificProduct, verifyCartItemCount}
import pages.LoginPage.{clickOn, verifyText, verifyUrl}

class RemoveFromCartStepDefs extends ScalaDsl with EN {

  Given("""the the user is on the selected product {string} detail page and has previously added that product to the cart""") { (productName: String) =>
    verifyText(InventoryTitle, expectedTitle)
    goToProductDetailPage(productName)
    verifyUrl("inventory-item.html")
    clickOn(AddToCartButton)
  }

  When("""^the user clicks the "Remove" button$""") { () =>
    clickOn(RemoveButton)
  }

  Then("""^the item should be removed from the shopping cart$""") { () =>
    verifyCartItemCount(0, ShoppingCartBadge)
  }

  And("""^the "Remove" button should change to "Add to Cart"$""") { () =>
    verifyText(AddToCartButton, expectedAddToCartButtonText)
  }

  And("""the user has added the product {string} to the shopping cart""") { (itemName: String) =>
    addToCartSpecificProduct(itemName)
  }

  When("""the user clicks the "Remove" button for product {string}""") { (itemName: String) =>
    removeFromCartSpecificProduct(itemName)
  }













}