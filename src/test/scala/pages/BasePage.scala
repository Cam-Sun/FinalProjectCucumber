package pages

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import support.DriverManager
import utils.ConfigReader
import utils.WaitUtils.{waitForElementClickable, waitForElementVisible}

import java.time.Duration
import scala.jdk.CollectionConverters.CollectionHasAsScala

trait BasePage {

  def driver: WebDriver = DriverManager.driver

  def js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]

  def browserLaunch(): Unit = {
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
  }

  def inputText(selector: By, text: String): Unit =
    driver.findElement(selector).sendKeys(text)

  def clickOn(selector: By): Unit = {
    waitForElementClickable(driver, getWebElement(selector), 10).click()
  }

  def hoversOver(locator: By): Unit = {
    val element: WebElement = waitForElementVisible(driver, getWebElement(locator), 10)
    val actions = new Actions(driver)
    actions.moveToElement(element).perform()
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
    val currentUrl: String = driver.getCurrentUrl
    assert(currentUrl.contains(urlFragment), s"URL check failed: expected to find '$urlFragment' in '$currentUrl'")
  }

  def verifyUrlInNewWindow(urlFragment: String): Unit = {
    val originalWindow = driver.getWindowHandle

    // Wait for new window and switch to it
    new WebDriverWait(driver, Duration.ofSeconds(10)).until { _ =>
      driver.getWindowHandles.size > 1
    }
    val newWindow = driver.getWindowHandles.asScala.find(_ != originalWindow).get
    driver.switchTo().window(newWindow)

    val currentUrl = driver.getCurrentUrl
    assert(currentUrl.contains(urlFragment), s"URL check failed: expected to find '$urlFragment' in '$currentUrl'")
  }


  def verifyHoverChanges(locator: By): Unit = {
    val element: WebElement = waitForElementVisible(driver, getWebElement(locator), 10)
    js.executeScript("arguments[0].style.color = '#18583a';", element)

    val initialColour: String = element.getCssValue("color")
    hoversOver(locator)

    js.executeScript("arguments[0].style.color = '';", element)
    val hoverColour: String = element.getCssValue("color")
    assert(initialColour != hoverColour, s"Expected color to change on hover, but it did not. Value remained '$initialColour'")
  }
}
