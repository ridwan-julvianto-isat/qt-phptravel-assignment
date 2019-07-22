Feature: Customer Registration 

  Scenario: Successfully register New Customer
    Given PHP Travel website homepage opens
     When User click signup menu to open Registration page
      And User input correct data
      And User submit data
     Then Verify my accounts page open
  
