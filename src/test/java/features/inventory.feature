Feature: Swag Labs Inventory Page

  Background: User added a "Sauce Labs Backpack" to the cart and was on the Inventory Page
    Given I have navigated to the "Home Page" URL
    And I have set the "Username Field" to "standard_user"
    And I have set the "Password Field" to "secret_sauce"
    And I have clicked the "Login Button"
    And I have clicked the "Sauce Labs Backpack Add to Cart Button"
    And the "Shopping Cart Badge" had the text "1"

  Scenario: User adds a "Sauce Labs Bike Light" to the cart and Shopping Cart Badge shows the item
    When I click the "Sauce Labs Bike Light Add to Cart Button"
    Then the "Shopping Cart Badge" had the text "2"