package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.CheckoutLocators.{Continue, FirstName, InfoPageError, LastName, PostalCode}
import locators.InventoryLocators.ShoppingCart
import locators.YourCartLocators.Checkout
import pages.InventoryPage.addToCartSpecificProduct
import pages.LoginPage.{clickOn, inputText, verifyText, verifyUrl}

class YourInfoStepdefs extends ScalaDsl with EN {

  Given("""the user has added the {string} to the cart and has clicked the checkout button on the cart page""") { (product: String) =>
    addToCartSpecificProduct(product)
    clickOn(ShoppingCart)
    verifyUrl("cart.html")
    clickOn(Checkout)

  }

  When("""the user enters {string}, {string}, {string}""") { (firstName: String, lastName: String, postalCode: String) =>
    inputText(FirstName, firstName)
    inputText(LastName, lastName)
    inputText(PostalCode, postalCode)
  }

  And("""the user clicks the "Continue" button""") { () =>
    clickOn(Continue)
  }

  Then("""the user should be directed to "Checkout: Overview" page""") { () =>
    verifyUrl("checkout-step-two.html")
  }

  Then("""error message is displayed"""){ () =>
    verifyText(InfoPageError, "Error")
  }


}