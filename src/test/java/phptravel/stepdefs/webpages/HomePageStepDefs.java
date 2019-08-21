package phptravel.stepdefs.webpages;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import phptravel.stepdefs.APageObjects;

public class HomePageStepDefs extends APageObjects {
	
	@When("^User select (.+) search tab$")
	public void user_select_search_tab(String option) throws Throwable {
		homePage.openFlightSearchTab();
	}

	@And("^User input the following flights itinerary$")
	public void user_input_the_following_flights_itinerary(DataTable dt) throws Throwable {
		List<Map<String, String>> flightList = dt.asMaps(String.class, String.class);

		for (int i = 0; i < flightList.size(); i++) {
			String direction = flightList.get(i).get("Direction");
			String embark = flightList.get(i).get("Embarkation");
			String dest = flightList.get(i).get("Destination");
			String depDate = flightList.get(i).get("Departure Date");
			String arriveDate = flightList.get(i).get("Arrival Date");
			String adults = flightList.get(i).get("No Of Adults");
			String childs = flightList.get(i).get("No Of Childs");
			String infants = flightList.get(i).get("No Of Infants");
			
			homePage.selectFlight(direction, embark, dest, depDate, arriveDate, adults, childs, infants);
		}
	}

    @And("^User click Search button$")
    public void user_click_search_button() throws Throwable {
       homePage.initSearch();
    }
}
