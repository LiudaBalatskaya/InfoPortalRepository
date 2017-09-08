package by.issoft.info.tests;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

import by.issoft.info.po.GalleryPage;
import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP385LeftHeaderMenu extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;


    @BeforeMethod
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
    }


    @Test()
    public void verifyGalleryMenuItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(leftHeaderMenu.getGalleryIcon().isDisplayed(), "Gallery Icon is not displayed");
        leftHeaderMenu.getGalleryLink().click();
        softAssert.assertEquals(url(), baseUrl + GalleryPage.URL, GalleryPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }
}
