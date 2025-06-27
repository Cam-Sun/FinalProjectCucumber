Feature: Add to Cart Page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario Outline: User adds a product to the cart from the product detail page
    Given the the user is on the selected product "<product>" detail page
    When the user clicks the "Add to cart" button
    Then the item should be added to the shopping cart
    And the "Add to cart" button should change to "Remove"

    Examples:
      | product               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

  Scenario Outline: User adds a product to the cart from the listings page
    Given the user is logged in successfully and is in the product listings page
    When the user clicks the "Add to cart" button for product "<product>"
    Then the item should be added to the shopping cart
    And the "Add to cart" button should change to "Remove"

    Examples:
      | product                  |
      | sauce-labs-onesie        |
      | sauce-labs-fleece-jacket |



