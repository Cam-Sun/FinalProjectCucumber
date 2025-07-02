package stepdefs


import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{DropDown, Product}
import pages.InventoryPage.{clickOn, clickSortingOption, verifySortingOrder}


class SortListingStepDefs extends ScalaDsl with EN {

  When("""^the user clicks the dropdown menu$""") { () =>
    clickOn(DropDown)
  }

  And("""the user selects sorting option {string}""") { (sortingOption: String) =>
    clickSortingOption(sortingOption)

  }

  Then("""the products are sorted by the sorting option{string}""") { (sortingOption: String) =>
    verifySortingOrder(sortingOption, Product)
    println("tested")
  }

}