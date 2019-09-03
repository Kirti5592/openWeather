package pageObjects;

import org.apache.logging.log4j.core.util.Assert;
import org.omg.CORBA.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openWeatherPage{

    private WebDriver dr ;
    //WebElements
    By inputCityName = By.xpath(".//input[@placeholder ='Your city name']");
    By btnSearch = By.xpath(".//button[text()=' Search']");
    By linkCurrentLocation = By.xpath(".//button[text()='  Current location']");
    By listForecast = By.id("forecast-list");
    By listOfForecast = By.xpath(".//*[@id='forecast-list']//td/b/a");
    By navLink = By.xpath(".//a[text()='API']");
    By tabWeatherAPI = By.xpath(".//h1[text()='Weather API']");
    By txtMsg = By.className("lead");
    By linkWeatherInYourCity = By.xpath(".//*[text()=' Weather in your city']");
    By linkSignIn = By.xpath(".//*[text()=' Sign In']");
    By linkSignUp = By.xpath(".//*[text()=' Sign Up']");
    By imgOpenWeather = By.xpath(".//*[@alt='openweather']");

    public openWeatherPage(WebDriver dr)
    {

        this.dr = dr;

    }

    public void hitLink()
    {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\IdeaProjects\\openWeather\\drivers\\chromedriver.exe");
        dr = new ChromeDriver();
        dr.get("https://openweathermap.org");

    }
    public void homePage()
    {

        String title = dr.getTitle();
        if(title.contains(null))
        {
            System.out.println("application is down");
        }
        else
        {
            System.out.println("On homepage");
        }

    }
    public String enterCityName(String cityName)
    {

        dr.findElement(inputCityName).sendKeys(cityName);
        dr.findElement(btnSearch).click();
        return cityName;
        
    }
    public void checkEnteredCityIsValid(String cityName)
    {

        if(dr.findElement(listOfForecast).isDisplayed())
        {

            String city = dr.findElement(listOfForecast).getAttribute("text");
            if(cityName.contains(city))
            {

                System.out.println("weather details are displayed for the respective city");
            }
            else
            {
                System.out.println(cityName +" is "+city);
            }
        }
    }
    public void clickAPILink()
    {

        dr.findElement(navLink).click();

    }
    public void weatherApI(String weatherAPIText)
    {

        String weather = dr.findElement(tabWeatherAPI).getText();
        if(weather.equalsIgnoreCase(weatherAPIText))
        {
            System.out.println("API page is loaded");
        }
        else
        {
            System.out.println("Page not found");
        }
    }

    public void validateMsg()
    {

        String message = dr.findElement(txtMsg).getText();
        if(message.contains("sign up") || message.contains("monthly subscriptions"))
        {

            System.out.println("message validated on API page");
        }
        else
        {
            System.out.println("not on API page");
        }
    }

    public void validateLabels(String labels)
    {

        if(labels.equalsIgnoreCase("openWeather"))
        {
            if(dr.findElement(imgOpenWeather).isDisplayed())
            {
                System.out.println("image found on home page");
            }
            else
            {
                System.out.println("image not found on home page");
            }
        }
        else if(labels.equalsIgnoreCase("Weather in your city"))
        {
            if(dr.findElement(linkWeatherInYourCity).isDisplayed())
            {
                System.out.println("link found on home page");
            }
            else
            {
                System.out.println("link not found on home page");
            }
        }
        else if(labels.equalsIgnoreCase("Sign In"))
        {
            if(dr.findElement(linkSignIn).isDisplayed())
            {
                System.out.println("link found on home page");
            }
            else
            {
                System.out.println("link not found on home page");
            }
        }
        else if(labels.equalsIgnoreCase("Sign Up"))
        {
            if(dr.findElement(linkSignUp).isDisplayed())
            {
                System.out.println("link found on home page");
            }
            else
            {
                System.out.println("link not found on home page");
            }
        }
    }
}
