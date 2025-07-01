package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{ShoppingCart, ShoppingCartBadge}
import locators.YourCartLocators.Checkout
import pages.InventoryPage.verifyCartItemCount
import pages.LoginPage.{clickOn, verifyUrl}

class InitiateCheckoutStepdefs extends ScalaDsl with EN {

  Given("""Given the user has not added any products to the shopping cart""") { (product_name1: String, product_name2: String) =>
    verifyCartItemCount(0, ShoppingCartBadge)
  }

  And("""the user is on the cart page"""){()=>{
    clickOn(ShoppingCart)
    verifyUrl("cart.html")
  }

  }
 When("""^the user clicks the checkout button$""") { () =>
    clickOn(Checkout)
  }

  Then("""the user should remain on the "Your Cart" page"""){
    verifyUrl("cart.html")
  }


  Then ("""the user should be directed to "Checkout: Your Information" page"""){
    verifyUrl("checkout-step-one.html")
  }


}