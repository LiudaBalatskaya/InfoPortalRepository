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

public class CINFP359NewsPageHeader extends BaseTest {
    private static NewsPage newsPage;


    @BeforeClass
    public void openPage() {
        newsPage = open(NewsPage.URL, NewsPage.class);
    }


    @Test()
    public void verifyHeaderLogo() {
        Assert.assertTrue(newsPage.getISsoftLogo().isDisplayed(), "ISsoft Logo isn't displayed");
    }


    @Test
    public void verifyBracketedTitle() {
        Assert.assertEquals(newsPage.getBracketedTitle(), "ИНФО-ПОРТАЛ", " Bracketed title is wrong");
    }


    @Test()
    public void verifyCoherentLogo() {
        Assert.assertTrue(newsPage.getCoherentLogo().isDisplayed(), "Page Coherent Logo isn't displayed");
    }


    @Test
    public void verifyAboutCompanyHeaderLink() {
        newsPage.getAboutCompanyHeaderLink().click();
        assertEquals(url(), baseUrl + AboutCompanyPage.URL, "'About company' ('О компании') header link is wrong");
    }


    @Test
    public void verifyTeamHeaderLink() {
        newsPage.getTeamHeaderLink().click();
        assertEquals(url(), baseUrl + TeamPage.URL, "'Team' ('Команда') header link is wrong");
    }


    @Test
    public void verifyVisibleNewsHeaderLink() {
        Assert.assertTrue(newsPage.getNewsHeaderLink().isDisplayed(), "'News' ('Новости') header link isn't displayed");
    }
}
