package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventReporter implements WebDriverEventListener {
    private static Logger log = LogManager.getRootLogger();

    public void beforeAlertAccept(WebDriver driver) {

    }

    public void afterAlertAccept(WebDriver driver) {

    }

    public void afterAlertDismiss(WebDriver driver) {

    }

    public void beforeAlertDismiss(WebDriver driver) {

    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        log.info("Navigating to " + url);
    }

    public void afterNavigateTo(String url, WebDriver driver) {

    }

    public void beforeNavigateBack(WebDriver driver) {

    }

    public void afterNavigateBack(WebDriver driver) {

    }

    public void beforeNavigateForward(WebDriver driver) {

    }

    public void afterNavigateForward(WebDriver driver) {

    }

    public void beforeNavigateRefresh(WebDriver driver) {

    }

    public void afterNavigateRefresh(WebDriver driver) {

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info("Clicking on " + element.getText());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    public void beforeScript(String script, WebDriver driver) {

    }

    public void afterScript(String script, WebDriver driver) {

    }

    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    public void onException(Throwable throwable, WebDriver driver) {

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    public void beforeGetText(WebElement element, WebDriver driver) {
        log.info("Getting text of " + element.getText());
    }

    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}

