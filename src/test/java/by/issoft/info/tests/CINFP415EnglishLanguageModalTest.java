package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.SocialPackagePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP415EnglishLanguageModalTest extends BaseTest {
    private static SocialPackagePage socialPage;


    @BeforeMethod
    public void openPage() {
        socialPage = open(SocialPackagePage.URL, SocialPackagePage.class);
    }


    @Test
    public void verifyEnglishLanguageModal() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(socialPage.getEnglishLanguageItem().isDisplayed(), " English Language item isn't displayed");
        socialPage.getEnglishLanguageItem().click();
        socialPage.getModalBlock().isDisplayed();
        softAssert.assertTrue(socialPage.getModalBlock().isDisplayed(), " Modal block of English Language item isn't displayed");
        softAssert.assertEquals(socialPage.getModalBlock().$("h1").getText(), "Английский язык", " Modal block title of English Language item is wrong");
        softAssert.assertEquals(socialPage.getModalBlock().$("p").getText(), "В нашей компании есть несколько способов изучать английский язык.",
                " Modal block title of English Language item is wrong");
        softAssert.assertTrue(socialPage.isVisibleCorrectDescriptionEnglishModal(), " Descriptions of English Language Modal is wrong");
        softAssert.assertEquals(socialPage.getHeaderOfficialEnglish().getText(), "По всем вопросам можно обращаться к",
                "Descriptions of header official english is wrong");
        softAssert.assertTrue(socialPage.isVisibleCorrectEnglishOfficials(), " Descriptions of english officials is wrong");
        socialPage.getModalBlock().$(" .close-icon").isDisplayed();
        socialPage.getModalBlock().$(" .close-icon").click();

        softAssert.assertAll();
    }
}
