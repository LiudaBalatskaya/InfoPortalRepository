package by.issoft.info.tests;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

import by.issoft.info.po.AboutPage;
import by.issoft.info.po.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP393HeaderNavigationLinks extends BaseTest {
    private static HomePage homePage;


    @BeforeMethod
    public void openHomePage() {
        homePage = open(HomePage.URL, HomePage.class);
    }


    @Test
    public void checkAboutCompanyLink() {
        homePage.getAboutCompanyMenu().click();
        assertEquals(url(), baseUrl + AboutPage.URL, "'About company' ('О компании') menu link is wrong.");
    }


    @Test
    public void checkAboutCompanyLink2222222222222222() {
        homePage.getAboutCompanyMenu().click();
        assertEquals(url(), baseUrl + AboutPage.URL + "2222222222", "'About company' ('О компании') menu link is wrong.");
    }


    //    @Test
    //    public void checkNewsLink() {
    //
    //    }
    //
    //
    //    @Test
    //    public void checkTeamLink() {
    //
    //    }
}
