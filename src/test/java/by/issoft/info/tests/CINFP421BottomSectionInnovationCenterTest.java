package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.InnovationCenterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP421BottomSectionInnovationCenterTest extends BaseTest {
    private static InnovationCenterPage innovationCenterPage;


    @BeforeMethod
    public void openPage() {
        innovationCenterPage = open(InnovationCenterPage.URL, InnovationCenterPage.class);
    }


    @Test()
    public void verifyActiveBottomSections() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(innovationCenterPage.getOurTeamContainerSection().isDisplayed(), "Our team section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getOurTeamContainerSection().$("h2").getText(), ("НАША КОМАНДА →"), "Title of Our team section is wrong");
        softAssert.assertEquals(innovationCenterPage.getOurTeamContainerSection().getAttribute("href"), ("http://info-portal.dev.coherentprojects.net/team"), "Link of our team section is wrong");

        softAssert.assertTrue(innovationCenterPage.getProposalSection().isDisplayed(), "Proposal section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getProposalSection().$("h2").getText(), ("ХОЧЕШЬ ПРИНЯТЬ УЧАСТИЕ В РАБОТЕ ЦЕНТРА?"),
                "Title of proposal section is wrong");
        softAssert.assertTrue(innovationCenterPage.getProposalSection().$("img").isDisplayed(), "Proposal section icon isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getProposalSection().$("p").getText(), ("Пиши на innovationcenter@coherentsolutions.com"),
                "Proposal mail of proposal section is wrong");
        softAssert.assertEquals(innovationCenterPage.getProposalSection().$("a").getAttribute("href"), ("mailto:innovationcenter@coherentsolutions.com"),
                "Link of mail of proposal section is wrong");

        softAssert.assertTrue(innovationCenterPage.getYammerSection().isDisplayed(), "Yammer section isn't displayed");
        softAssert.assertEquals(innovationCenterPage.getYammerSection().$("h2").getText(), ("НАША ГРУППА\nВ ЯММЕРЕ"),
                "Title of Yammer section is wrong");


        softAssert.assertTrue(innovationCenterPage.getYammerLinkBlock().getAttribute("href").contains("https://www.yammer.com/coherentsolutions.com"),
                "Link of yammer section is wrong");

        softAssert.assertAll();
    }
}
