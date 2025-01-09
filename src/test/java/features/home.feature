Feature: Swag Labs Home Page Login

  Background: User was on the "Home Page"
    Given I have navigated to the "Home Page" URL

  Scenario: Users log into the website
    When I set the "Username Field" to "standard_user"
    And I set the "Password Field" to "secret_sauce"
    And I click the "Login Button"
    Then the "Products Header" should be "Displayed"


  Scenario Outline: Users do NOT log into the website and see the error message <Error Message Text>
    When I set the "Username Field" to <Username>
    And I set the "Password Field" to <Password>
    And I click the "Login Button"
    Then the "Error Message" is "Displayed" where the "Error Message" is <Error Message Text>

    Examples:
      | Username          | Password         | Error Message Text                                                          |
      | "locked_out_user" | ""               | "Epic sadface: Password is required"                                        |
      | ""                | "secret_sauce"   | "Epic sadface: Username is required"                                        |
      | "wrong username"  | "wrong password" | "Epic sadface: Username and password do not match any user in this service" |




