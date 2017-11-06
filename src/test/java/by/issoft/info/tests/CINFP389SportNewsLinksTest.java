package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.SportPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP389SportNewsLinksTest extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;
    private static SportPage sportPage;


    @BeforeMethod
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
        leftHeaderMenu.getSportLink().click();
        sportPage = new SportPage();
    }

    @Test()
    public void verifyActiveAllNewsSportLinks() {
        Assert.assertTrue(sportPage.isActiveNewsSportLinks(), "There isn't active sport news link on the page");
    }

    @Test()
    public void verifyActiveAllNewsLink() {
        Assert.assertTrue(sportPage.isActiveAllNewsLink(), "There isn't active all news link on the page");
    }

}
