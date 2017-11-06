package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.SportPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP381SportSectionContentTest extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;
    private static SportPage sportPage;


    @BeforeClass
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
        leftHeaderMenu.getSportLink().click();
        sportPage = new SportPage();
    }

    @Test
    public void verifySectionsNamesDisplayed() {
        Assert.assertTrue(sportPage.isSectionNamesDisplayed(), "Sport section names are wrong");
    }

    @Test
    public void verifySectionsImagesDisplayed() {
        Assert.assertTrue(sportPage.isSectionImageDisplayed(), "Sport section images are wrong");
    }

    @Test
    public void verifyEachSectionWorkersHoursDisplayed() {
        Assert.assertTrue(sportPage.isEachSportSectionWorkersHoursDisplayed(), "Sport section schedule hours aren't displayed");
    }

    @Test
    public void verifyEachSectionScheduleDaysDisplayed() {
        Assert.assertTrue(sportPage.isEachSportSectionScheduleDaysDisplayed(), "Sport section schedule days aren't displayed");
    }

    @Test
    public void verifyEachSectionAddressDisplayed() {
        Assert.assertTrue(sportPage.isEachSportSectionAddressDisplayed(), "Sport section doesn't have address");
    }

    @Test
    public void verifyEachSectionMapDisplayed() {
        Assert.assertTrue(sportPage.isEachSportSectionMapDisplayed(), "Sport section doesn't have map");
    }

    @Test
    public void verifyEachSectionCostDisplayed() {
        Assert.assertTrue(sportPage.isEachSportSectionCostDisplayed(), "Sport section doesn't have text 'Оплачивает компания'");
    }

    @Test
    public void verifyEachSectionSkypeData() {
        Assert.assertTrue(sportPage.isEachSkypeDateDisplayed(), "Sport section doesn't have skype dates");
    }


    @Test
    public void verifyActiveSkypeLinks() {
        Assert.assertTrue(sportPage.isActiveSkypeLinks(), "Sport section doesn't have active skype links");
    }
}
