package by.issoft.info.tests;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

import by.issoft.info.po.AboutCompanyPage;
import by.issoft.info.po.HomePage;
import by.issoft.info.po.NewsPage;
import by.issoft.info.po.TeamPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP393HeaderNavigationLinks extends BaseTest {
    private static HomePage homePage;


    @BeforeMethod
    public void openHomePage() {
        homePage = open(HomePage.URL, HomePage.class);
    }


    @Test
    public void verifyAboutCompanyHeaderLink() {
        homePage.getAboutCompanyHeaderLink().click();
        assertEquals(url(), baseUrl + AboutCompanyPage.URL, "'About company' ('О компании') header link is wrong");
    }


    @Test
    public void verifyNewsHeaderLink() {
        homePage.getNewsHeaderLink().click();
        assertEquals(url(), baseUrl + NewsPage.URL, "'News' ('Новости') header link is wrong");
    }


    @Test
    public void verifyTeamHeaderLink() {
        homePage.getTeamHeaderLink().click();
        assertEquals(url(), baseUrl + TeamPage.URL, "'Team' ('Команда') header link is wrong");
    }
}
