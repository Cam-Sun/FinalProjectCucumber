package pages

import org.openqa.selenium.{By, WebDriver, WebElement}
import support.DriverManager
import utils.ConfigReader
import utils.WaitUtils.{waitForElementClickable, waitForElementVisible}

import scala.jdk.CollectionConverters.CollectionHasAsScala

trait BasePage {

  def driver: WebDriver = DriverManager.driver

  def browserLaunch(): Unit = {
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
  }

  def inputText(selector: By, text: String): Unit =
    driver.findElement(selector).sendKeys(text)

  def clickOn(selector: By): Unit = {
    waitForElementClickable(driver, getWebElement(selector), 10).click()
  }

  def getText(selector: By): String =
    driver.findElement(selector).getText

  def getWebElement(selector: By): WebElement =
    driver.findElement(selector)


  def getListOfWebElements(selector: By): List[WebElement] =
    driver.findElements(selector).asScala.toList


  def verifyText(textLocator: By, expectedHeader: String): Unit = {
    waitForElementVisible(driver, getWebElement(textLocator), 10)
    assert(getText(textLocator).contains(expectedHeader), "Verification failed: The actual text does not match the expected value")
  }

  def verifyUrl(urlFragment: String): Unit = {
    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains(urlFragment), s"URL check failed: expected to find '$urlFragment' in '$currentUrl'")
  }

  def verifyURLWithCustomerizedMsg(urlFragment: String, msg:String): Unit = {
    val currentUrl = driver.getCurrentUrl
    assert(!currentUrl.contains(urlFragment), msg)
  }


}
