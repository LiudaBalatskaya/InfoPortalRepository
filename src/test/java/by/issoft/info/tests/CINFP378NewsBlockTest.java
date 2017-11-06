package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.TrainingCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP378NewsBlockTest extends BaseTest {
    private static TrainingCenterPage trainingCenterPage;


    @BeforeMethod
    public void openPage() {
        trainingCenterPage = open(TrainingCenterPage.URL, TrainingCenterPage.class);
    }


    @Test()
    public void verifyVisibleNewsBlock() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.getNewsBlock().isDisplayed(), "News block isn't displayed");
        softAssert.assertEquals(trainingCenterPage.getNewsTitle(), "НОВОСТИ ЦЕНТРА", "Title of news block is wrong");
        softAssert.assertTrue(trainingCenterPage.getNewsItemsSize() > 0, "News in the block 'НОВОСТИ ЦЕНТРА' isn't displayed");
        softAssert.assertTrue(trainingCenterPage.isVisibleMonthsOfNews(), "Months of news in the block 'НОВОСТИ ЦЕНТРА' aren't displayed");
        softAssert.assertTrue(trainingCenterPage.isVisibleDescriptionsOfNews(), "Descriptions of news in the block 'НОВОСТИ ЦЕНТРА' aren't displayed");
        softAssert.assertTrue(trainingCenterPage.isVisibleNumbersOfNews(), "Numbers of news in the block 'НОВОСТИ ЦЕНТРА' aren't displayed");
        softAssert.assertTrue(trainingCenterPage.getAllNewsLink().isDisplayed(), "All news link in the block 'НОВОСТИ ЦЕНТРА' isn't displayed");
        softAssert.assertEquals(trainingCenterPage.getAllNewsLink().getText(), "Все новости", "Label 'Все новости' of news block is wrong");
        softAssert.assertAll();
    }
}
