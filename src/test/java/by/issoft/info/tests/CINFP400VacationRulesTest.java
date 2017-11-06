package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP400VacationRulesTest extends BaseTest {
    private static RulesPage rulesPage;


    @BeforeMethod
    public void openPage() {

        rulesPage = open(RulesPage.URL, RulesPage.class);
        rulesPage.getVacationItem().click();
    }


    @Test()
    public void verifyVacationDescriptionRule() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Как оформить свой отпуск?", "Vacation header text is wrong");
        softAssert.assertTrue(rulesPage.getRuleHeaderDescription().contains("Все отпуска оформляются через систему Vacation Manager в RMSys"), "Vacation header description is wrong");
        softAssert.assertTrue(rulesPage.isActiveRuleHeaderDescriptionLink("https://rmsys.issoft.by/VacationRequest"), "Vacation header description link is wrong");
        softAssert.assertEquals(rulesPage.getRuleSectionHeader(), "ЧТО НУЖНО ЗНАТЬ ДЛЯ ОФОРМЛЕНИЯ ОТПУСКА?", "Vacation section header is wrong");
        softAssert.assertEquals(rulesPage.getCountRuleDescriptionCommandItem(), ("7"), "Count of rule description command item is wrong");
        softAssert.assertTrue(rulesPage.isVisibleDescriptionCommandItems(), "Rule of description command items are wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock1VacationRule() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getRuleStep1().isDisplayed(), "Vacation rule of block 01 isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep1().$(".rule-number").getText(), "01", "Number of vacation rule block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$(".rule-header").getText().contains("Откройте вкладку"), "Description of vacation rule block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$(".rule-header a").getAttribute("href").contains("https://rmsys.issoft.by"), "Link of vacation rule block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$("img").isDisplayed(), "Image of vacation rule block 01 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock2VacationRule() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getRuleStep2().isDisplayed(), "Vacation rule of block 02 isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep2().$(".rule-number").getText(), "02", "Number of vacation rule block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$(".rule-header").getText().contains("Заполните соответствующие поля и нажмите и нажмите Submit"), "Description header of vacation rule block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$(".warning-description").getText().contains("Если вам не удаётся создать отпуск в системе"), "Description of vacation rule block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$("img").isDisplayed(), "Image of vacation rule block 02 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyUnpaidVacationRule() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getHeaderUnpaidVacation(), "ОФОРМЛЕНИЕ ОТПУСКА ЗА СВОЙ СЧЁТ", "Header of unpaid vacation is wrong");
        softAssert.assertTrue(rulesPage.getDescriptionUnpaidVacation().contains("При желании взять неоплачиваемый отпуск "), "Description of unpaid vacation rule block is wrong");
        softAssert.assertTrue(rulesPage.getContinueDescriptionUnpaidVacation().contains("Более подробная информация об отпусках"), "Continue description of unpaid vacation rule block is wrong");
        softAssert.assertEquals(rulesPage.getOffice(), "118 офис, кабинет \"Office Managers\"", "Office of unpaid vacation rule block is wrong");
        softAssert.assertTrue(rulesPage.isLinkHomeUnpaidVacation(), "Link of unpaid vacation rule block is wrong");

        softAssert.assertTrue(rulesPage.getPersonData().isDisplayed(), "Person data of unpaid vacation rule block isn't displayed");
        softAssert.assertTrue(rulesPage.getPersonData().$("img").isDisplayed(), "Person data picture of unpaid vacation rule block isn't displayed");
        softAssert.assertEquals(rulesPage.getPersonData().$("h3").getText(), "Кира Катонова", "Office manager's name of unpaid vacation is wrong");
        softAssert.assertEquals(rulesPage.getPersonData().$("div.rule-description").getText(), "Начальник отдела кадров", "Manager's positions is wrong");
        softAssert.assertEquals(rulesPage.getPersonData().$("a").getAttribute("href"), "skype:csi.kirakatonova?add", "Skype is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyAttentionSectionVacation() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getRuleQuestionsBlock().isDisplayed(), "Attention section of unpaid vacation rule block isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleQuestionsHeader(), "Просьба не забывать!", "Header of attention section of unpaid vacation block is wrong");
        softAssert.assertTrue(rulesPage.getRuleQuestionsBlock().$("p:nth-of-type(1)").getText().contains("Минимум за 3 дня"), "Description Attention section of unpaid vacation rule block is wrong");
        softAssert.assertTrue(rulesPage.getRuleQuestionsBlock().$("p:nth-of-type(2)").getText().contains("Если сотрудник не может заполнить Intacct"), "Description Attention section of unpaid vacation rule block is wrong");
        softAssert.assertEquals(rulesPage.getRuleQuestionsBlock().$("a").getAttribute("href"), "https://time.coherentsolutions.com/", "Skype of attention section of unpaid vacation rule block is wrong");
        softAssert.assertAll();
    }
}
