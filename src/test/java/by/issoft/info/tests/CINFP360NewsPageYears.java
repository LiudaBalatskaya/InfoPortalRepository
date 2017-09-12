package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.NewsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP360NewsPageYears extends BaseTest {
    private static NewsPage newsPage;


    @BeforeClass
    public void openPage() {
        newsPage = open(NewsPage.URL, NewsPage.class);
    }


    @Test
    public void verifyVisibleYearsList() {
        Assert.assertTrue(newsPage.getYearsList().isDisplayed(), "Years list isn't display");
    }


    @Test()
    public void verifyQuantityOfYears() {
        Assert.assertTrue(newsPage.getQuantityOfYears() > 1, "Quantity of years on the list less or equal 1");
    }


    @Test()
    public void checkYearsListAscendingOrder() {
        Assert.assertTrue(newsPage.checkAscendingOrder(), "Year's list isn't ascending order");
    }


    @Test()
    public void verifyActiveYearOfList() {
        Assert.assertTrue(newsPage.checkAscendingOrder(), "Year's list isn't ascending order");
        Assert.assertEquals(newsPage.getAttributeOfLastYear(), "year active",
                "Last year of the list isn't active");
    }
}
