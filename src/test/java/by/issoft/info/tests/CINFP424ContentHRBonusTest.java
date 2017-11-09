package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HrBonusesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP424ContentHRBonusTest extends BaseTest {
    private static HrBonusesPage hrBonusesPage;


    @BeforeMethod
    public void openPage() {
        hrBonusesPage = open(HrBonusesPage.URL, HrBonusesPage.class);
    }


    @Test()
    public void verifyContentHRBonusSystem() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(hrBonusesPage.getBonusSystem().isDisplayed(), "Bonus system section isn't displayed");
        softAssert.assertEquals(hrBonusesPage.getBonusSystem().$("h2").getText(), ("БОНУСНАЯ СИСТЕМА"), "Title of Bonus system section is wrong");
        softAssert.assertTrue(hrBonusesPage.getBonusSystem().$("img").isDisplayed(), "Image of bonus system section isn't displayed");
        softAssert.assertEquals(hrBonusesPage.getCountDescriptionItem(), (5), "Description  of Bonus system section is wrong");
        softAssert.assertTrue(hrBonusesPage.isVisibleDescriptions(), "Descriptions of Bonus system section aren't displayed");
        softAssert.assertEquals(hrBonusesPage.getVacancies().$("h2").getText(), ("ВАКАНСИИ"), "Title 'Вакансии' of Bonus system section is wrong");
        softAssert.assertAll();
    }
}
