package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.NewsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP361MonthsListTest extends BaseTest {
    private static NewsPage newsPage;


    @BeforeClass
    public void openPage() {
        newsPage = open(NewsPage.URL, NewsPage.class);
    }


    @Test
    public void verifyVisibleMonthsList() {
        Assert.assertTrue(newsPage.getMonthsList().isDisplayed(), "Months list isn't display");
    }


    @Test()
    public void verifyQuantityOfMonths() {
        Assert.assertTrue(newsPage.getQuantityOfMonths() == 4, "Quantity of months on the list isn't equal 4");
    }


    @Test()
    public void verifyVisibleNamesOfMonthsList() {
        String names = newsPage.getNamesOfMonthList();
        Assert.assertTrue(names.contentEquals("Январь-Март Апрель-Июнь Июль-Сентябрь Октябрь-Декабрь "), "Names of months on the list are wrong");
    }
}
