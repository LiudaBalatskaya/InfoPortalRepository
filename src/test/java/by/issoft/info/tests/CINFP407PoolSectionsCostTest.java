package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.SportPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP407PoolSectionsCostTest extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;
    private static SportPage sportPage;


    @BeforeMethod
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
        leftHeaderMenu.getSportLink().click();
        sportPage = new SportPage();
    }

    @Test
    public void verifyTitlePaidCompanyCostDisplayed() {
        Assert.assertTrue(sportPage.isTitlePaidCompanyCostDisplayed(), "Sport section doesn't display text 'Стоимость: Оплачивает компания'");
    }

    @Test
    public void verifyPoolCostsNotDisplayed() {
        Assert.assertFalse(sportPage.isNotVisiblePoolCosts(), "Sport section displays prices before clicking button 'Подробнее'");
    }

    @Test
    public void verifyPoolCostsInformationDisplayed() {
        Assert.assertTrue(sportPage.isVisiblePoolCosts(), "Sport section displays prices before clicking button 'Подробнее'");
    }
}
