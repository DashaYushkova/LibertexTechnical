package driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.EventReporter;

public class InitDriver {

    private static EventFiringWebDriver eventDriver;
    private static Logger log = LogManager.getRootLogger();

    private InitDriver() {}

    public static WebDriver initDriver() {
        if (eventDriver == null) {
            createDriver();
            return eventDriver;
        }
        return eventDriver;
    }

    private static void createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        eventDriver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        eventDriver.register(new EventReporter());
        eventDriver.manage().window().maximize();
        log.info("Chrome browser instantiated");
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setHeadless(true);
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        options.addArguments("--lang=ru");
        return options;
    }
}
