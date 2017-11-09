package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.InnovationCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP422NewsInnovationCenterTest extends BaseTest {
    private static InnovationCenterPage innovationCenterPage;


    @BeforeMethod
    public void openPage() {
        innovationCenterPage = open(InnovationCenterPage.URL, InnovationCenterPage.class);
    }


    @Test()
    public void verifyActiveNewsSection() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(innovationCenterPage.getNewsSide().isDisplayed(), "News section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getNewsSide().$("h2").getText(), ("НОВОСТИ ЦЕНТРА"), "Title of active projects section is wrong");
        softAssert.assertEquals(innovationCenterPage.getCountNewsItem(), (4), "Count of active projects in the section is wrong");
        softAssert.assertTrue(innovationCenterPage.isEachNewsItemDisplayed(), "Some news isn't displayed");

        softAssert.assertTrue(innovationCenterPage.getAllNews().isDisplayed(), "All news in the News section isn't visible");
        softAssert.assertTrue(innovationCenterPage.getAllNews().getText().contains("Все новости"), "Text <Все новости> in the News section is wrong");
        softAssert.assertTrue(innovationCenterPage.getAllNews().getAttribute("href").contains("/news"), "Link of <Все новости> in the News section is wrong");
        softAssert.assertAll();
    }
}
