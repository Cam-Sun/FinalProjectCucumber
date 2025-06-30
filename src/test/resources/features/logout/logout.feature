Feature: Logout

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario: User adds a product to the cart from the listings page
    Given the user is logged in successfully and is in the product listings page
    When the user opens the dropdown menu by clicking the three-line icon in the top left corner
    And the user clicks on the "Logout" option
    Then the user should be redirected back to the the Swag Labs login page




