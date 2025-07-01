@cart
Feature: Remove from Cart

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario Outline: User adds a product to the cart from the product detail page
    Given the the user is on the selected product "<product>" detail page and has previously added that product to the cart
    When the user clicks the "Remove" button
    Then the item should be removed from the shopping cart
    And the "Remove" button should change to "Add to Cart"

    Examples:
      | product               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

  Scenario Outline: User adds a product to the cart from the listings page
    Given the user is logged in successfully and is in the product listings page
    And the user has added the product "<product>" to the shopping cart
    When the user clicks the "Remove" button for product "<product>"
    Then the item should be removed from the shopping cart
    And the "Remove" button should change to "Add to Cart"

    Examples:
      | product                  |
      | Sauce Labs Onesie        |
      | Sauce Labs Fleece Jacket |



