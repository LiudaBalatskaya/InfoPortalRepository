package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

import by.issoft.info.po.TrainingCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP411TrainersListTest extends BaseTest {
    private static TrainingCenterPage trainingCenterPage;


    @BeforeMethod
    public void openPage() {
        trainingCenterPage = open(TrainingCenterPage.URL, TrainingCenterPage.class);
    }


    @Test()
    public void verifyTrainersListInfo() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.getTrainersListBlock().isDisplayed(), "Trainers block is not displayed");
        softAssert.assertTrue(trainingCenterPage.isVisibleTrainersNamesList(), "Name of trainers block is wrong");
        softAssert.assertTrue(trainingCenterPage.isVisibleTrainersDescriptions(), "Description of trainers is wrong");
        softAssert.assertTrue(trainingCenterPage.isVisibleTrainersPhotos(), "Photos of trainers isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyActiveTrainersLinks() {
        assertTrue(trainingCenterPage.isActiveTrainersLinks(), "Links of trainers are wrong");
    }
}
