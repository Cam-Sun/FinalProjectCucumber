Feature: Swag Labs Login Page

  Background:
    Given the user is on the Swag Labs login page

  Scenario: Successful login with valid credentials
    When the user enters valid username and password
    And the user clicks the login button
    Then the user should be logged in successfully
    And redirected to the product listing page

  Scenario Outline: Unsuccessful login with invalid credentials
    When user enters invalid username: "<username>" and, or password: "<password>"
    And the user clicks the login button
    Then the login should fail and an error message should be displayed

    Examples:
      | username      | password      |
      | invalid1      | secret_sauce1 |
      | invalid1      | secret_sauce  |
      | standard_user | secret_sauce2 |
      |               | secret_sauce  |
      | standard_user |               |
      |               |               |

