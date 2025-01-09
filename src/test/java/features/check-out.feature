Feature: Swag Labs Checkout Step Page

  Background: User added a "Sauce Labs Backpack" to the cart and was on the Cart Page
    Given I have navigated to the "Home Page" URL
    And I have set the "Username Field" to "standard_user"
    And I have set the "Password Field" to "secret_sauce"
    And I have clicked the "Login Button"
    And I have clicked the "Sauce Labs Backpack Add to Cart Button"
    And I have clicked the "Shopping Cart Button"
    And I have clicked the "Checkout Button"

  Scenario: User adds information to the checkout form and continues
    When I set the "First Name Field" to "Generate First Name"
    And I set the "Last Name Field" to "Generate Last Name"
    And I set the "Zip/Postal Code Field" to "Generate Zip Code"
    And I click the "Continue Button"
    And I click the "Finish Button"
    Then the "Order Completed Title" should be "Displayed"
