package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

import by.issoft.info.po.CoherentSolutionsPage;
import by.issoft.info.po.TeamPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP369CoherentSolutionsTest extends BaseTest {
    private static TeamPage teamPage;
    private static CoherentSolutionsPage coherentPage;


    @BeforeClass
    public void openPage() {
        WebDriver driver = getWebDriver();

        driver.get("http://info-portal.dev.coherentprojects.net/team");
        teamPage = open(TeamPage.URL, TeamPage.class);
        teamPage.getItemCoherentSolutions().click();
        String currentURL = url();
        coherentPage = new CoherentSolutionsPage();
    }


    @Test
    public void verifyVisibleActiveItemCoherentSolutions() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getItemCoherentSolutions().isDisplayed(), "Menu item 'COHERENT SOLUTIONS' isn't displayed");
        teamPage.getItemCoherentSolutions();
        softAssert.assertTrue($(coherentPage.BODY_PAGE).isDisplayed(), "Page  'COHERENT SOLUTIONS' isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyDepartmentNames() {
        String currentURL = url();
        Assert.assertTrue(coherentPage.isVisibleDepartmentNames(), "Names of departments on the 'COHERENT SOLUTIONS' page are wrong");
    }


    @Test()
    public void verifyFullNames() {
        Assert.assertTrue(coherentPage.isVisibleDepartmentFullNames(), "Full names of departments on the 'COHERENT SOLUTIONS' page are wrong");
    }


    @Test()
    public void verifyPictures() {
        Assert.assertTrue(coherentPage.isVisibleDepartmentImages(), "Pictures of departments on the 'COHERENT SOLUTIONS' page are wrong");
    }


    @Test()
    public void verifyActiveLinks() {
        Assert.assertTrue(coherentPage.isActiveLinks(), "Links of departments on the 'COHERENT SOLUTIONS' page are wrong");
    }
}
