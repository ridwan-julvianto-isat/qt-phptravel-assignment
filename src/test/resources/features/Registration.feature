Feature: New Customer Registration 
User should be able to traverse to registration page from home page

  Background: Initiate and Open PHP Travel webpage
    Given PHP Travel homepage is displayed
      And User navigated to "Registration" page
  
  @ready-to-test
  Scenario: Successfully register new user
     When User input correct Registration data with Last Name
      And User submit the Registration form
     Then System navigates to "My Accounts" page
      And My Account page displays welcome message
  
  @ready-to-test
  Scenario: Able to register new User without Last Name (Last Name is Optional)
     When User input correct Registration data without Last Name
      And User submit the Registration form
     Then System navigates to "My Accounts" page
      And My Account page displays welcome message without Last Name
  
  Scenario Outline: Verify validations rule in Registration page
     When User input value in violation of <validation rule> in <field name> in Registration form
      And User submit the Registration form
     Then System displays <error message> on top of Registration form
      And System stays in "Registration" page
    Examples: 
      | field name       | validation rule                                      | error message                                                 | 
      | First Name       | Cannot be blank                                      | The First Name field is required                              | 
      | First Name       | Minimum 2 characters                                 | The First Name field is incorrect                             | 
      | First Name       | Maximum 15 characters                                | The First Name field is incorrect                             | 
      | First Name       | No numerical values allowed                          | The First Name field is incorrect                             | 
      | Mobile Number    | Cannot be blank                                      | The Mobile Number field is required                           | 
      | Mobile Number    | Cannot be less than 10 digit number                  | Mobile Number must be 10-Digit                                | 
      | Mobile Number    | Cannot be more than 10 digit number                  | Mobile Number must be 10-Digit                                | 
      | Mobile Number    | Only contain numerical values                        | Mobile Number is incorrect                                    | 
      | Mobile Number    | Unique for Every User                                | Mobile Number already exist in the system                     | 
      | Email            | Cannot be blank                                      | The Email field is required                                   | 
      | Email            | Must be a valid Email ID                             | Email is incorrect                                            | 
      | Email            | Unique for Every User                                | Email already exist in the system                             | 
      | Password         | Cannot be blank                                      | The Password field is required                                | 
      | Password         | Cannot be less than 6 characters                     | Password must have 6 characters or more                       | 
      | Password         | Must be a a combination of alfa-numeric characters   | Password must contain alfa-numeric combination                | 
      | Password         | Must contain one special symbol from (@, #, $, &, *) | Password must contain one special symbol from (@, #, $, &, *) | 
      | Password Confirm | Cannot be blank                                      | The Confirm Password field is required                        | 
      | Password Confirm | Must match with Password                             | Incorrect Confirm Password input                              | 