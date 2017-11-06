package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP402HelpDeskTest extends BaseTest {
    private static RulesPage rulesPage;


    @BeforeMethod
    public void openPage() {

        rulesPage = open(RulesPage.URL, RulesPage.class);
        rulesPage.getHelpDeskItem().click();
    }


    @Test()
    public void verifyAnnouncementHelpDesk() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Служба поддержки", "Header text of HelpDesk is wrong");
        softAssert.assertTrue(rulesPage.getRuleHeaderDescription().contains("Нужно решить какую-либо проблему, которая касается работы"), " HelpDesk header description is wrong");
        softAssert.assertTrue(rulesPage.isActiveRuleHeaderDescriptionLink("https://helpdesk.issoft.by"), "HelpDesk header description link is wrong");
        softAssert.assertEquals(rulesPage.getCountRulesStep(), ("4"), "Count of rule description command item is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock1HelpDeskRule() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getRuleStep1().isDisplayed(), "HelpDesk rule of block 01 isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep1().$(".rule-number").getText(), "01", "Number of helpDesk rule block is wrong");
        softAssert.assertEquals(rulesPage.getRuleStep1().$(".rule-header").getText(), "Для входа на портал используйте, пожалуйста, доменные Login и Password",
                "Description of block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$("img").isDisplayed(), "Image of block 01 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock2HelpDeskRule() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getRuleStep2().isDisplayed(), "HelpDesk rule of block 02 isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep2().$(".rule-number").getText(), "02", "Number of helpDesk rule block is wrong");
        softAssert.assertEquals(rulesPage.getRuleStep2().$(".rule-header").getText(), "Заполните следующие формы", "Description of block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$(".commands").isDisplayed(), "iInstructions of block 02 isn't displayed");
        softAssert.assertEquals(rulesPage.getCountInstruction(), "6", "Count instructions is wrong number");
        softAssert.assertTrue(rulesPage.isVisibleCorrectInstruction(), "iInstructions of block 02 isn't displayed");
        softAssert.assertTrue(rulesPage.getRuleStep2().$("img").isDisplayed(), "Image of block 02 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock3HelpDeskRule() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getRuleStep3().isDisplayed(), "HelpDesk rule of block 03 isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep3().$(".rule-number").getText(), "03", "Number of helpDesk rule block is wrong");
        softAssert.assertEquals(rulesPage.getRuleStep3().$(".rule-header").getText(), "Свои запросы вы можете отслеживать в разделе My Issues",
                "Description of block 03 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$("img").isDisplayed(), "Image of block 01 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock4HelpDeskRule() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getRuleStep4().isDisplayed(), "HelpDesk rule of block 04 isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep4().$(".rule-number").getText(), "04", "Number of helpDesk rule block is wrong");
        softAssert.assertEquals(rulesPage.getRuleStep4().$(".rule-header").getText(), "Также, все действия по вашему запросу дублируются письмами в Outlook",
                "Description of block 04 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$("img").isDisplayed(), "Image of block 04 isn't displayed");
        softAssert.assertAll();
    }
}
