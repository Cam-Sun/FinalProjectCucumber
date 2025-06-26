Feature: Sort listing page

  Background:
    Given the user is on the inventory page after successful login

  Scenario Outline: : User can sort products by name or price
    When the user clicks the dropdown menu
    And the user selects sorting option "<sortingOption>"
    Then the products are sorted by the sorting option

    Examples:
      | sortingOption       |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |








