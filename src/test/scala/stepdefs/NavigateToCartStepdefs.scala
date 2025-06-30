package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{InventoryTitle, ShoppingCart, expectedTitle}
import pages.InventoryPage.clickOn
import pages.LoginPage.{verifyText, verifyUrl}
class NavigateToCartStepdefs extends ScalaDsl with EN {
  Given("""^the user is logged in successfully and is in the product listings page$""") { () =>
    verifyText(InventoryTitle, expectedTitle)
    verifyUrl("inventory.html")
  }

  When ("""the user clicks the shopping cart icon"""){
clickOn(ShoppingCart)
  }

  Then("""the user is redirected to the shopping cart page"""){
    verifyUrl("cart.html")
  }

  And("""no cart item is displayed"""){

  }
}