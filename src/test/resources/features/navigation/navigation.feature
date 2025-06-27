Feature: Add to Cart Page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario Outline: The user is redirected to the product detail page
    Given the user is logged in successfully and is in the product listings page
    When the user clicks on the product "<product>" photo or name
    Then the user is redirected to the selected product detail page

    Examples:
      | product               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |



