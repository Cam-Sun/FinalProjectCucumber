package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{FacebookLink, LinkedInLink, TwitterLink}
import pages.LoginPage.{clickOn, verifyUrl, verifyUrlInNewWindow}

class SocialMediaNavigationStepDefs extends ScalaDsl with EN {

  When("""^the user clicks the "X" icon on the footer$""") { () =>
    clickOn(TwitterLink)
  }

  Then("""^the user is redirected to the the "X" Sauce Labs social media page$""") { () =>
    verifyUrlInNewWindow("https://x.com/saucelabs")
  }

  When("""^the user clicks the "Facebook" icon on the footer$""") { () =>
    clickOn(FacebookLink)
  }

  Then("""^the user is redirected to the the "Facebook" Sauce Labs social media page$""") { () =>
    verifyUrlInNewWindow("https://www.facebook.com/saucelabs")
  }

  When("""^the user clicks the "LinkedIn" icon on the footer$""") { () =>
    clickOn(LinkedInLink)
  }

  Then("""^the user is redirected to the the "LinkedIn" Sauce Labs social media page$""") { () =>
    verifyUrlInNewWindow("https://www.linkedin.com/company/sauce-labs/")
  }


}