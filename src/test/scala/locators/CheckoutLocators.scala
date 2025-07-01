package locators

import org.openqa.selenium.By

object CheckoutLocators {
  val FirstName : By = By.id("first-name")
  val LastName: By = By.id("last-name")
  val PostalCode:By = By.id("postal-code")
  val Continue: By= By.id("continue")
  val Error: By = By.className("error-button")
  val Finish:By= By.id("finish")
  val ItemTotal:By= By.className("summary_total_label")
  val checkoutCompleted = "checkout-complete.html"
  val checkoutOverview = "checkout-step-two.html"
}
