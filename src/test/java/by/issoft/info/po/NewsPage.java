package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Calendar;

public class NewsPage extends CommonPage {
    public static final String URL = "/news";

    private static final By YEARS_LIST = By.cssSelector(".years-list li");
    private static final By MONTHS_LIST = By.cssSelector(".legend-months li");
    private static final By NEWS_LIST = By.cssSelector("ul.news-list>li");
    private static final By NEWS_HEADER = By.cssSelector("h2");
    private static final By NEWS_DESCRIPTION = By.cssSelector("h2");
    private static final By NEWS_DATE = By.cssSelector(".news-date");
    private static final By NEWS_IMAGE = By.cssSelector(".news-image");
    private static final By NEWS_LINK = By.cssSelector("a.block-link");
    private static final By NEXT_BUTTON = By.xpath("//ip-news-slider//button[2]");
    private static final By PREVIOS_BUTTON = By.xpath("//ip-news-slider//button[1]");
    private static final By ACTIVE_SLIDE = By.cssSelector("ip-news-slider div.home-page-event-slide.slide.slick-slide.slick-current.slick-active");
    private static final By EVENT_TITLE = By.cssSelector("div.event-title");


    public SelenideElement getActiveSlide() {
        return $(ACTIVE_SLIDE);
    }


    public String getTitleOfActiveSlide() {
        return $(ACTIVE_SLIDE).$(EVENT_TITLE).getText();
    }


    public SelenideElement getNextButton() {
        return $(NEXT_BUTTON);
    }


    public void clickNextButton() {
        $(NEXT_BUTTON).click();
    }


    public SelenideElement getPreviousButton() {
        return $(PREVIOS_BUTTON);
    }


    public void clickPreviousButton() {
        $(PREVIOS_BUTTON).click();
    }


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


    public boolean isVisibleHeadingsOfNews() {
        if (!isVisibleInformationOfEachNews(NEWS_HEADER, "string")) {
            return false;
        }
        return true;
    }


    public boolean isVisibleDescriptionsOfNews() {
        if (!isVisibleInformationOfEachNews(NEWS_DESCRIPTION, "string")) {

            return false;
        }
        return true;
    }


    public boolean isVisibleDatesOfNews() {
        if (!isVisibleInformationOfEachNews(NEWS_DATE, "string")) {
            return false;
        }
        return true;
    }


    public boolean isVisibleImagesOfNews() {
        if (!isVisibleInformationOfEachNews(NEWS_IMAGE, "image")) {
            return false;
        }
        return true;
    }


    public boolean isActiveLinksOfNews() {

        // WebDriver driver = getWebDriver();
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("document.body.style.zoom='80%'");

        if (!isVisibleInformationOfEachNews(NEWS_LINK, "link")) {
            return false;
        }
        return true;
    }


    public boolean isVisibleInformationOfEachNews(By element, String visibleElement) {
        ElementsCollection records = $$(NEWS_LIST);
        String text = "";
        String bannerText = "";
        String articleUrl;
        int i = 0;
        int k = records.size();
        LOGGER.info("Size of records = " + k);
        boolean findElement = true;
        NewsArticlePage articlePage = new NewsArticlePage();

        for (SelenideElement record : records) {
            i++;
            LOGGER.info("Number of record = " + i);
            switch (visibleElement) {
                case "string":
                    text = record.$(element).getText();
                    if (text.isEmpty()) {
                        findElement = false;
                    }
                    break;
                case "image":
                    if (!record.$(element).isDisplayed()) {
                        findElement = false;
                    }
                    ;
                    break;
                case "link":
                    if (i > 3) {
                        getBody().sendKeys(Keys.PAGE_DOWN);
                        sleep(2000);
                    }
                    record.$(element).click();
                    articleUrl = url().toString();
                    navigator.open(articleUrl);
                    LOGGER.info("After navigator articleUrl = " + articleUrl);
                    bannerText = articlePage.getBannerText().toLowerCase();
                    open(NewsPage.URL, NewsPage.class);
                    sleep(2000);
                    LOGGER.info("back on the news page ");
                    text = record.$(NEWS_HEADER).getText().toLowerCase();
                    LOGGER.info("text = " + i + " " + text);
                    if (!text.contentEquals(bannerText)) {
                        findElement = false;
                    }

                    ;
                    break;
            }
        }
        return findElement;
    }
}