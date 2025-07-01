@cart
Feature: Your Cart Page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario Outline: User can check items added to shopping cart before checkout
    Given the user has added the products "<product_name1>" and "<product_name2>" to the shopping cart
    When the user clicks on the shopping cart icon
    Then the user should be redirected to the "Your Cart" page
    And the shopping cart should display the products "<product_name1>" and "<product_name2>"

    Examples:
      | product_name1         | product_name2            |
      | Sauce Labs Backpack   | Sauce Labs Onesie        |
      | Sauce Labs Bike Light | Sauce Labs Fleece Jacket |

  Scenario: Viewing the shopping cart with no items added
    Given the user has not added any products to the cart
    When the user clicks on the shopping cart icon
    Then the user should be redirected to the "Your Cart" page
    And the cart should be empty and not display any product


