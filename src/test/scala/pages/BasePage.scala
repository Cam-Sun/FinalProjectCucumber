package pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import support.DriverManager
import utils.ConfigReader
import utils.WaitUtils.waitForElementVisible

trait BasePage {

  def driver: WebDriver = DriverManager.driver

  def browserLaunch(): Unit = {
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
  }

  def inputText(selector: By, text: String): Unit =
    driver.findElement(selector).sendKeys(text)

  def clickOn(selector: By): Unit = {
    driver.findElement(selector).click()
  }

  def getText(selector: By): String =
    driver.findElement(selector).getText

  def getWebElement(selector: By): WebElement =
    driver.findElement(selector)

  def verifyText(textLocator: By, expectedHeader: String): Unit = {
    waitForElementVisible(driver, getWebElement(textLocator), 10)
    assert(getText(textLocator).contains(expectedHeader) , "Verification failed: The actual text does not match the expected value")
  }

  def verifyUrl(urlFragment: String): Unit = {
    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains(urlFragment), s"URL check failed: expected to find '$urlFragment' in '$currentUrl'")
  }



}
