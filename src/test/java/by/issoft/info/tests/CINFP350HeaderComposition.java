package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

import by.issoft.info.po.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP350HeaderComposition extends BaseTest {

    private static HomePage homePage;


    @BeforeClass
    public void openHomePage() {
        homePage = open(HomePage.URL, HomePage.class);
    }


    @Test
    public void verifyISsoftLogo() {
        Assert.assertTrue(homePage.getISsoftLogo().isDisplayed(), "ISSoft Logo is absent");
    }


    @Test
    public void verifyTitle() {
        Assert.assertEquals(title(), "InfoPortal",
                "Wrong " + HomePage.class.getSimpleName() + " title. ");
    }


    @Test
    public void verifyISsoftCoherentLogo() {
        Assert.assertTrue(homePage.getCoherentLogo().isDisplayed(), "Coherent Logo is absent");
    }
}
