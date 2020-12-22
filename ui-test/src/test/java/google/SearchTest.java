package google;

import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
        softly.assertThat(googleHomePage.getPageTitle()).isEqualTo("Google");

        List<String> searchResults = googleHomePage.performSearch("libertex group").getResults();
        softly.assertThat(searchResultPage.getPageTitle()).isEqualTo("libertex group - Поиск в Google");
        softly.assertThat(searchResults).allMatch(result -> result.contains("libertex"));

        softly.assertThat(searchResultPage.getSearchTooltipText()).isEqualTo("Поиск");

        List<String> noResults = searchResultPage.clickOnTopLeftLogo().getResults();
        softly.assertThat(noResults).isEmpty();
        softly.assertThat(googleHomePage.getPageTitle()).isEqualTo("Google");

        softly.assertAll();
    }
}