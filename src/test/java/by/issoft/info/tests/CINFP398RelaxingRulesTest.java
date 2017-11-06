package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP398RelaxingRulesTest extends BaseTest {
    private static RulesPage rulesPage;


    @BeforeMethod
    public void openPage() {
        rulesPage = open(RulesPage.URL, RulesPage.class);
    }


    @Test()
    public void verifyRelaxingBlock1() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getRelaxItem().click();
        softAssert.assertEquals(rulesPage.getFirstItemTitle(), "Отдых", "Relaxing header text is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn1().isDisplayed(), "Block 01 of Relaxing isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleColumn1().$(".rule-number").getText(), "01", "Number of relaxing block is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn1().$(".rule-header").getText().contains("Зона отдыха"), "Header of relaxing block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn1().$(".rule-description").getText().contains("Отвлечься на минуту от трудовых будней"), "Description of relaxing block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn1().$("img").isDisplayed(), "Image of relaxing block 01 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyRelaxingBlock2() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getRelaxItem().click();
        softAssert.assertTrue(rulesPage.getRuleColumn2().isDisplayed(), "Block 02 of Relaxing isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleColumn2().$(".rule-number").getText(), "02", "Number of relaxing block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn2().$(".rule-header").getText().contains("Силовой турник"), "Header of relaxing block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn2().$(".rule-description").getText().contains("В 407 офисе вы можете организовать для себя"), "Description of relaxing block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn2().$("img").isDisplayed(), "Image of relaxing block 02 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyRelaxingBlock3() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getRelaxItem().click();
        softAssert.assertTrue(rulesPage.getRuleColumn3().isDisplayed(), "Block 03 of Relaxing isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleColumn3().$(".rule-number").getText(), "03", "Number of relaxing block 03 is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn3().$(".rule-header").getText().contains("Душевая комната"), "Header of relaxing block 03 is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn3().$(".rule-description").getText().contains("В 304 офисе"), "Description of relaxing block 03 is wrong");
        softAssert.assertTrue(rulesPage.getRuleColumn3().$("img").isDisplayed(), "Image of relaxing block 03 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyAttentionSection() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getRelaxItem().click();
        softAssert.assertTrue(rulesPage.getRuleQuestionsBlock().isDisplayed(), "Attention section of relaxing isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleQuestionsHeader(), "Правила пользования душевой комнатой:", "Header of attention section of relaxing block is wrong");
        softAssert.assertEquals(rulesPage.getCountAttentionRules(), "5", "Count of attention rules is wrong");
        softAssert.assertTrue(rulesPage.isAttentionRulesCorrect(), "Attention rules of relaxing block are wrong");
        softAssert.assertAll();
    }
}
