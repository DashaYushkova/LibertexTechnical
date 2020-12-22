package google;

import com.google.common.io.Files;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.GoogleHomePage;
import pages.SearchResultPage;
import ru.yandex.qatools.ashot.Screenshot;
import utils.EventReporter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private EventFiringWebDriver driver;
    protected GoogleHomePage googleHomePage;
    protected SearchResultPage searchResultPage;
    protected SoftAssertions softly;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.google.ru/");
        googleHomePage = new GoogleHomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        softly = new SoftAssertions();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("src/test/resources/screenshots-on-failure/" + result.getName() + ".png"));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected Screenshot takeScreenshot(String name) {
        TakesScreenshot camera = driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "src/test/resources/screenshots-to-compare/screen-" + name + ".png";
        Screenshot screenToCompare = null;
        try {
            Files.move(screenshot, new File(screenshotPath));
        } catch(IOException e) {
            e.printStackTrace();
        }
        try {
            screenToCompare = new Screenshot(ImageIO.read(new File(screenshotPath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenToCompare;
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(true);
        return options;
    }
}