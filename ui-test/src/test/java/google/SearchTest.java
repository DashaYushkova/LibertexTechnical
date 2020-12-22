package google;

import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
        softly.assertThat(googleHomePage.getPageTitle()).isEqualTo("Google");

        List<String> searchResults = googleHomePage.performSearch("libertex group").getResults();
        softly.assertThat(searchResultPage.getPageTitle()).isEqualTo("libertex group - Поиск в Google");
        softly.assertThat(searchResults).allMatch(result -> result.contains("libertex"));

        Screenshot inputNotHoveredOver = takeScreenshot("first");
        searchResultPage.moveToInputAndTriggerTooltip();
        Screenshot inputHoveredOver = takeScreenshot("second");
        ImageDiff diff = new ImageDiffer().makeDiff(inputNotHoveredOver, inputHoveredOver);
        softly.assertThat(diff.getDiffSize()).isNotEqualTo(0);

        softly.assertThat(searchResultPage.getInputTooltipText()).isEqualTo("Поиск");

        List<String> noResults = searchResultPage.clickOnTopLeftLogo().getResults();
        softly.assertThat(noResults).isEmpty();
        softly.assertThat(googleHomePage.getPageTitle()).isEqualTo("Google");

        softly.assertAll();
    }
}