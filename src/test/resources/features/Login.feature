Feature: Existing User Login

  Background: Initiate and Open PHP Travel webpage
    Given PHP Travel homepage is displayed
      And User navigated to "Login" page
  
  @end-to-end
  Scenario: Successfully login as existing user
     When User input correct login information
     And User click the login button
     Then System navigates to "My Accounts" page
      And My Account page displays welcome message with "Hi First Name" greeting
      
      @negative
  Scenario Outline: Verify validations rule in Login form
     When User input value in violation of <validation rule> in <field name> in login form
      And User click the login button
     Then System displays <error message> on top of Login form
      And System stays in "Login" page
    Examples: 
      | Email            | Cannot be blank                                      | The Email field is required                                   | 
      | Email            | Must be a valid Email ID                             | Email is incorrect                                            | 
      | Password         | Cannot be blank                                      | The Password field is required                                | 
      
