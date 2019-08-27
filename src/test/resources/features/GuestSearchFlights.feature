Feature: Search for Flight
	
  Background: Initiate and Open PHP Travel webpage
    Given PHP Travel homepage is displayed

  @ready-to-test @valid-scenario
  Scenario: Search for Flights
     When User select <flight> search tab
      And User input the following flights itinerary
      | Direction       | One Way                    | 
      | Embarkation     | SIN                        |
      | Destination     | CGK                        |
      | Departure Date  | 2019-08-29                 |
      | Arrival Date    | N/A                        |
      | No Of Adults    | 1                          |
      | No Of Childs    | 2                          |
      | No Of Infants   | 1                          |
      And User click Search button
     Then System navigates to "Search Result" page
      And List of Airlines shown
      And List of Flight schedules shown
      And Book Now button shown on every schedule
      And List Price shown on every schedule
