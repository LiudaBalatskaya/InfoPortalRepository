package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

import by.issoft.info.po.IndividualPage;
import by.issoft.info.po.TeamPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP367IssoftOperationsTest extends BaseTest {
    private static TeamPage teamPage;


    @BeforeClass
    public void openPage() {
        teamPage = open(TeamPage.URL, TeamPage.class);
    }


    @Test()
    public void verifyGeneralManagerBlock() {
        String linkUrl;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getSectionNameGeneralManagement().isDisplayed(), "General Management block is not displayed");
        LOGGER.info("General Management block is displayed ");

        softAssert.assertEquals(teamPage.getSectionNameGeneralManagement().getText(), "ISsoft General Management", "Name of section is wrong");
        LOGGER.info("Name of section is true ");

        softAssert.assertTrue(teamPage.getPictureGeneralManagement().isDisplayed(), "General Management picture is not displayed");
        LOGGER.info("Picture of section is true ");

        softAssert.assertEquals(teamPage.getFullNameGeneralManagement(), "Alexandre Schneerson", "Full Name of General Management is wrong");
        LOGGER.info("Full Name of General Management is true ");

        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveLinkGeneralManager() {
        teamPage.getLinkGeneralManagement();
        IndividualPage individualPage = new IndividualPage();
        Assert.assertEquals($(individualPage.FULL_NAME).getText(), "Schneerson, Alexandre", "Link from General Manager block is wrong");
        getWebDriver().switchTo().window(teamPage.winHandlePage);
    }


    @Test()
    public void verifyDeveloperDepartmentBlock() {
        String linkUrl;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getSectionNameDevelopmentDepartment().isDisplayed(), "Development Department block is not displayed");

        softAssert.assertEquals(teamPage.getSectionNameDevelopmentDepartment().getText(), "Development Department", "Name of section is wrong");

        softAssert.assertTrue(teamPage.getPictureDevelopmentDepartment().isDisplayed(), "Development Department picture is not displayed");

        softAssert.assertEquals(teamPage.getFullNameDevelopmentDepartment(), "Gennadiy Cherkes", "Full Name of Development Department is wrong");

        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveLinkDeveloperDepartment() {
        teamPage.getLinkDevelopmentDepartment();
        IndividualPage individualPage = new IndividualPage();
        Assert.assertEquals($(individualPage.FULL_NAME).getText(), "Cherkes, Gennadiy", "Link from Developer Department block is wrong");
        getWebDriver().switchTo().window(teamPage.winHandlePage);
    }


    @Test()
    public void verifyTrainingCenterBlock() {
        String linkUrl;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getSectionNameTrainingCenter().isDisplayed(), "Training Center block is not displayed");

        softAssert.assertEquals(teamPage.getSectionNameTrainingCenter().getText(), "Training Center", "Name of section is wrong");

        softAssert.assertTrue(teamPage.getPictureTrainingCenter().isDisplayed(), "Training Center picture is not displayed");

        softAssert.assertEquals(teamPage.getFullNameTrainingCenter(), "Oleg Fridlyand", "Full Name of Training Center is wrong");

        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveLinkTrainingCenter() {
        teamPage.getLinkTrainingCenter();
        IndividualPage individualPage = new IndividualPage();
        Assert.assertEquals($(individualPage.FULL_NAME).getText(), "Fridlyand, Oleg", "Link from Training Center block is wrong");
        getWebDriver().switchTo().window(teamPage.winHandlePage);
    }


    @Test()
    public void verifyQADepartmentBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getSectionNameQADepartment().isDisplayed(), "QA Department block is not displayed");

        softAssert.assertEquals(teamPage.getSectionNameQADepartment().getText(), "QA Department", "Name of section is wrong");

        softAssert.assertTrue(teamPage.getPictureQADepartment().isDisplayed(), "QA Department picture is not displayed");

        softAssert.assertEquals(teamPage.getFullNameQADepartment(), "Marina Lepeshko", "Full Name of Training Center is wrong");

        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveLinkQADepartment() {
        teamPage.getLinkQADepartment();
        IndividualPage individualPage = new IndividualPage();
        Assert.assertEquals($(individualPage.FULL_NAME).getText(), "Lepeshko, Marina", "Link from QA Department block is wrong");
        getWebDriver().switchTo().window(teamPage.winHandlePage);
    }


    @Test()
    public void verifyPMOBlock() {
        String linkUrl;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getSectionPMO().isDisplayed(), "PMO block is not displayed");

        softAssert.assertEquals(teamPage.getSectionPMO().getText(), "PMO", "Name of section is wrong");

        softAssert.assertTrue(teamPage.getPicturePMO().isDisplayed(), "PMO picture is not displayed");

        softAssert.assertEquals(teamPage.getFullNamePMO(), "Eugen Sinkevich", "Full Name of Training Center is wrong");

        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveLinkPMO() {
        teamPage.getLinkPMO();
        IndividualPage individualPage = new IndividualPage();
        Assert.assertEquals($(individualPage.FULL_NAME).getText(), "Sinkevich, Eugen", "Link from PMO block is wrong");
        getWebDriver().switchTo().window(teamPage.winHandlePage);
    }


    @Test()
    public void verifyCareerDevelopmentBlock() {
        String linkUrl;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getSectionNameCareerDevelopment().isDisplayed(), "Career Development block is not displayed");

        softAssert.assertEquals(teamPage.getSectionNameCareerDevelopment().getText(), "Career Development", "Name of section is wrong");

        softAssert.assertTrue(teamPage.getPictureCareerDevelopment().isDisplayed(), "Career Development picture is not displayed");

        softAssert.assertEquals(teamPage.getFullNameCareerDevelopment(), "Andrei Yurevich", "Full Name of Training Center is wrong");

        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveLinkCareerDevelopment() {
        teamPage.getLinkCareerDevelopment();
        IndividualPage individualPage = new IndividualPage();
        Assert.assertEquals($(individualPage.FULL_NAME).getText(), "Yurevich, Andrei", "Link from Career Development block is wrong");
        getWebDriver().switchTo().window(teamPage.winHandlePage);
    }


    @Test()
    public void verifyBAUIUXManagementBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(teamPage.getSectionNameBAMenegment().isDisplayed(), "BA/UI/UX Management block is not displayed");

        softAssert.assertEquals(teamPage.getSectionNameBAMenegment().getText(), "BA/UI/UX Management", "Name of section is wrong");

        softAssert.assertTrue(teamPage.getPictureBAManagement().isDisplayed(), "BA/UI/UX Management picture is not displayed");

        softAssert.assertEquals(teamPage.getFullNameBAManagement(), "Andrei Yurevich", "Full Name of Training Center is wrong");

        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveLinkBAUIUXManagement() {
        teamPage.getLinkPageBAManagement();
        IndividualPage individualPage = new IndividualPage();
        Assert.assertEquals($(individualPage.FULL_NAME).getText(), "Yurevich, Andrei", "Link from BA/UI/UX/ Management block is wrong");
        getWebDriver().switchTo().window(teamPage.winHandlePage);
    }


    @Test()
    public void verifyDepartmentNames() {
        Assert.assertTrue(teamPage.isVisibleDepartmentNames(), "Names of departments on the ISSOFT(OPERATIONS) item are wrong");
    }


    @Test()
    public void verifyFullNames() {
        Assert.assertTrue(teamPage.isVisibleDepartmentFullNames(), "Full names of departments on the ISSOFT(OPERATIONS) item are wrong");
    }


    @Test()
    public void verifyPictures() {
        Assert.assertTrue(teamPage.isVisibleDepartmentImages(), "Pictures of departments on the ISSOFT(OPERATIONS) item are wrong");
    }


    @Test()
    public void verifyActiveLinks() {
        Assert.assertTrue(teamPage.isActiveLinks(), "Links of departments on the ISSOFT(OPERATIONS) item are wrong");
    }
}
