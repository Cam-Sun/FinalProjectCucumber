package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{ShoppingCart, ShoppingCartBadge}
import locators.YourCartLocators.Checkout
import pages.InventoryPage.{addToCartSpecificProduct, verifyCartItemCount}
import pages.LoginPage.{clickOn, verifyUrl}

class InitiateCheckoutStepdefs extends ScalaDsl with EN {

  Given("""Given the user has not added any products to the shopping cart""") { () =>
    verifyCartItemCount(0, ShoppingCartBadge)
  }

  And("""the user is on the cart page""") { () => {
    clickOn(ShoppingCart)
    verifyUrl("cart.html")
  }

  }
  When("""^the user clicks the checkout button$""") { () =>
    clickOn(Checkout)
  }

  Then("""the user should remain on the "Your Cart" page""") { () =>
    verifyUrl("cart.html")
  }

  Then("""the user should be directed to "Checkout: Your Information" page""") { () =>
    verifyUrl("checkout-step-one.html")
  }

  Given("""the user has added the products {string}, {string}, {string}, {string}, {string}, {string} to the shopping cart"""){ (product1:String, product2:String, product3:String, product4:String, product5:String, product6:String) =>
      addToCartSpecificProduct(product1)
      addToCartSpecificProduct(product2)
      addToCartSpecificProduct(product3)
      addToCartSpecificProduct(product4)
      addToCartSpecificProduct(product5)
      addToCartSpecificProduct(product6)
    }


}