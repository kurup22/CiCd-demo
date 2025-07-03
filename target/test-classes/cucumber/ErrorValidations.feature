@tag
Feature: Error Validations on wrong password
 
  
  
  Background:
  Given I landed on Ecommerce page
  
  @ErrorValidation
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> and password <password>
    Then Verify "Incorrect email or password." message is displayed
    
      Examples: 
      | name              |      password |  
      | vavetuts@tits.com |     tits@Tuts |   
      
