Feature: Your info page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

# Happy path for Checkout: Your Info
  Scenario Outline:User should enter all required fields including First Name, Last Name, and Postal code to continue checkout
    Given the user has added the "<product>" to the cart and has clicked the checkout button on the cart page
    When the user enters "<firstName>", "<lastName>", "<postalCode>"
    And the user clicks the "Continue" button
    Then the user should be directed to "Checkout: Overview" page
#
    Examples:
      | firstName | lastName | postalCode | product               |
      | standard  | swag     | EC2V7AB    | Sauce Labs Bike Light |
      | secret    | sauce    | ME139ng    | Sauce Labs Bike Light |
      | swag      | sauce    | WD174NH    | Sauce Labs Bike Light |


#  Unhappy path for Checkout: Your Info
 Scenario Outline:User should not be able to proceed with checkout when any required info is missing
    Given the user has added the "<product>" to the cart and has clicked the checkout button on the cart page
    When the user enters "<firstName>", "<lastName>", "<postalCode>"
    And the user clicks the "Continue" button
    Then error message is displayed


    Examples:
      | firstName | lastName | postalCode | product               |
      |           | swag     | EC2V7AB    | Sauce Labs Bike Light |
      | secret    |          | ME139ng    | Sauce Labs Bike Light |
      | swag      | sauce    |            | Sauce Labs Bike Light |
      |           |          |            | Sauce Labs Bike Light |