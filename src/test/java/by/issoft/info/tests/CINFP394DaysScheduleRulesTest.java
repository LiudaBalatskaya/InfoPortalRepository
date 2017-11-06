package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP394DaysScheduleRulesTest extends BaseTest {
    private static RulesPage rulesPage;

    @BeforeClass
    public void openPage() {
        rulesPage = open(RulesPage.URL, RulesPage.class);
    }

    @Test()
    public void verifyActiveDayScheduleItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getMenubarHeaderText().getText(), "Как мы работаем?", "Menubar header text is wrong");
        softAssert.assertTrue(rulesPage.isVisibleDaysScheduledInformation(), "Day Schedule information isn't displayed");
        softAssert.assertEquals(rulesPage.getFeedback().getText(), "Feedback","Feedback button isn't displayed");
        softAssert.assertAll();
    }

}
