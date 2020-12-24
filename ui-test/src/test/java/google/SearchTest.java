package google;

import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.Screenshot;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
        // check the main search page is opened
        softly.assertThat(googleHomePage.getPageTitle()).isEqualTo("Google");

        // perform search, check the results page is opened, the results are displayed correctly
        List<String> searchResults = googleHomePage.performSearch("libertex group").getResults();
        softly.assertThat(searchResultPage.getPageTitle()).isEqualTo("libertex group - Поиск в Google");
        softly.assertThat(searchResults).allMatch(result -> result.contains("libertex"));

        // compare two screenshots to check the tooltip appeared when the input field is hovered over
        Screenshot inputNotHoveredOver = takeScreenshot("first");
        searchResultPage.moveToInputAndTriggerTooltip();
        Screenshot inputHoveredOver = takeScreenshot("second");
        softly.assertThat(areImagesEqual(inputNotHoveredOver, inputHoveredOver)).isFalse();

        // check the tooltip text
        softly.assertThat(searchResultPage.getInputTooltipText()).isEqualTo("Поиск");

        // click on the top left logo, check the blank start page is opened, and no search results are displayed
        List<String> noResults = searchResultPage.clickOnTopLeftLogo().getResults();
        softly.assertThat(noResults).isEmpty();
        softly.assertThat(googleHomePage.getPageTitle()).isEqualTo("Google");

        softly.assertAll();
    }
}