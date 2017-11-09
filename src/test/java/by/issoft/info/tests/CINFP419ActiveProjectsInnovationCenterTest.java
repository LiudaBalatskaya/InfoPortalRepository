package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.InnovationCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP419ActiveProjectsInnovationCenterTest extends BaseTest {
    private static InnovationCenterPage innovationCenterPage;


    @BeforeMethod
    public void openPage() {
        innovationCenterPage = open(InnovationCenterPage.URL, InnovationCenterPage.class);
    }

    @Test()
    public void verifyActiveProjectSection() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(innovationCenterPage.getActiveProjectsSection().isDisplayed(), "Active projects section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getActiveProjectsSection().$("h2").getText(), ("АКТИВНЫЕ ПРОЕКТЫ"), "Title of active projects section is wrong");
        softAssert.assertEquals(innovationCenterPage.getActiveProjectsCount(), (5), "Count of active projects in the section is wrong");
        softAssert.assertTrue(innovationCenterPage.isVisibleActiveProjects(), "Active projects in the section aren't visible");

        softAssert.assertAll();
    }
}
