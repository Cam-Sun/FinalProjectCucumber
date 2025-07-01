Feature: Sort listing page

  Scenario: User can browser product listing
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button
    Then the user can view all products with images, names, and prices
