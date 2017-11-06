package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.TrainingCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP379NewsBlockLinksTest extends BaseTest {
    private static TrainingCenterPage trainingCenterPage;


    @BeforeMethod
    public void openPage() {
        trainingCenterPage = open(TrainingCenterPage.URL, TrainingCenterPage.class);
    }


    @Test()
    public void verifyVisibleActiveNewsBlockLinks() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.isVisibleLinksOfNews(), "Links of news block aren't displayed");
        softAssert.assertTrue(trainingCenterPage.isActiveLinksOfNews(), "Links of news block are wrong");
        softAssert.assertTrue(trainingCenterPage.isActiveAllNewsLink(), "Links 'All news' of news block are wrong");
        softAssert.assertAll();
    }
}
