package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.SportPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP408PoolSkypeDateTest extends BaseTest {
    private static SportPage sportPage;


    @BeforeMethod
    public void openPage() {
            sportPage = open(SportPage.URL, SportPage.class);
        }

    @Test
    public void verifyPoolSkypeDateDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(sportPage.isVisibleCoachInformation(), "Pool section doesn't display Skype information of a couch");
        softAssert.assertTrue(sportPage.isVisiblePollManagerInformation(), "Pool section doesn't display Skype information of a manager");
        softAssert.assertAll();
    }

}
