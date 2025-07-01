package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.CheckoutLocators.{Continue, Finish, FirstName, LastName, PostalCode}
import locators.InventoryLocators.ShoppingCart
import locators.YourCartLocators.Checkout
import pages.InventoryPage.addToCartSpecificProduct
import pages.LoginPage.{clickOn, inputText, verifyUrl}

class FinishCheckoutStepdefs extends ScalaDsl with EN {

  Given("""the user has added the {string}, {string}, {string} to the cart, entered {string}, {string}, {string} and is on the Checkout: Overview page""") { (product1: String, product2: String, product3: String, firstName: String, lastName: String, postalCode: String) =>
    addToCartSpecificProduct(product1)
    addToCartSpecificProduct(product2)
    addToCartSpecificProduct(product3)
    clickOn(ShoppingCart)
    verifyUrl("cart.html")
    clickOn(Checkout)
    verifyUrl("checkout-step-one.html")
    inputText(FirstName, firstName)
    inputText(LastName, lastName)
    inputText(PostalCode, postalCode)
    clickOn(Continue)
  }

  When("""^the user clicks the "Finish" button$""") { () =>
    clickOn(Finish)
  }

  Then("""the user is redirected to the "Checkout: Complete!" page""") {
    verifyUrl("checkout-complete.html")
  }
}