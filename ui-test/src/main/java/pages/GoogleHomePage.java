package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchInputField;

    public GoogleHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public SearchResultPage performSearch(String searchRequest) {
        wait.until(ExpectedConditions.visibilityOf(searchInputField));
        searchInputField.click();
        searchInputField.clear();
        searchInputField.sendKeys(searchRequest);
        searchInputField.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}