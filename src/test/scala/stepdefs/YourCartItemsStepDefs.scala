package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{ShoppingCart, ShoppingCartBadge}
import locators.YourCartLocators.{CartTitle, expectedCartTitle}
import pages.InventoryPage.{addToCartSpecificProduct, verifyCartItemCount}
import pages.LoginPage.{clickOn, verifyText, verifyUrl}
import pages.YourCartPage.verifyCartProducts

class YourCartItemsStepDefs extends ScalaDsl with EN {

  Given("""the user has added the products {string} and {string} to the shopping cart""") { (product_name1: String, product_name2: String) =>
    addToCartSpecificProduct(product_name1)
    addToCartSpecificProduct(product_name2)
  }

  When("""^the user clicks on the shopping cart icon$""") { () =>
    clickOn(ShoppingCart)
  }

  Then("""^the user should be redirected to the "Your Cart" page$""") { () =>
    verifyText(CartTitle, expectedCartTitle)
    verifyUrl("cart.html")
  }

  And("""the shopping cart should display the products {string} and {string}""") { (product_name1: String, product_name2: String) =>
    verifyCartProducts(List(product_name1, product_name2))
  }


  Given("""^the user has not added any products to the cart$""") { () =>
    verifyCartItemCount(0, ShoppingCartBadge)
  }

  And("""^the cart should be empty and not display any product$""") { () =>
    verifyCartProducts(List())
  }











}