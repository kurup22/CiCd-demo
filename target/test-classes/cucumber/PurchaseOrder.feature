
@tag
Feature: Purchase the order from Ecommerce website
  
  
  
  Background:
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> and password <password>
    When I add product <productname> to cart
    And  checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displyaed on ConfirmationPage

    Examples: 
      | name              |      password |  productname |
      | vavetuts@tits.com |     tits@Tuts22 |  ZARA COAT 3 | 
      
     