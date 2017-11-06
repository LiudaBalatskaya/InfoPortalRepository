package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP412HeaderRulesPageTest extends BaseTest{
    private static RulesPage rulesPage;


    @BeforeMethod
    public void openPage() {
        rulesPage = open(RulesPage.URL, RulesPage.class);
    }

    @Test()
    public void verifyHeaderLogo() {
        Assert.assertTrue(rulesPage.getISsoftLogo().isDisplayed(), "ISsoft Logo isn't displayed");
    }


    @Test
    public void verifyBracketedTitle() {
        Assert.assertEquals(rulesPage.getBracketedTitle(), "ПРАВИЛА КОМПАНИИ", " Bracketed title is wrong");
    }


    @Test()
    public void verifyCoherentLogo() {
        Assert.assertTrue(rulesPage.getCoherentLogo().isDisplayed(), "Page Coherent Logo isn't displayed");
    }

}

