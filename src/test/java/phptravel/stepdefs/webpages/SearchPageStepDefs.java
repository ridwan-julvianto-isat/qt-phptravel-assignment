package phptravel.stepdefs.webpages;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import phptravel.stepdefs.APageObjects;

public class SearchPageStepDefs extends APageObjects {

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
