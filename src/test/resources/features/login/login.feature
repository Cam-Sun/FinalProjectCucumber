Feature: Swag Labs Login Page

  Background:
    Given the user is on the Swag Labs login page

  Scenario: Successful login with valid credentials
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be logged in successfully
    And redirected to the product listing page