package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.TrainingCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP373ContentTrainingCenterTest extends BaseTest {
    private static TrainingCenterPage trainingCenterPage;


    @BeforeMethod
    public void openPage() {
        trainingCenterPage = open(TrainingCenterPage.URL, TrainingCenterPage.class);
    }


    @Test()
    public void verifyScheduleBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.getScheduleBlock().isDisplayed(), "Schedule (Расписание) block is not displayed");
        softAssert.assertTrue(trainingCenterPage.getScheduleBlockImage().isDisplayed(), "Image of schedule block is not displayed");
        softAssert.assertEquals(trainingCenterPage.getScheduleBlockTitle().getText(), "РАСПИСАНИЕ" + '\n' + "НА 2017 ГОД", "Title of schedule block is not displayed");
        softAssert.assertFalse(trainingCenterPage.isActiveScheduleBlockLink(), "Link of schedule block isn't null");
        // softAssert.assertEquals(url(), baseUrl + SportPage.URL, SportPage.class.getSimpleName() + " is not open");
        softAssert.assertAll();
    }


    @Test()
    public void verifyYammerBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.getYammerBlock().isDisplayed(), "Yammer block is not displayed");
        softAssert.assertEquals(trainingCenterPage.getYammerBlockTitle().getText(), "НАША ГРУППА" + '\n' + "В ЯММЕРЕ", "Title of yammer block is not displayed");
        softAssert.assertTrue(trainingCenterPage.isActiveYammerBlockLink(), "Link of Jammer block is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyWritingAtTrainingBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.getWritingTrainingBlock().isDisplayed(), "Writing Training block is not displayed");
        softAssert.assertEquals(trainingCenterPage.getWritingTrainingBlockTitle().getText(), "ЗАПИСАТЬСЯ" + '\n' + "НА ТРЕНИНГ", "Title of Writing Training block is not displayed");
        softAssert.assertTrue(trainingCenterPage.getWritingTrainingBlockImage().isDisplayed(), "Image of Writing Training block is not displayed");
        softAssert.assertTrue(trainingCenterPage.isActiveWritingTrainingBlockLink().contains("Запись на тренинг"), "Link of Writing Training block is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyTrainingListBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.getTrainingListBlock().isDisplayed(), "Training list block is not displayed");
        softAssert.assertEquals(trainingCenterPage.getTrainingListBlock().$("h2").getText(), "СПИСОК" + '\n' + "ТРЕНИНГОВ", "Title of еraining list is not displayed");
        softAssert.assertTrue(trainingCenterPage.isActiveTrainingListBlockLink(), "Link of Training list block is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyAboutCenterBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.getAboutCenterBlock().isDisplayed(), "About center (О ЦЕНТРЕ) block is not displayed");
        softAssert.assertEquals(trainingCenterPage.getAboutCenterBlockTitle().getText(), "О ЦЕНТРЕ", "About center (О ЦЕНТРЕ) block Title is wrong");
        softAssert.assertTrue(trainingCenterPage.isAboutCenterDescriptionVisible(), "About center block description is wrong");
        softAssert.assertTrue(trainingCenterPage.isAboutCenterLeaderVisible(), "About center leader is wrong");
        softAssert.assertTrue(trainingCenterPage.isActiveAboutCenterLinkActive(), "Link of About center block is wrong");
        softAssert.assertAll();
    }
}
