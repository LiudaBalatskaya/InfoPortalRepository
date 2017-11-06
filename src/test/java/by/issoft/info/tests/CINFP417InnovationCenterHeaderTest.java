package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.InnovationCenterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP417InnovationCenterHeaderTest extends BaseTest {
    private static InnovationCenterPage innovationCenterPage;


    @BeforeMethod
    public void openPage() {
        innovationCenterPage = open(InnovationCenterPage.URL, InnovationCenterPage.class);
    }


    @Test()
    public void verifyHeaderLogo() {
        Assert.assertTrue(innovationCenterPage.getISsoftLogo().isDisplayed(), "ISsoft Logo isn't displayed");
    }


    @Test
    public void verifyBracketedTitle() {
        Assert.assertEquals(innovationCenterPage.getBracketedTitle(), "ИННОВАЦИОННЫЙ ЦЕНТР", " Bracketed title is wrong");
    }


    @Test()
    public void verifyCoherentLogo() {
        Assert.assertTrue(innovationCenterPage.getCoherentLogo().isDisplayed(), "Page Coherent Logo isn't displayed");
    }
}
