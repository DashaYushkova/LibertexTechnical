package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage {

    private WebDriver driver;
    private Actions actions;

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    private WebElement searchInputField;

    @FindBy(xpath = "//*[@id='logo']")
    private WebElement logo;

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> searchResults;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
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

    public String getSearchTooltipText() {
        actions = new Actions(driver);
        actions.moveToElement(logo).moveToElement(searchInputField).build().perform();
        return searchInputField.getAttribute("title");
    }

    public SearchResultPage clickOnTopLeftLogo() {
        actions = new Actions(driver);
        actions.moveToElement(logo).click().build().perform();
        return this;
    }
}