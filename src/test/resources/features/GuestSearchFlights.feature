Feature: Search for Flight
	
  Background: Initiate and Open PHP Travel webpage
    Given PHP Travel homepage is displayed

  Scenario: Search for Flights
     When User select <flight> search tab
      And User input the following flights itinerary
      | Direction       | One Way    | 
      | Embarkation     | London     |
      | Destination     | Singapore  |
      | Departure Date  | 19-08-2019 |
      | Arrival Date    | N/A        |
      | No Of Adults    | 1          |
      | No Of Childs    | 0          |
      | No Of Infants   | 0          |
      And User click Search button
     Then System navigates to "Search Result" page
      And List of Airlines shown
      And List of Flight schedules shown
      And Book Now button shown on every schedule
      And List Price shown on every schedule
