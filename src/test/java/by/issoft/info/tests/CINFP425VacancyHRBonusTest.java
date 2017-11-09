package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HrBonusesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP425VacancyHRBonusTest extends BaseTest {
    private static HrBonusesPage hrBonusesPage;


    @BeforeMethod
    public void openPage() {
        hrBonusesPage = open(HrBonusesPage.URL, HrBonusesPage.class);
    }

    @Test()
    public void verifyVacancyHRBonusSystem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hrBonusesPage.getVacancies().isDisplayed(), "Vacancies section isn't displayed");
        softAssert.assertEquals(hrBonusesPage.getVacancies().$("h2").getText(), ("ВАКАНСИИ"), "Title 'Вакансии' of Bonus system section is wrong");
        softAssert.assertTrue(hrBonusesPage.isVisibleVacancies(), "Vacancies items are wrong");
        softAssert.assertEquals(hrBonusesPage.getVacancies().$("a").getText(), ("СКАЧАТЬ РЕЗЮМЕ"), "Link name of Vacancies section is wrong");
        softAssert.assertTrue(hrBonusesPage.getVacancies().$("a").getAttribute("href").contains("www.issoft.by/ISsoft.doc"), "Link of Vacancies section is wrong");
        softAssert.assertAll();
    }

}
