package support

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.reporter.ExtentSparkReporter

object ExtentManager {
  private val htmlReporter = new ExtentSparkReporter("target/extent-report.html")
  htmlReporter.config().setReportName("Test Report")

  val extent: ExtentReports = new ExtentReports()
  extent.attachReporter(htmlReporter)
}
