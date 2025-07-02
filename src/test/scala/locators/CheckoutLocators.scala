package locators

import org.openqa.selenium.By

object CheckoutLocators {
  val FirstName : By = By.id("first-name")
  val LastName: By = By.id("last-name")
  val PostalCode:By = By.id("postal-code")
  val Continue: By= By.id("continue")
  val InfoPageError: By = By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3")
  val Finish:By= By.id("finish")
  val ItemTotal:By= By.className("summary_total_label")
  val checkoutCompleted = "checkout-complete.html"
  val checkoutOverview = "checkout-step-two.html"
  val Subtotal:By = By.className("summary_subtotal_label")
  val ItemPrice:By = By.className("inventory_item_price")
  val ItemName:By = By.className("inventory_item_name")
}
