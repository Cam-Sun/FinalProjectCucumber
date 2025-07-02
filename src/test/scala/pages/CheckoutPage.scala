package pages

import org.openqa.selenium.By

object CheckoutPage extends BasePage {
  def VerifySubtotal(priceLocator: By, subTotalLocator: By): Unit = {
    val priceLabelList = getListOfWebElements(priceLocator)
    val sumOfProductPrices = priceLabelList.map(priceLabel => priceLabel.getText.substring(1).toDouble).sum
    val subTotalAmount = getText(subTotalLocator).replace("Item total: $", "").trim.toDouble
    assert(subTotalAmount == sumOfProductPrices, "Subtotal amount does not match the sum of product prices")
  }

  def verifyOrderItems(itemNameLocator: By, testProductNames: List[String]): Unit = {
    val purchaseOrderItems = getListOfWebElements(itemNameLocator).map(_.getText)
    val addedToCartItems = testProductNames.filter(_.nonEmpty)
    assert(purchaseOrderItems == addedToCartItems, "Order item list does not match")
  }
}
