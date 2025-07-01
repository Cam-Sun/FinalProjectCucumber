Feature: Sort listing page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario: User navigates to "X" social media "saucelabs" page
    Given the user is logged in successfully and is in the product listings page
    When the user clicks the "X" icon on the footer
    Then the user is redirected to the the "X" Sauce Labs social media page

  Scenario: User navigates to "Facebook" social media "saucelabs" page
    Given the user is logged in successfully and is in the product listings page
    When the user clicks the "Facebook" icon on the footer
    Then the user is redirected to the the "Facebook" Sauce Labs social media page

  Scenario: User navigates to "LinkedIn" social media "saucelabs" page
    Given the user is logged in successfully and is in the product listings page
    When the user clicks the "LinkedIn" icon on the footer
    Then the user is redirected to the the "LinkedIn" Sauce Labs social media page
