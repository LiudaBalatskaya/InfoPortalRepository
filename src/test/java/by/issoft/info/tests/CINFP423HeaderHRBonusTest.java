package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HrBonusesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP423HeaderHRBonusTest extends BaseTest {
    private static HrBonusesPage hrBonusesPage;


    @BeforeMethod
    public void openPage() {
        hrBonusesPage = open(HrBonusesPage.URL, HrBonusesPage.class);
    }


    @Test()
    public void verifyHeaderLogo() {
        Assert.assertTrue(hrBonusesPage.getISsoftLogo().isDisplayed(), "ISsoft Logo isn't displayed");
    }


    @Test
    public void verifyBracketedTitle() {
        Assert.assertEquals(hrBonusesPage.getBracketedTitle(), "HR БОНУСЫ", " Bracketed title is wrong");
    }


    @Test()
    public void verifyCoherentLogo() {
        Assert.assertTrue(hrBonusesPage.getCoherentLogo().isDisplayed(), "Page Coherent Logo isn't displayed");
    }
}
