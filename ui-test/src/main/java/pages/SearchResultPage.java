package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchInputField;

    @FindBy(xpath = "//div[@class='logo']/a")
    private WebElement logo;

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<String> getResults() {
        return searchResults.stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public void moveToInputAndTriggerTooltip() {
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(logo)))
                .moveToElement(wait.until(ExpectedConditions.visibilityOf(searchInputField)))
                .perform();
        Waiter.pause(7);
    }

    public String getInputTooltipText() {
        wait.until(ExpectedConditions.visibilityOf(searchInputField));
        return searchInputField.getAttribute("title");
    }

    public SearchResultPage clickOnTopLeftLogo() {
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(logo))).click().perform();
        return this;
    }
}