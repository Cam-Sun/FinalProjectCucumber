Feature: Sort listing page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario Outline: : User can sort products by name or price
    Given the user is logged in successfully and is in the product listings page
    When the user clicks the dropdown menu
    And the user selects sorting option "<sortingOption>"
    Then the products are sorted by the sorting option"<sortingOption>"

    Examples:
      | sortingOption       |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |








