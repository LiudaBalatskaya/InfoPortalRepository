package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.InnovationCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP420DevelopmentsInnovationCenterTest extends BaseTest {
    private static InnovationCenterPage innovationCenterPage;


    @BeforeMethod
    public void openPage() {
        innovationCenterPage = open(InnovationCenterPage.URL, InnovationCenterPage.class);
    }


    @Test()
    public void verifyDevelopmentsSection() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(innovationCenterPage.getProductsContainerSection().isDisplayed(), "Development section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getProductsContainerSection().$("h2").getText(), ("РАЗРАБОТКИ ИННОВАЦИОННОГО ЦЕНТРА"), "Title of Вevelopment section is wrong");
        softAssert.assertEquals(innovationCenterPage.getCountProductsItem(), (3), "Count of development item in the section is wrong");
        softAssert.assertTrue(innovationCenterPage.isVisibleEachDevelopmentItem(), "Development item in the section aren't visible");

        softAssert.assertAll();
    }
}
