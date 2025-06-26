Feature: Add to Cart Page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be logged in successfully
    And redirected to the product listing page

  Scenario Outline: User adds a product to the cart from the product detail page
    When the user clicks on the product "<product>" photo or name
    Then the user should be redirected to the selected product detail page
    When the user clicks the "Add to cart" button
    Then the item should be added to the shopping cart
    And the "Add to cart" button should change to "Remove"

    Examples:
      | product               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

  Scenario Outline: User adds a product to the cart from the listings page
    When the user clicks the "Add to cart" button for product "<product>"
    Then the item should be added to the shopping cart
    And the "Add to cart" button should change to "Remove"

    Examples:
      | product                  |
      | sauce-labs-onesie        |
      | sauce-labs-fleece-jacket |



