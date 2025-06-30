package utils

import org.openqa.selenium.{WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}

import java.time.Duration

object WaitUtils {

  def waitForElementVisible(driver: WebDriver, element: WebElement, timeoutSeconds: Long): WebElement = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
    wait.until(ExpectedConditions.visibilityOf(element))
  }

  def waitForElementClickable(driver: WebDriver, element: WebElement, timeoutSeconds: Long): WebElement = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
    wait.until(ExpectedConditions.elementToBeClickable(element))
  }

}
