package support

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.chrome.ChromeDriver

class Hooks extends ScalaDsl with EN {

  Before {
    println("Launching browser before scenario...")
    DriverManager.driver = new ChromeDriver()
    DriverManager.driver.manage().window().maximize()
  }

  After {
    DriverManager.quitDriver()
  }

}
