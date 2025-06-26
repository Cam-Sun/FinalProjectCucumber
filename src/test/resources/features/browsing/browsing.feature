Feature: Sort listing page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be logged in successfully
    And redirected to the product listing page

  Scenario: User can browser product listing
#    When the user is on the inventory page
    Then the user can view all products with images, names, and prices
