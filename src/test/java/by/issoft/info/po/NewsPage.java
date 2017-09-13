package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Calendar;

public class NewsPage extends CommonPage {
    public static final String URL = "/news";

    private static final By YEARS_LIST = By.cssSelector(".years-list li");
    private static final By MONTHS_LIST = By.cssSelector(".legend-months li");
    private static final By NEWS_LIST = By.cssSelector("ul.news-list li");
    private static final By NEWS_BANNER = By.cssSelector(".news-banner");
    private static final By BANNER_TEXT = By.cssSelector(".banner-text");


    public SelenideElement getYearsList() {
        return $(YEARS_LIST);
    }


    public SelenideElement getMonthsList() {
        return $(MONTHS_LIST);
    }


    public SelenideElement getNewsList() {
        return $(NEWS_LIST);
    }


    public int getQuantityOfYears() { return $$(YEARS_LIST).size(); }


    public int getQuantityOfMonths() { return $$(MONTHS_LIST).size(); }


    public boolean isAscendingOrder() {
        ElementsCollection records = $$(YEARS_LIST);
        int yearBefore = 0;
        int yearNext;
        for (SelenideElement record : records) {
            yearNext = Integer.parseInt(record.getText());
            if (yearNext <= yearBefore) {
                return false;
            }
        }
        return true;
    }


    public String getClassAttributeOfLastYear() {
        return $$(YEARS_LIST).get(getQuantityOfYears() - 1).attr("class");
    }


    public String getNamesOfMonthList() {
        StringBuilder names = new StringBuilder();
        ElementsCollection records = $$(MONTHS_LIST);
        for (SelenideElement record : records) {
            names.append(record.getText()).append(" ");
        }
        return names.toString();
    }


    public String getActiveNameOfMonthList() {
        String monthString;
        Calendar now = Calendar.getInstance();
        int year_now = now.get(Calendar.YEAR);
        int year = Integer.parseInt($$(YEARS_LIST).get($$(YEARS_LIST).size() - 1).getText());
        if (year_now > year) {
            monthString = "Октябрь-Декабрь";
        } else {
            int month = now.get(Calendar.MONTH);
            switch (month) {
                case 1:
                    monthString = "Январь-Март";
                    break;
                case 2:
                    monthString = "Январь-Март";
                    break;
                case 3:
                    monthString = "Январь-Март";
                    break;
                case 4:
                    monthString = "Апрель-Июнь";
                    break;
                case 5:
                    monthString = "Апрель-Июнь";
                    break;
                case 6:
                    monthString = "Апрель-Июнь";
                    break;
                case 7:
                    monthString = "Июль-Сентябрь";
                    break;
                case 8:
                    monthString = "Июль-Сентябрь";
                    break;
                case 9:
                    monthString = "Июль-Сентябрь";
                    break;
                case 10:
                    monthString = "Октябрь-Декабрь";
                    break;
                case 11:
                    monthString = "Октябрь-Декабрь";
                    break;
                case 12:
                    monthString = "Октябрь-Декабрь";
                    break;
                default:
                    monthString = "";
                    break;
            }
        }
        return monthString;
    }


    public boolean getHeadingOfEachNews() {
        By element = By.cssSelector("h2");
        if (!getInformationOfEachNews(element, 1)) {
            return false;
        }
        return true;
    }


    public boolean getDescriptionOfEachNews() {
        By element = By.cssSelector("p");
        if (!getInformationOfEachNews(element, 1)) {
            return false;
        }
        return true;
    }


    public boolean getDateOfEachNews() {
        By ELEMENT = By.cssSelector(".news-date");
        if (!getInformationOfEachNews(ELEMENT, 1)) {
            return false;
        }
        return true;
    }


    public boolean getImageOfEachNews() {
        By ELEMENT = By.cssSelector(".news-image");
        if (!getInformationOfEachNews(ELEMENT, 2)) {
            return false;
        }
        return true;
    }


    public boolean getLinkOfEachNews() {
        By element = By.cssSelector("a.block-link");
        if (!getInformationOfEachNews(element, 3)) {
            return false;
        }
        return true;
    }


    public boolean getInformationOfEachNews(By element, int flag) {
        ElementsCollection records = $$(NEWS_LIST);
        String text = "";
        String bannerText = "";
        By elementOfArticleHeaderText = By.cssSelector("h2");

        for (SelenideElement record : records) {

            switch (flag) {
                case 1:
                    text = record.$(element).getText();
                    if (text.isEmpty()) {
                        return false;
                    }
                    break;
                case 2:
                    if (!record.$(element).isDisplayed()) {
                        return false;
                    }
                    ;
                    break;
                case 3:
                    text = record.$(elementOfArticleHeaderText).getText().toLowerCase();
                    record.$(element).click();
                    navigator.open(url());
                    bannerText = $(BANNER_TEXT).getText().toLowerCase();
                    if (!text.contentEquals(bannerText)) {
                        return false;
                    }
                    open(NewsPage.URL, NewsPage.class);
                    ;
                    break;
            }
        }
        return true;
    }
/*
    public NewsArticlePage clickOnArticle(int number) {
        ElementsCollection records = $$(NEWS_LIST);
        records.get(number).

        return new NewsArticlePage();
    }

    public String getArticleNameText(int number) {
        ElementsCollection records = $$(NEWS_LIST);
        By elementOfArticleHeaderText = By.cssSelector("h2"); //TODO move up
        String text = records.get(number).$(elementOfArticleHeaderText).getText().toLowerCase();
    }
*/
}