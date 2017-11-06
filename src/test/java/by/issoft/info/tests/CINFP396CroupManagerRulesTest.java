package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP396CroupManagerRulesTest extends BaseTest{
    private static RulesPage rulesPage;

    @BeforeMethod
    public void openPage() {
        rulesPage = open(RulesPage.URL, RulesPage.class);
    }

    @Test()
    public void verifyInformationBlock01() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getGroupManager().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Group Manager", "Group Manager header text is wrong");
        softAssert.assertTrue(rulesPage.getRuleHeaderDescription().contains("Групп-менеджер ведет зарплату сотрудника"), "Group Manager description is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().isDisplayed(), "Information Block 01 of Group Manager Rules isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep1().$(".rule-number").getText(), "01","Number of information block  is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$(".rule-header").getText().contains("зайдите под своим логином и паролем"), "Rule header of information 01 is wrong");
        softAssert.assertEquals(rulesPage.getRuleStep1().$(".link-description").getAttribute("href"),"https://rmsys.issoft.by/", "Link of information block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$(".rule-step-image").isDisplayed(), "Image of information block 01 isn't displayed");
        softAssert.assertAll();
    }

    @Test()
    public void verifyInformationBlock02() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getGroupManager().click();
        softAssert.assertTrue(rulesPage.getRuleStep2().isDisplayed(), "Information Block 02 of Group Manager Rules isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep2().$(".rule-number").getText(), "02","Number of information block  is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$(".rule-header").getText().contains("указан ваш Group Management"), "Rule header of information 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$(".rule-step-image").isDisplayed(), "Image of information 02 isn't displayed");
        softAssert.assertAll();
    }

    @Test()
    public void verifyWarningWrapperBlock() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getGroupManager().click();
        softAssert.assertTrue(rulesPage.getWarningWrapper().isDisplayed(), "Warning wrapper block of Group Manager Rules isn't displayed");
        softAssert.assertEquals(rulesPage.getWarningWrapper().$(".title-header-text").getText(), "Остались вопросы?","Title of warning wrapper block is wrong");
        softAssert.assertTrue(rulesPage.getWarningWrapper().$("p").getText().contains("Более подробная информация в документе"), "Description of warning wrapper block is wrong");
        String link = rulesPage.getWarningWrapper().$("p a").getAttribute("href");
        softAssert.assertTrue(link.contains("https://rmsys.issoft.by/Company/GetCompanyDocumentFile"), "Link of warning wrapper block 01 is wrong");
        softAssert.assertAll();
    }
}
