Feature: checkout complete

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario Outline: User can click Finish button to complete purchase on Checkout: Overview
    Given the user has added the "<product1>", "<product2>", "<product3>" to the cart, entered "<firstName>", "<lastName>", "<postalCode>" and is on the Checkout: Overview page
    When the user clicks the "Finish" button
    Then the user is redirected to the "Checkout: Complete!" page

    Examples:
      | firstName | lastName | postalCode | product1              | product2          | product3                 |
      | standard  | swag     | EC2V7AB    | Sauce Labs Bike Light |                   |                          |
      | secret    | sauce    | ME139ng    | Sauce Labs Bike Light | Sauce Labs Onesie |                          |
      | swag      | sauce    | WD174NH    | Sauce Labs Bike Light | Sauce Labs Onesie | Sauce Labs Fleece Jacket |


