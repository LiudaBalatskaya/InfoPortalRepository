package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.TeamPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP366TeamPageMenuTest extends BaseTest {

    private static TeamPage teamPage;


    @BeforeClass
    public void openPage() {
        teamPage = open(TeamPage.URL, TeamPage.class);
    }


    @Test
    public void verifyVisibleTeamLink() {
        Assert.assertTrue(teamPage.getTeamHeaderLink().isDisplayed(), "'Team' ('Команда') header link isn't displayed");
    }


    @Test
    public void verifyVisibleItemIssoftOperations() {
        Assert.assertTrue(teamPage.getItemIssoftOperations().isDisplayed(), "Menu item 'Issoft(Operations)' isn't displayed");
    }


    @Test
    public void verifyActiveItemIssoftOperations() {
        Assert.assertTrue(teamPage.isActiveItemIssoftOperations(), "Menu item 'Issoft(Operations)' isn't active");
    }


    @Test
    public void verifyVisibleItemIssoftAdmin() {
        Assert.assertTrue(teamPage.getItemIssoftAdmin().isDisplayed(), "Menu item 'Issoft(Admin)' isn't displayed");
    }


    @Test
    public void verifyVisibleItemCoherentSolutions() {
        Assert.assertTrue(teamPage.getItemCoherentSolutions().isDisplayed(), "Menu item 'Coherent Solutions' isn't displayed");
    }
}
