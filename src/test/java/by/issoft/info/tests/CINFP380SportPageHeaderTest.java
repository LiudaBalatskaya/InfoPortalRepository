package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.SportPage;
import org.testng.annotations.BeforeMethod;

public class CINFP380SportPageHeaderTest extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;
    private static SportPage sportPage;


    @BeforeMethod
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
        leftHeaderMenu.getSportLink().click();
        sportPage = new SportPage();
    }
}
