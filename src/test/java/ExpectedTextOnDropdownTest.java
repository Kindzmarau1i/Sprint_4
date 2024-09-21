import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import samokatPageObject.MainPage;
import samokatPageObject.constants.QuestionsAndResponses;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class ExpectedTextOnDropdownTest extends BaseTest {

    private final String divQuestion;
    private final String expectedText;

    public ExpectedTextOnDropdownTest(String divQuestion, String expectedText) {
        this.divQuestion = divQuestion;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getExpectedText() {
        return new Object[][]{
                {QuestionsAndResponses.HOW_MUCH, QuestionsAndResponses.HOW_MUCH_RESPONSE},
                {QuestionsAndResponses.SEVERAL_SCOOTERS, QuestionsAndResponses.SEVERAL_SCOOTERS_RESPONSE},
                {QuestionsAndResponses.RENTAL_TIME, QuestionsAndResponses.RENTAL_TIME_RESPONSE},
                {QuestionsAndResponses.ORDER_FOR_TODAY, QuestionsAndResponses.ORDER_FOR_TODAY_RESPONSE},
                {QuestionsAndResponses.EXTEND_ORDER, QuestionsAndResponses.EXTEND_ORDER_RESPONSE},
                {QuestionsAndResponses.CHARGING, QuestionsAndResponses.CHARGING_RESPONSE},
                {QuestionsAndResponses.CANCEL_ORDER, QuestionsAndResponses.CANCEL_ORDER_RESPONSE},
                {QuestionsAndResponses.MKAD, QuestionsAndResponses.MKAD_RESPONSE}
        };
    }

    @Test
    public void checkForExpectedTextOnDropdown() {
        MainPage mainPage = new MainPage(driver);
        String factText = mainPage.checkTextOnDropdown(divQuestion);
        MatcherAssert.assertThat(factText, equalTo(expectedText));
    }
}
