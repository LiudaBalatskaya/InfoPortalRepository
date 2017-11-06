package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP397LunchRulesTest extends BaseTest {
    private static RulesPage rulesPage;


    @BeforeMethod
    public void openPage() {
        rulesPage = open(RulesPage.URL, RulesPage.class);
    }


    @Test()
    public void verifyGeneralInformationLunch() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getDinnerItem().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Как проголосовать за обед", "Dinner header text is wrong");
        softAssert.assertTrue(rulesPage.getRuleHeaderDescription().contains("Для перехода на портал используйте ссылку"), "Dinner description is wrong");
        softAssert.assertTrue(rulesPage.getRuleHeaderDescriptionBlock().$("a").getAttribute("href").contains("https://lunchvoting.issoft.by"), "Link of general dinner description is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock1Lunch() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getDinnerItem().click();
        softAssert.assertTrue(rulesPage.getRuleStep1().isDisplayed(), "Information Block 01 of Lunch isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep1().$(".rule-number").getText(), "01", "Number of lunch block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$(".rule-header").getText().contains("Для входа в систему используйте свои доменные"), "Header of lunch block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$(".rule-step-image").isDisplayed(), "Image of lunch block 01 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock2Lunch() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getDinnerItem().click();
        softAssert.assertTrue(rulesPage.getRuleStep2().isDisplayed(), "Information Block 02 of Lunch isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep2().$(".rule-number").getText(), "02", "Number of lunch block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$(".rule-header").getText().contains("Кликните мышкой на календаре тот день"), "Header of lunch block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$(".rule-step-image").isDisplayed(), "Image of lunch block 02 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock3Lunch() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getDinnerItem().click();
        softAssert.assertTrue(rulesPage.getRuleStep3().isDisplayed(), "Information Block 03 of Lunch isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep3().$(".rule-number").getText(), "03", "Number of lunch block 03 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep3().$(".rule-header").getText().contains("Выберите понравившийся вариант мышкой"), "Header of lunch block 03 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep3().$(".rule-step-image").isDisplayed(), "Image of lunch block 03 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock4Lunch() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getDinnerItem().click();
        softAssert.assertTrue(rulesPage.getRuleStep4().isDisplayed(), "Information Block 04 of Lunch isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep4().$(".rule-number").getText(), "04", "Number of lunch block 04 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep4().$(".rule-header").getText().contains("Изменить заказ можно пока голосование не закрыто"), "Header of lunch block 04 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep4().$(".rule-step-image").isDisplayed(), "Image of lunch block 04 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock5Lunch() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getDinnerItem().click();
        softAssert.assertTrue(rulesPage.getRuleStep5().isDisplayed(), "Information Block 05 of Lunch isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep5().$(".rule-number").getText(), "05", "Number of lunch block 05 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep5().$(".rule-header").getText().contains("Также присутствует возможность оценить любое из блюд"), "Header of lunch block 05 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep5().$(".rule-step-image").isDisplayed(), "Image of lunch block 05 isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyBlock6Lunch() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getDinnerItem().click();
        softAssert.assertTrue(rulesPage.getRuleStep6().isDisplayed(), "Information Block 06 of Lunch isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep6().$(".rule-number").getText(), "06", "Number of lunch block 06 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep6().$(".rule-header").getText().contains("Результаты оценки блюд можно увидеть на вкладке \"Рейтинг"), "Header of lunch block 06 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep6().$(".rule-step-image").isDisplayed(), "Image of lunch block 06 isn't displayed");
        softAssert.assertAll();
    }
}
