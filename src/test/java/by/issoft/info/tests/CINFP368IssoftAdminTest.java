package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.IssoftAdminPage;
import by.issoft.info.po.TeamPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP368IssoftAdminTest extends BaseTest {
    private static TeamPage teamPage;
    private static IssoftAdminPage adminPage;


    @BeforeClass
    public void openPage() {
        teamPage = open(TeamPage.URL, TeamPage.class);
        teamPage.getItemIssoftAdmin().click();
        adminPage = new IssoftAdminPage();
    }


    @Test
    public void verifyVisibleActiveItemIssoftAdmin() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getItemIssoftAdmin().isDisplayed(), "Menu item 'Issoft(Admin)' isn't displayed");
        teamPage.getPageIssoftAdmin();
        softAssert.assertTrue($(adminPage.BODY_PAGE).isDisplayed(), "Page  'Issoft(Admin)' isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyDepartmentNames() {
        Assert.assertTrue(adminPage.isVisibleDepartmentNames(), "Names of departments on the ISSOFT(ADMIN) page are wrong");
    }


    @Test()
    public void verifyFullNames() {
        Assert.assertTrue(adminPage.isVisibleDepartmentFullNames(), "Full names of departments on the ISSOFT(ADMIN) page are wrong");
    }


    @Test()
    public void verifyPictures() {
        Assert.assertTrue(adminPage.isVisibleDepartmentImages(), "Pictures of departments on the ISSOFT(ADMIN) page are wrong");
    }


    @Test()
    public void verifyActiveLinks() {
        Assert.assertTrue(adminPage.isActiveLinks(), "Links of departments on the ISSOFT(ADMIN) page are wrong");
    }
}

