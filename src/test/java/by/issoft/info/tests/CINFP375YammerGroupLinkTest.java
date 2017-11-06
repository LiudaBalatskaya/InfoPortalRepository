package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.TrainingCenterPage;
import by.issoft.info.po.YammerPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP375YammerGroupLinkTest extends BaseTest {
    private static TrainingCenterPage trainingCenterPage;
    private static YammerPage yammerPage;


    @BeforeMethod
    public void openPage() {

        trainingCenterPage = open(TrainingCenterPage.URL, TrainingCenterPage.class);
        yammerPage = new YammerPage();
    }


    @Test()
    public void verifyActiveLinkOfYammerGroup() {
        String textLoadedPage;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(trainingCenterPage.isActiveYammerBlockLink(), "Link of Jammer block is wrong");

        trainingCenterPage.switchToLoadedPage(trainingCenterPage.getYammerBlockLink());
        textLoadedPage = $(yammerPage.YAMMER_MESSAGE).getText();
        softAssert.assertTrue(textLoadedPage.contains(yammerPage.YAMMER_TEXT), "Yammer group link is wrong");

        softAssert.assertAll();
    }
}
