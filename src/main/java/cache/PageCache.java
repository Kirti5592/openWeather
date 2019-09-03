package cache;

import org.openqa.selenium.WebDriver;
import pageObjects.openWeatherPage;

public class PageCache {

    private openWeatherPage open;
    private WebDriver dr;

    public openWeatherPage getOpenWeatherPage()
    {
        if(open == null)
        {

            open = new openWeatherPage(dr);
        }

        return open;
    }
}
