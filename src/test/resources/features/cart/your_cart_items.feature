Feature: Your Cart Page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario Outline: User can check items added to shopping cart before checkout
    Given the user has added the products "<product_name1>" and "<product_name2>" to the shopping cart
    When the user clicks the Shopping cart icon
    Then the user is redirected to the "Your Cart" page
    And the shopping cart should display the products "<product_name1>" and "<product_name2>"

    Examples:
      | product_name1         | product_name2            |
      | Sauce Labs Backpack   | Sauce Labs Onesie        |
      | Sauce Labs Bike Light | Sauce Labs Fleece Jacket |
