package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.InventoryLocators.{DropDown, Product}
import pages.InventoryPage.{clickOn, clickSortingOption, verifySortingOrder}

class SortListingStepDefs extends ScalaDsl with EN {

  When("""^the user clicks the dropdown menu$""") { () =>
    //pass the locator of DropDown and click it
    clickOn(DropDown)
  }

  And("""the user selects sorting option {string}""") { (sortingOption:String) =>
// pass the option
  clickSortingOption(sortingOption)

  }

  Then("""the products are sorted by the sorting option{string}"""){(sortingOption:String)=>{
//verify the order of the sorted products

    verifySortingOrder(sortingOption,Product)
    println("tested")
  }}




}