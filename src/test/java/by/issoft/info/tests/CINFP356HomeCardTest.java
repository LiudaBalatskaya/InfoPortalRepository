package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

import by.issoft.info.po.GalleryPage;
import by.issoft.info.po.HomePage;
import by.issoft.info.po.HrBonusesPage;
import by.issoft.info.po.InnovationCenterPage;
import by.issoft.info.po.TrainingCenterPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP356HomeCardTest extends BaseTest {
    private static HomePage homePage;
    private static GalleryPage galleryPage;
    private static TrainingCenterPage trainingCenterPage;
    private static HrBonusesPage hrBonusesPage;
    private static InnovationCenterPage innovationCenterPage;


    @BeforeClass
    public void openHomePage() {
        homePage = open(HomePage.URL, HomePage.class);
    }


    @Test()
    public void verifySportSlideBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getActiveSportSlide().isDisplayed(), "Sport slide isn't displayed");
        softAssert.assertTrue(homePage.isCorrectActiveDaysNumber(), "Active day on the sport slide is wrong");
        softAssert.assertTrue(homePage.isCorrectNameActiveMonth(), "Name of active month on the sport slide is wrong");
        softAssert.assertTrue(homePage.isCorrectStartTime(), "Start time on the sport slide is wrong");
        softAssert.assertTrue(homePage.getStartTimeText().getText().contains("НАЧАЛО"), "Start time text on the sport slide is wrong");
        softAssert.assertTrue(homePage.getEventType().getText().contains("СПОРТ"), "Event type on the sport slide is wrong");
        softAssert.assertTrue(homePage.getEventTitle().isDisplayed(), "Event title on the sport slide isn't displayed");
        softAssert.assertTrue(homePage.getEventSlideImage().isDisplayed(), "Event slide image on the sport slide isn't displayed");
        softAssert.assertTrue(homePage.getButtonNext().isDisplayed(), "Button next on the sport slide isn't displayed");
        softAssert.assertTrue(homePage.getButtonPrevious().isDisplayed(), "Button previous on the sport slide isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyGalleryBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getGallery().isDisplayed(), "Gallery block isn't displayed");
        softAssert.assertTrue(homePage.getGallery().$("h2").getText().contains("ГАЛЕРЕЯ"), "Title of gallery block is wrong");
        softAssert.assertTrue(homePage.getGallery().$(".gallery-image").isDisplayed(), "Image of gallery block isn't displayed");
        softAssert.assertTrue(homePage.getGalleryLink().$("a").getAttribute("href").contains("/media"), "Link of gallery block is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyTrainingBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getTraining().isDisplayed(), "Training  block isn't displayed");
        softAssert.assertTrue(homePage.getTraining().$("a").getAttribute("href").contains("/training-center"), "Link of training block is wrong");
        softAssert.assertTrue(homePage.getTraining().$("h2").getText().contains("ТРЕНИНГ-ЦЕНТР"), "Title of training block is wrong");
        softAssert.assertTrue(homePage.getTraining().$(".training-image").isDisplayed(), "Image of training block isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyHRBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getHRBlock().isDisplayed(), "HR block isn't displayed");
        softAssert.assertTrue(homePage.getHRBlock().$("h2").getText().contains("HR-БОНУСЫ"), "Title of HR block is wrong");
        softAssert.assertTrue(homePage.getHRBlock().$("h3").getText().contains("Порекомендуй специалиста среднего или высокого уровня"),
                "Description of HR block is wrong");
        softAssert.assertTrue(homePage.getHRBlock().$("a").getText().contains("Условия акции"), "Header 'Terms of action' on HR block is wrong");
        softAssert.assertTrue(homePage.getHRBlock().$("a").getAttribute("href").contains("/hr-bonuses"), "Link of terms of action on the HR block is wrong");
        softAssert.assertTrue(homePage.getTraining().$(".training-image").isDisplayed(), "Image of training block isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyInnovationCenterBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.getInnovationBlock().isDisplayed(), "Innovation Center block isn't displayed");
        softAssert.assertTrue(homePage.getInnovationBlock().$("h2").getText().contains("ИННОВАЦИОННЫЙ ЦЕНТР"), "Title of Innovation Center block is wrong");
        softAssert.assertTrue(homePage.getInnovationLink().exists(), "Link of Innovation Center block isn't exist");
        softAssert.assertTrue(homePage.getInnovationBlock().$(".innovation-image").isDisplayed(), "Image of Innovation Center block isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveLinks() {
        SoftAssert softAssert = new SoftAssert();
        homePage.getGalleryLink().click();
        sleep(2000);
        galleryPage = new GalleryPage();
        softAssert.assertTrue(url().toString().contains(galleryPage.URL), "Link of gallery block isn't active");
        navigator.back();
        sleep(2000);

        homePage.getTraining().click();
        sleep(2000);
        trainingCenterPage = new TrainingCenterPage();
        softAssert.assertTrue(url().toString().contains(trainingCenterPage.URL), "Link of training block isn't active");
        navigator.back();
        sleep(2000);
        softAssert.assertAll();

        homePage.getHRBlock().click();
        sleep(2000);
        hrBonusesPage = new HrBonusesPage();
        softAssert.assertTrue(url().toString().contains(hrBonusesPage.URL), "Link of training block isn't active");
        navigator.back();
        sleep(2000);
        softAssert.assertAll();

        homePage.getInnovationBlock().click();
        sleep(2000);
        innovationCenterPage = new InnovationCenterPage();
        softAssert.assertTrue(url().toString().contains(innovationCenterPage.URL), "Link of training block isn't active");
        navigator.back();
        sleep(2000);
        softAssert.assertAll();
    }
}
