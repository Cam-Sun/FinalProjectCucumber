@link
Feature: Accessibility Hover links

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario Outline: User navigates to product detail page by clicking on the product name
    Given the user is logged in successfully and is in the product listings page
    When the user hovers over the product "<product_name>" name
    Then the product "<product_name>" name should visibly indicate it is clickable with a colour change

    When the user clicks the product "<product_name>" name
    Then the user is redirected to the selected product detail page

    Examples:
      | product_name               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |


  Scenario Outline: User navigates back to "Product Listings" page from "Product Detail" page
    Given the the user is on the selected product "<product>" detail page
    When the user hovers over the "Back to products" link
    Then the link should visibly indicate it is clickable with colour change

    When the user clicks the "Back to products" link
    Then the user should be redirected to the product listings page

    Examples:
      | product                |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |


  Scenario: User navigates to "About" page
    Given the user is logged in successfully and is in the product listings page
    When the user opens the dropdown menu by clicking the three-line icon in the top left corner
    And the user clicks on the "About" option
    Then the user should be redirected to the the "About" page


  Scenario: User navigates back to "Product listings" page using menu
    Given the user is in a different page from "Product listings"
    When the user opens the dropdown menu by clicking the three-line icon in the top left corner
    And the user clicks on the "All items" option
    Then the user should be redirected to the product listings page



