Feature: New Customer Registration 
	User should be able to traverse to registration page from home page
	

  Background: Initiate and Open PHP Travel webpage
  	Given Chrome web browser started
  	And PHP Travel homepage is displayed 
    
  Scenario: Verify user able to Register New Customer
     When User click signup menu to open Registration page
      And User input correct data
      And User click "Submit" button
     Then Verify my accounts page open
  
