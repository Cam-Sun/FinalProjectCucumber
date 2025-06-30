Feature: Navigate to shopping cart page

  Background:
    Given the user is on the Swag Labs login page
    When the user enters valid username and password
    And the user clicks the login button

  Scenario: User navigates to shopping cart page with 0 item added to cart
    Given the user adds no product to the shopping cart
    When the user clicks the Shopping cart icon
    Then the user is redirected to the "Your Cart" page
    And no cart item is displayed


  Scenario Outline: User navigates to shopping cart page with 1 item added to cart
    Given has added "<product>" to the shopping cart
    When the user clicks the Shopping cart icon
    Then the user is redirected to the "Your Cart" page
    And "<product>" is displayed on the cart page

    Examples:
      | product             |
      | Sauce Labs Backpack |
      | Sauce Labs Backpack |


  Scenario Outline: User can check items added to shopping cart before checkout
    Given the user has added the products "<product_name1>" and "<product_name2>" to the shopping cart
    When the user clicks the Shopping cart icon
    Then the user is redirected to the "Your Cart" page
    And the shopping cart should display the products "<product_name1>" and "<product_name2>"

    Examples:
      | product_name1         | product_name2            |
      | Sauce Labs Backpack   | Sauce Labs Onesie        |
      | Sauce Labs Bike Light | Sauce Labs Fleece Jacket |


  Scenario Outline: User navigates to shopping cart page with 6 items added to cart
    Given the user has added "<product1>", "<product2>", "<product3>", "<product4>", "<product5>", "<product6>" to the shopping cart
    When the user clicks the Shopping cart icon
    Then the user is redirected to the "Your Cart" page
    And "<product1>", "<product2>", "<product3>", "<product4>", "<product5>", "<product6>" are displayed on the cart page

    Examples:
      | product1            | product2              | product3          | product4                | product5                          | product6                 |

      | Sauce Labs Backpack | Sauce Labs Bike Light | Sauce Labs Onesie | Sauce Labs Bolt T-Shirt | Test.allTheThings() T-Shirt (Red) | Sauce Labs Fleece Jacket |
