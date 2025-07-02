package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.CheckoutLocators._
import locators.InventoryLocators.ShoppingCart
import locators.YourCartLocators.Checkout
import pages.CheckoutPage.{VerifySubtotal, verifyOrderItems}
import pages.InventoryPage.addToCartSpecificProduct
import pages.LoginPage.{clickOn, inputText, verifyUrl}

class FinishCheckoutStepdefs extends ScalaDsl with EN {

  Given("""the user has added the {string}, {string}, {string} to the cart, entered {string}, {string}, {string}""") { (product1: String, product2: String, product3: String, firstName: String, lastName: String, postalCode: String) =>
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
  When("""the user navigates to checkout overview page""") { () =>
    verifyUrl(checkoutOverview)
  }

  Then("""the order items match the products added to cart {string}, {string}, {string}""") { (product1: String, product2: String, product3: String) =>
    verifyOrderItems(ItemName, List(product1, product2, product3))
  }

  And("the subtotal amount matches the sum of product prices") { () =>
    VerifySubtotal(ItemPrice, Subtotal)
  }

  When("""^the user clicks the "Finish" button$""") { () =>
    clickOn(Finish)
  }

  Then("""the user is redirected to the "Checkout: Complete!" page""") { () =>
    verifyUrl(checkoutCompleted)
  }
}