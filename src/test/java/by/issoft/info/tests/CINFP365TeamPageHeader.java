package by.issoft.info.tests;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

import by.issoft.info.po.AboutCompanyPage;
import by.issoft.info.po.NewsPage;
import by.issoft.info.po.TeamPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP365TeamPageHeader extends BaseTest {
    private static TeamPage teamPage;


    @BeforeClass
    public void openPage() {
        teamPage = open(TeamPage.URL, TeamPage.class);
    }


    @Test()
    public void verifyHeaderLogo() {
        Assert.assertTrue(teamPage.getISsoftLogo().isDisplayed(), "ISsoft Logo isn't displayed");
    }


    @Test
    public void verifyBracketedTitle() {
        Assert.assertEquals(teamPage.getBracketedTitle(), "ИНФО-ПОРТАЛ", " Bracketed title is wrong");
    }


    @Test()
    public void verifyCoherentLogo() {
        Assert.assertTrue(teamPage.getCoherentLogo().isDisplayed(), "Page Coherent Logo isn't displayed");
    }


    @Test
    public void verifyAboutCompanyHeaderLink() {
        teamPage.getAboutCompanyHeaderLink().click();
        assertEquals(url(), baseUrl + AboutCompanyPage.URL, "'About company' ('О компании') header link is wrong");
    }


    @Test
    public void verifyNewsHeaderLink() {
        teamPage.getNewsHeaderLink().click();
        assertEquals(url(), baseUrl + NewsPage.URL, "'News' ('Новости') header link is wrong");
    }


    @Test
    public void verifyVisibleTeamHeaderLink() {
        Assert.assertTrue(teamPage.getTeamHeaderLink().isDisplayed(), "'Team' ('Команда') header link isn't displayed");
    }
}
