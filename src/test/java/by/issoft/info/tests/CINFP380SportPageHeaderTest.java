package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.SportPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP380SportPageHeaderTest extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;
    private static SportPage sportPage;


    @BeforeClass
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
        leftHeaderMenu.getSportLink().click();
        sportPage = new SportPage();
    }


    @Test
    public void verifyISsoftLogo() {
        Assert.assertTrue(sportPage.getISsoftLogo().isDisplayed(), "ISSoft Logo is absent");
    }


    @Test
    public void verifyTitle() {
        Assert.assertEquals(title(), "InfoPortal",
                "Wrong " + SportPage.class.getSimpleName() + " title. ");
    }


    @Test
    public void verifyISsoftCoherentLogo() {
        Assert.assertTrue(sportPage.getCoherentLogo().isDisplayed(), "Coherent Logo is absent");
    }


    @Test
    public void verifyBracketedTitle() {
        Assert.assertEquals(sportPage.getBracketedTitle(), "СПОРТ", " Bracketed title is wrong");
    }
}
