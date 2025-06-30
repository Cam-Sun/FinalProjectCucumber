Feature: User initiates checkout

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario: User should not be able to checkout when no item is in the cart
    Given the user has not added any products to the shopping cart
    When the user clicks the shopping cart icon
    Then the user should be redirected to the cart page
    When the user clicks the checkout button
    Then the user should remain on the "Your Cart" page


  Scenario Outline: User can initiate checkout when one item is in the cart
    Given the user has added the product "<product>" to the shopping cart
    When the user clicks the shopping cart icon
    Then the user should be redirected to the cart page
    When the user clicks the checkout button
    Then the user should be directed to "Checkout: Your Information" page

    Examples:
      | product               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |


