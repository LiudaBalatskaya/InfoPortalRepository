package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP399EquipmentRulesTest extends BaseTest {
    private static RulesPage rulesPage;

    @BeforeMethod
    public void openPage() {
        rulesPage = open(RulesPage.URL, RulesPage.class);
    }

    @Test()
    public void verifyEquipmentBlock1() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getPrinterItem().click();
        softAssert.assertEquals(rulesPage.getFirstItemTitle(), "Принтеры и оборудование", "Equipment  header text is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().isDisplayed(), "Block 01 of equipment (Принтеры и оборудование) isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep1().$(".rule-number").getText(), "01", "Number of equipment block is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$(".rule-header").getText().contains("Откройте Windows Explorer и в адресной строке введите"), "Header of equipment block 01 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep1().$("img").isDisplayed(), "Image of equipment block 01 isn't displayed");
        softAssert.assertAll();
    }

    @Test()
    public void verifyEquipmentBlock2() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getPrinterItem().click();
        softAssert.assertTrue(rulesPage.getRuleStep2().isDisplayed(), "Block 02 of equipment (Принтеры и оборудование) isn't displayed");
        softAssert.assertEquals(rulesPage.getRuleStep2().$(".rule-number").getText(), "02", "Number of equipment block is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$(".rule-header").getText().contains("В открывшемся окне выбираете принтер"), "Header of equipment block 02 is wrong");
        softAssert.assertTrue(rulesPage.getRuleStep2().$("img").isDisplayed(), "Image of equipment block 02 isn't displayed");
        softAssert.assertAll();
    }

    @Test()
    public void verifyAttentionEquipmentSection() {
        SoftAssert softAssert = new SoftAssert();
        rulesPage.getPrinterItem().click();
        softAssert.assertTrue(rulesPage.getWarningWrapper().isDisplayed(), "Attention section of equipment (Принтеры и оборудование) isn't displayed");
        softAssert.assertEquals(rulesPage.getWarningWrapper().$(".title-header-text").getText(), "Обратите внимание!", "Header of attention section of equipment block is wrong");
        softAssert.assertTrue(rulesPage.getWarningWrapper().$("p:nth-of-type(1)").getText().contains("Если у вас возникла необходимость принести своё оборудование"), "Attention rules 1 of equipment block are wrong");
        softAssert.assertTrue(rulesPage.getWarningWrapper().$("p:nth-of-type(2)").getText().contains("При необходимости вынести оборудование"), "Attention rules 2 of equipment block are wrong");
        softAssert.assertTrue(rulesPage.getWarningWrapper().$("p:nth-of-type(3)").getText().contains("Для сбора макулатуры возле принтеров находятся специальные корзины."), "Attention rules 3 of equipment block are wrong");
        softAssert.assertAll();
    }

}
