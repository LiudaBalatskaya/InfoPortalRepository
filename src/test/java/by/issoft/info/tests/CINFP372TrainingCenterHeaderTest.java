package by.issoft.info.tests;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.TrainersPage;
import by.issoft.info.po.TrainingCenterPage;
import by.issoft.info.po.TrainingsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP372TrainingCenterHeaderTest extends BaseTest {
    private static LeftHeaderMenu leftHeaderMenu;
    private static TrainingCenterPage trainingCenterPage;


    @BeforeClass
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
        leftHeaderMenu.getTrainingCenterLink().click();
        trainingCenterPage = new TrainingCenterPage();
    }


    @Test
    public void verifyISsoftLogo() {
        Assert.assertTrue(trainingCenterPage.getISsoftLogo().isDisplayed(), "ISSoft Logo is absent");
    }


    @Test
    public void verifyBracketedTitle() {
        assertEquals(trainingCenterPage.getBracketedTitle(), "ТРЕНИНГ-ЦЕНТР", " Bracketed title is wrong");
    }


    @Test
    public void verifyTitle() {
        String title = trainingCenterPage.getClass().getSimpleName();
        assertEquals(title(), "InfoPortal",
                "Wrong " + trainingCenterPage.getClass().getSimpleName() + " title. ");
    }


    @Test
    public void verifyISsoftCoherentLogo() {
        Assert.assertTrue(trainingCenterPage.getCoherentLogo().isDisplayed(), "Coherent Logo is absent");
    }


    @Test
    public void verifyAboutCenterHeaderLink() {
        Assert.assertTrue(trainingCenterPage.getAboutCenterHeaderLink().isDisplayed(), "Active link 'О ЦЕНТРЕ' isn't visible");
    }


    @Test
    public void verifyScheduleHeaderLink() {
        trainingCenterPage.getScheduleHeaderLink().click();
        // It is bug on the page
        //  assertEquals(url(), baseUrl + TeamPage.URL, "'Schedule' ('Расписание') header link is wrong");
    }


    @Test
    public void verifyTrainingHeaderLink() {
        trainingCenterPage.getTrainingsHeaderLink().click();
        assertEquals(url(), baseUrl + TrainingsPage.URL, "'Training' ('Тренинги') header link is wrong");
    }


    @Test
    public void verifyTrainersHeaderLink() {
        trainingCenterPage.getTrainersHeaderLink().click();
        assertEquals(url(), baseUrl + TrainersPage.URL, "'Trainers' ('Тренеры') header link is wrong");
    }
}
