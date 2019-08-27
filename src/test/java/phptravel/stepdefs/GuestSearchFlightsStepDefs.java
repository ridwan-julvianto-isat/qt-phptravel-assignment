package phptravel.stepdefs;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobjects.commons.CommonObjects.FLIGHT_TRIP;
import phptravel.stepdefs.commons.APageObjects;

public class GuestSearchFlightsStepDefs extends APageObjects {
	
	@When("^User select (.+) search tab$")
	public void user_select_search_tab(String option) throws Throwable {
		homePage.openFlightSearchTab();
	}
	
	@And("^User input the following flights itinerary$")
	public void user_input_the_following_flights_itinerary(DataTable dt) throws Throwable {
		Map<String, String> flightList = dt.asMap(String.class, String.class);

			FLIGHT_TRIP direction = flightList.get("Direction") == "Round Trip"? FLIGHT_TRIP.ROUND_TRIP : FLIGHT_TRIP.ONE_WAY;
			String embark = flightList.get("Embarkation");
			String dest = flightList.get("Destination");
			String depDate = flightList.get("Departure Date");
			String arriveDate = flightList.get("Arrival Date");
			String adults = flightList.get("No Of Adults");
			String childs = flightList.get("No Of Childs");
			String infants = flightList.get("No Of Infants");
			
			homePage.selectFlight(direction, embark, dest, depDate, arriveDate, adults, childs, infants);
	}
	
    @And("^User click Search button$")
    public void user_click_search_button() throws Throwable {
       homePage.initSearch();       
    }
        
    @And("^List of Airlines shown$")
    public void list_of_airlines_shown() throws Throwable {
        searchPage.verifyListOfAirlines();
    }

    @And("^List of Flight schedules shown$")
    public void list_of_flight_schedules_shown() throws Throwable {
        searchPage.verifyListOfFlightSchedule();
    }

    @And("^Book Now button shown on every schedule$")
    public void book_now_button_shown_on_every_schedule() throws Throwable {
        searchPage.verifyBookNowButtons();
    }

    @And("^List Price shown on every schedule$")
    public void list_price_shown_on_every_schedule() throws Throwable {
        searchPage.verifyListPrices();
    }
}
