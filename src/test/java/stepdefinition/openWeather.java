package stepdefinition;

import cache.PageCache;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openWeather {

    private PageCache page;
    private static String city;
    private static String invalidCity;

    public openWeather(PageCache page)
    {

        this.page = page;

    }

    @Given("^user clicks on the openWeather link$")
    public void user_clicks_on_the_openWeather_link() throws Throwable {

        page.getOpenWeatherPage().hitLink();

    }

    @Given("^user is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {

        page.getOpenWeatherPage().homePage();
        
    }

    @Given("^user clicks on API link$")
    public void user_clicks_on_API_link() throws Throwable {

        page.getOpenWeatherPage().clickAPILink();

    }

    @Given("^user is able to see the home page$")
    public void userIsAbleToSeeTheHomePage() {

        page.getOpenWeatherPage().homePage();

    }

    @When("^user enters the name of an invalid city$")
    public void user_enters_the_name_of_an_invalid_city() throws Throwable {

        String cityName = "Invalid";
        invalidCity = page.getOpenWeatherPage().enterCityName(cityName);
    }

    @When("^user enters the name of a city$")
    public void user_enters_the_name_of_a_city() throws Throwable {

        String cityName = "Pune";
        city = page.getOpenWeatherPage().enterCityName(cityName);

    }

    @When("^the user navigates to the API weather page$")
    public void the_user_navigates_to_the_API_weather_page(String weather) throws Throwable {

        page.getOpenWeatherPage().weatherApI(weather);

    }

    @When("^user is on Home page$")
    public void userIsOnHomePage() {

        System.out.println("user is on homePage");
    }

    @Then("^message is displayed \"([^\"]*)\"$")
    public void message_is_displayed(String str1) throws Throwable {

        page.getOpenWeatherPage().checkEnteredCityIsValid(invalidCity);

    }

    @Then("^the weather details of the city is displayed$")
    public void the_weather_details_of_the_city_is_displayed() throws Throwable {

        page.getOpenWeatherPage().checkEnteredCityIsValid(city);

    }

    @Then("^the user should get a message for sign up or monthly subscription$")
    public void the_user_should_get_a_message_for_sign_up_or_monthly_subscription() throws Throwable {

        page.getOpenWeatherPage().validateMsg();

    }

    @Then("^the page should contain \"([^\"]*)\"$")
    public void thePageShouldContain(String labels) throws Throwable {

        page.getOpenWeatherPage().validateLabels(labels);

    }
}
