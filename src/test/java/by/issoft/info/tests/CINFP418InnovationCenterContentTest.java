package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.InnovationCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP418InnovationCenterContentTest extends BaseTest {
    private static InnovationCenterPage innovationCenterPage;


    @BeforeMethod
    public void openPage() {
        innovationCenterPage = open(InnovationCenterPage.URL, InnovationCenterPage.class);
    }


    @Test()
    public void verifyContentPage() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(innovationCenterPage.getBracketedTitle(), "ИННОВАЦИОННЫЙ ЦЕНТР", " Bracketed title is wrong");
        softAssert.assertEquals(innovationCenterPage.getBoardHeader().$("h2").getText(), "НОВЫЕ ИДЕИ", "Board header  of innovation center page is wrong");
        softAssert.assertEquals(innovationCenterPage.getBoardHeader().$("a").getText(), "ПРЕДЛОЖИ СВОЮ ИДЕЮ", "Header button name is wrong");
        softAssert.assertTrue(innovationCenterPage.getBoardHeader().$("a").getAttribute("href").contains("mailto:innovationcenter@coherentsolutions.com?subject"),
                "Header button name is wrong");

        softAssert.assertTrue(innovationCenterPage.getActiveProjectsSection().isDisplayed(), "Active projects section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getActiveProjectsSection().$("h2").getText(), ("АКТИВНЫЕ ПРОЕКТЫ"), "Title of active projects section is wrong");
        softAssert.assertTrue(innovationCenterPage.getProductsContainerSection().isDisplayed(), "Products container section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getProductsContainerSection().$("h2").getText(), ("РАЗРАБОТКИ ИННОВАЦИОННОГО ЦЕНТРА"),
                "Title of Products container section is wrong");

        softAssert.assertTrue(innovationCenterPage.getOurTeamContainerSection().isDisplayed(), "Our team container section isn't displayed");
        softAssert.assertTrue(innovationCenterPage.getOurTeamContainerSection().$("h2").getText().contains("НАША КОМАНДА"),
                "Our team container title is wrong");

        softAssert.assertTrue(innovationCenterPage.getProposalSection().isDisplayed(), "Proposal container section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getProposalSection().$("h2").getText(), ("ХОЧЕШЬ ПРИНЯТЬ УЧАСТИЕ В РАБОТЕ ЦЕНТРА?"),
                "Proposal container title is wrong");
       // softAssert.assertTrue(innovationCenterPage.getProposalSection().$("img").exists(), "Proposal image section isn't displayed");

        softAssert.assertTrue(innovationCenterPage.getYammerSection().isDisplayed(), "Yammer container section isn't displayed");
        softAssert.assertTrue(innovationCenterPage.getYammerSection().$("h2").getText().contains("НАША ГРУППА"),
                "   Yammer title is wrong");

        softAssert.assertTrue(innovationCenterPage.getFeedback().isDisplayed(), "Feedback button isn't displayed");

        softAssert.assertAll();
    }
}
