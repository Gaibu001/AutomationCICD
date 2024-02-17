
@tag
Feature: Title of your feature
  I want to use this template for my feature file

 Background:
 Given I landed on Ecommerce page
 

  @tag2
  Scenario Outline: Positve test of submitting the Order
    Given Login with user name <name> and password <password>
    When I add product <productname> to the cart
    And Checkout <productname> and submit the cart
    Then "THANKYOU FOR THE ORDER." is displayed in the configuration page
    Examples: 
      | name                  | password       | productname  |
      | anshika@gmail.com | Iamking@000    | ZARA COAT 3  |
     