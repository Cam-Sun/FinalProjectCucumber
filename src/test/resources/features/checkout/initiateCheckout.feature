Feature: User initiates checkout

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

#    this scenario can not be automated as user can start checkout when the cart is empty
#  Scenario: User should not be able to checkout when no item is in the cart
#    Given the user has not added any products to the cart
#    And the user is on the cart page
#    When the user clicks the checkout button
#    Then the user should remain on the "Your Cart" page

  Scenario Outline: User can initiate checkout when one item is in the cart
    Given the user has added the product "<product>" to the shopping cart
    And the user is on the cart page
    When the user clicks the checkout button
    Then the user should be directed to "Checkout: Your Information" page

    Examples:
      | product               |
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |

  Scenario Outline: User can initiate checkout when six items are in the cart
    Given the user has added the products "<product1>", "<product2>", "<product3>", "<product4>", "<product5>", "<product6>" to the shopping cart
    And the user is on the cart page
    When the user clicks the checkout button
    Then the user should be directed to "Checkout: Your Information" page

    Examples:
      | product1            | product2              | product3          | product4                | product5                          | product6                 |
      | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Onesie | Sauce Labs Bolt T-Shirt | Test.allTheThings() T-Shirt (Red) | Sauce Labs Fleece Jacket |


