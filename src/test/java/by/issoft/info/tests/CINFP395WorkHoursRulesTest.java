package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP395WorkHoursRulesTest extends BaseTest {
    private static RulesPage rulesPage;

    @BeforeMethod
    public void openPage() {
        rulesPage = open(RulesPage.URL, RulesPage.class);
    }

    @Test()
    public void verifyVisibleAccordingWorkHoursItem() {
        String description ="Два раза в месяц сотрудники компании вносят отработанные часы в систему Intacct";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getAccordingWorkHours().isDisplayed(), "According Work Hours item isn't displayed");
        softAssert.assertEquals(rulesPage.getAccordingWorkHours().getText(), "Учёт рабочего времени", "According Work Hours item is wrong");
        softAssert.assertTrue(rulesPage.getWorkHoursIcon().isDisplayed(), "According Work Hours icon isn't displayed");
        rulesPage.getAccordingWorkHours().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Как заполнить свои часы", "According Work Hours title is wrong");
        softAssert.assertTrue(rulesPage.getRuleHeaderDescription().contains(description), "Description of According Work Hours is wrong");
        softAssert.assertAll();
    }

    @Test()
    public void verifyVisibleInstructionSteps() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getAccordingWorkHours().click();
        softAssert.assertTrue(rulesPage.isEquelTo9InstructionSteps(), "9 steps of Instruction aren't displayed");
        softAssert.assertTrue(rulesPage.isVisibleInstructionSteps(), "Instruction's steps are wrong");
        softAssert.assertAll();
    }

    @Test()
    public void verifyVisibleQuestionSection() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getAccordingWorkHours().click();
        softAssert.assertTrue(rulesPage.getRuleQuestionsBlock().isDisplayed(), "Question block isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleQuestionsHeader(), "Возникли вопросы?", "Question block header is wrong");
        softAssert.assertTrue(rulesPage.getRuleQuestionsDescription().contains("Обращайтесь к следующим сотрудникам"),  "Question block description is wrong");
        softAssert.assertTrue(rulesPage.getRuleQuestionsColumns().isDisplayed(), "Columns of the question block aren't displayed");
        softAssert.assertAll();
    }

    @Test()
    public void verifyVisibleColumnsCollectionOfQuestionBlocks() {
        rulesPage.getAccordingWorkHours().click();
        Assert.assertTrue(rulesPage.isVisibleColumnsCollection(), "Information of 3 columns of question's block are wrong");

    }
}
