package pages

import locators.CartPageLocators.CartItem

class CartPage extends BasePage {
  def verifyItemsInCart(item: String, numberOfItems: Int): Unit = {
    val listOfCartItems = getListOfWebElements(CartItem)
    if (item.isEmpty) {
      assert(listOfCartItems.isEmpty, "Item found")
    }
    else assert(listOfCartItems.length == numberOfItems, "Number does not match")
  }
}
