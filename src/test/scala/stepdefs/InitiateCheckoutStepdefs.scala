package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{ShoppingCart, ShoppingCartBadge}
import locators.YourCartLocators.{CartTitle, Checkout, expectedCartTitle}
import pages.InventoryPage.{addToCartSpecificProduct, verifyCartItemCount}
import pages.LoginPage.{clickOn, verifyText, verifyUrl}

class InitiateCheckoutStepdefs extends ScalaDsl with EN {

  Given("""Given the user has not added any products to the shopping cart""") { (product_name1: String, product_name2: String) =>
    verifyCartItemCount(0, ShoppingCartBadge)
  }

  When("""^the user clicks on the shopping cart icon$""") { () =>
    clickOn(ShoppingCart)
  }

  Then("""^the user should be redirected to the "Your Cart" page$""") { () =>
    verifyText(CartTitle, expectedCartTitle)
    verifyUrl("cart.html")
  }

 When("""^the user clicks the checkout button$""") { () =>
    clickOn(Checkout)
  }

  Then("""the user should remain on the "Your Cart" page """){

  }
  Given("""the user has added the product {string} to the shopping cart"""){(product:String)=>
    addToCartSpecificProduct(product)
  }


  Then ("""the user should be directed to "Checkout: Your Information" page"""){
    verifyUrl("cart.html")
  }


}