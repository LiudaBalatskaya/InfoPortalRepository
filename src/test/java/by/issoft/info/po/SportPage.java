package by.issoft.info.po;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SportPage extends CommonPage {
    public static final String URL = "/sport";

    private static final By NEWS_HEADER = By.cssSelector("h2.news-title");
    private static final By BLOCK_NEWS = By.cssSelector(".block-title");
    private static final By NEWS_ITEM = By.cssSelector(".news-item");
    private static final By MONTH_LABEL = By.cssSelector(".month-label");
    private static final By RULE_NUMBERS = By.cssSelector(".rule-number");
    private static final By NEWS_LINK = By.cssSelector("a.news-title");
    private static final By ALL_NEWS = By.cssSelector(".all-news-link>a");
    private static final By NEWS_CONTENT = By.cssSelector(".news-content");
    private static final By NEWS_LIST = By.xpath("//ip-newslist//a");
    private static final By SECTIONS_NAMES = By.cssSelector(".activity-title");
    private static final By SECTIONS_CONTENT = By.cssSelector(".content-section");
    private static final By IMAGE_CONTENT = By.cssSelector(".image-section img");
    private static final By SCHEDULE_HOURS = By.cssSelector(".weight-text.schedule-time");
    private static final By SCHEDULE_DAYS = By.cssSelector(".schedule-days");
    private static final By ADDRESS = By.cssSelector("p:nth-of-type(2) span:nth-child(2)");
    private static final By MAP = By.cssSelector(".map-link");
    private static final By TRAINERS = By.cssSelector(".trainers-list");
    private static final By SKYPE_CONTACT1 = By.cssSelector("li:nth-of-type(1) a.skype-contact");
    private static final By SKYPE_CONTACT2 = By.cssSelector("li:nth-of-type(2) a.skype-contact");
    private static final By SKYPE_LINK1 = By.cssSelector("li:nth-of-type(1) a.skype-contact");
    private static final By SKYPE_LINK2 = By.cssSelector("li:nth-of-type(2) a.skype-contact");
    private static final By TRAINER_NAME = By.cssSelector("a.weight-text");
    private static final By PRICE = By.cssSelector(".price");
    private static final By POOL_COST = By.xpath("//div[4]//p[3]");
    private static final By SWIMMING_POOL_PRICE = By.cssSelector(".swimming-pool-price>p");
    private static final By SWIMMING_POOL_PRICES = By.cssSelector(".swimming-pool-price>ul");
    private static final By POOL_INFO = By.cssSelector(".additional-info");
    private static final By POOL_BUTTON = By.cssSelector(".show-additional-info-button");
    private static final By PRICES_LIST = By.cssSelector(".swimming-pool-price>ul>li");
    private static final By POOL_TRAINER_DESCRIPTION = By.cssSelector(".trainer-description-section>p");
    private static final By POOL_COACH = By.xpath("//div[4]//div[2]/div[2]/ul/li");
    private static final By POOL_COACH_LINK = By.xpath("//div[4]//div[2]/div[2]/ul/li//a[2]");
    private static final By POOL_MANAGER = By.xpath("//div[4]/div[2]/ul/li");
    private static final By POOL_MANAGER_LINK = By.xpath("//div[4]/div[2]/ul/li//a[2]");
    private static final By POOL_MANAGER_NAME = By.xpath("//div[4]/div[2]/ul/li//a[1]");

    public String getNewsHeader() { return $(NEWS_HEADER).getText(); }


    public SelenideElement getNewsBlock() { return $(BLOCK_NEWS); }


    public SelenideElement getAllNews() { return $(ALL_NEWS); }


    public int getCountNewsItem() {
        sleep(2000);
        ElementsCollection records = $$(NEWS_ITEM);
        return records.size();
    }


    public boolean isMonthNewsItems() {
        String month;
        ElementsCollection records = $$(NEWS_ITEM);

        for (SelenideElement record : records) {
            month = record.$(MONTH_LABEL).getText();
            if(!isMonthFound(month)){ break;};
        }
        return true;
    }


    public boolean isRuleNumbersOfNews() {

        boolean correctly = false;
        int j = 0;
        ElementsCollection records = $$(RULE_NUMBERS);

        for (SelenideElement record : records) {
            if (Integer.parseInt(record.getText()) > 0) {
                correctly = true;
            } else {
                correctly = false;
                break;
            }
        }
        return correctly;
    }


    public boolean isBriefTitleOfNews() {

        boolean correctly = false;
        int j = 0;
        ElementsCollection records = $$(NEWS_LINK);

        for (SelenideElement record : records) {
            if (record.getText().length() > 3) {
                correctly = true;
            } else {
                correctly = false;
                break;
            }
        }
        return correctly;
    }


    public boolean isActiveNewsSportLinks() {
        boolean correct = false;
        int j = 0;
        String titleNews, bannerText, articleUrl;
        sleep(2000);
        ElementsCollection records = $$(NEWS_LIST);
        int size = records.size();
        LOGGER.info("Size of records = " + size);
        for (SelenideElement record : records) {
            j++;
            if (record.isDisplayed()) {
                if (j < size - 2) {
                    titleNews = record.getText().toUpperCase();
                    LOGGER.info("title of news " + j + " =" + titleNews);
                    record.click();
                    articleUrl = url().toString();
                    LOGGER.info("After navigator articleUrl = " + articleUrl);
                    sleep(2000);
                    NewsArticlePage articlePage = new NewsArticlePage();
                    bannerText = articlePage.getBannerText().toUpperCase();
                    navigator.back();
                    sleep(2000);
                    LOGGER.info("back on the sport page ");
                    if (titleNews.contentEquals(bannerText)) {
                        correct = true;
                    } else {
                        correct = false;
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return correct;
    }


    public boolean isActiveAllNewsLink() {
        sleep(2000);
        getAllNews().click();
        return getNavigationActiveLink().isDisplayed();
    }


    public boolean isSectionNamesDisplayed() {
        String[] sectionNames = new String[]{ "ВОЛЕЙБОЛ",
                "БАСКЕТБОЛ",
                "ФУТБОЛ",
                "БАССЕЙН",
                "ХОККЕЙ",
                "ЛАЗЕРТАГ",
                "КАРТИНГ"
        };

        String name;
        boolean correctName = false;
        int j = 0;
        ElementsCollection records = $$(SECTIONS_NAMES);

        for (SelenideElement record : records) {
            correctName = false;
            name = record.getText();
            for (int i = 0; i < sectionNames.length; i++) {
                if (sectionNames[i].contentEquals(name)) {
                    correctName = record.isDisplayed();
                    break;
                }
            }
            if (!correctName) {
                break;
            }
        }
        return correctName;
    }


    public boolean isSectionImageDisplayed() {
        String[] sectionName = new String[]{ "volleyball",
                "basketball",
                "football",
                "pool",
                "hockey",
                "lasertag",
                "carting"
        };

        String valueAttribute;
        boolean correctName = false;
        int j = 0;
        ElementsCollection records = $$(IMAGE_CONTENT);

        for (SelenideElement record : records) {
            correctName = false;
            valueAttribute = record.attr("src");
            for (int i = 0; i < sectionName.length; i++) {
                if (valueAttribute.contains(sectionName[i])) {
                    correctName = record.isDisplayed();
                    break;
                }
            }
            if (!correctName) {
                break;
            }
        }
        return correctName;
    }


    public boolean isEachSportSectionWorkersHoursDisplayed() {

        boolean correct = false;
        ElementsCollection records = $$(SECTIONS_CONTENT);
        int size = records.size();
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (i < size - 1) {
                correct = record.$(SCHEDULE_HOURS).isDisplayed();
                if (!correct) {
                    break;
                }
            }
        }
        return correct;
    }


    public boolean isEachSportSectionScheduleDaysDisplayed() {

        boolean correct = false;
        ElementsCollection records = $$(SECTIONS_CONTENT);
        int size = records.size();
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (i < size - 1) {
                correct = record.$(SCHEDULE_DAYS).isDisplayed();
                if (!correct) {
                    break;
                }
            }
        }
        return correct;
    }


    public boolean isEachSportSectionAddressDisplayed() {
        boolean correct = false;
        ElementsCollection records = $$(SECTIONS_CONTENT);
        int size = records.size();
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (i < size - 1) {
                correct = false;
                correct = record.$(byText("Адрес:")).isDisplayed();
                if (correct) {
                    correct = record.$(ADDRESS).isDisplayed();
                }
                if (!correct) {
                    break;
                }
            }
        }
        return correct;
    }


    public boolean isEachSportSectionMapDisplayed() {
        boolean correct = false;
        int i = 0;
        ElementsCollection records = $$(SECTIONS_CONTENT);
        int size = records.size();
        for (SelenideElement record : records) {
            i++;
            if (i < size - 1) {
                correct = false;
                if (record.$(MAP).isDisplayed()) {
                    correct = record.$(MAP).getText().contains("Карта");
                    if (correct) {
                        //  record.$(MAP).click();  - there is bug in application
                    }
                }
                if (!correct) {
                    break;
                }
            }
        }
        return correct;
    }


    public boolean isEachSportSectionCostDisplayed() {
        boolean correct = false;
        ElementsCollection records = $$(SECTIONS_CONTENT);
        int size = records.size();
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (i != 4) {
                correct = record.$(PRICE).isDisplayed();
                if (!correct) {
                    break;
                }
            }
        }
        return correct;
    }


    public SelenideElement getSectionSkypeImg(int i) {
        String[] pictureName = new String[]{ "[alt='volleyball']",
                "[alt='basketball']",
                "[alt='football']",
                "[alt='pool']",
                "[alt='hockey']",
                "[alt='lasertag']",
                "[alt='carting']"
        };
        String element = "img" + pictureName[i];
        return $(element);
    }


    public SelenideElement getSectionTrainersName(SelenideElement record) {
        return record.$(TRAINERS).$(TRAINER_NAME);
    }


    public SelenideElement getSectionSkypeContact1(SelenideElement record) {
        return record.$(SKYPE_CONTACT1);
    }


    public SelenideElement getSectionSkypeContact2(SelenideElement record) {
        return record.$(SKYPE_CONTACT2);
    }


    public boolean isEachSkypeDateDisplayed() {
        boolean correct = false;
        ElementsCollection records = $$(SECTIONS_CONTENT);
        int size = records.size();
        int i = 0;
        correct = $(byText("Skype чат")).isDisplayed();
        if (correct) {
            for (SelenideElement record : records) {
                i++;
                correct = getSectionSkypeImg(i - 1).isDisplayed();
                if (correct) {
                    SelenideElement element = getSectionSkypeContact1(record);
                    if (i != 4) {
                        correct = getSectionSkypeContact1(record).isDisplayed();
                        if (correct) {
                            correct = getSectionTrainersName(record).isDisplayed();
                        }
                    }
                }
                if (!correct) {
                    break;
                }
            }
        }
        return correct;
    }


    public boolean isActiveSkypeLinks() {
        boolean correct = false;
        ElementsCollection records = $$(SECTIONS_CONTENT);
        int size = records.size();
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            String attr = record.$(SKYPE_LINK1).getAttribute("href");
            correct = attr.contains("skype:csi.");
            if (correct) {
                if ((i == 3) | (i == 5)) {
                    attr = record.$(SKYPE_LINK2).getAttribute("href");
                    correct = attr.contains("skype:csi.");
                }
            }
            if (!correct) {
                break;
            }
        }
        return correct;
    }


    public boolean isTitlePaidCompanyCostDisplayed() {
        boolean correct = $(byText("Бассейн")).isDisplayed();
        String costTitle;
        if (correct) {
            costTitle = $(POOL_COST).getText();
            correct = costTitle.contains("Стоимость: Оплачивает компания");
        }
        return correct;
    }


    public boolean isNotVisiblePoolCosts() {
        boolean correct = true;
        correct = $(SWIMMING_POOL_PRICE).isDisplayed();
        if (!correct) {
            correct = $(SWIMMING_POOL_PRICES).isDisplayed();
            if (!correct) {
                correct = $(POOL_INFO).isDisplayed();
            }
        }
        return correct;
    }


    public boolean isVisiblePoolCosts() {
        boolean correct = false;
        int i = 0;
        String priceTitle;
        getBody().sendKeys(Keys.PAGE_DOWN);
        $(POOL_BUTTON).click();
        sleep(2000);
        correct = $(SWIMMING_POOL_PRICE).isDisplayed();
        if (correct) {
            correct = $(SWIMMING_POOL_PRICES).isDisplayed();
            if (correct) {
                correct = $(POOL_INFO).isDisplayed();
            }
        }
        ElementsCollection records = $$(PRICES_LIST);
        for (SelenideElement record : records) {
            i++;
            priceTitle = record.getText();
            if (correct) {
                switch (i) {
                    case 1:
                        correct = priceTitle.contains("Цена со скидкой:");
                        break;
                    case 2:
                        correct = priceTitle.contains("Индивидуальные занятия - 25 руб.");
                        break;
                    case 3:
                        correct = priceTitle.contains("Группа 2 человека - 18 руб.");
                        break;
                    case 4:
                        correct = priceTitle.contains("Группа 3-4 человека - 14 руб.");
                        break;
                    default:
                        ;
                        break;
                }
            } else {
                break;
            }
        }
        return correct;
    }


    public boolean isVisibleCoachInformation() {
        String name, link;
        boolean correct = $(byText("Бассейн")).isDisplayed();
        if (correct) {
            getBody().sendKeys(Keys.PAGE_DOWN);
            $(POOL_BUTTON).click();
            sleep(2000);
            correct = $(POOL_TRAINER_DESCRIPTION).isDisplayed();
            if (correct) {
                correct = $(POOL_COACH).$("img").isDisplayed();
                if (correct) {
                    name = $(POOL_COACH).$("a").getText();
                    correct = name.contains("Анатолий Андров");
                    if (correct) {
                        link = $(POOL_COACH_LINK).getAttribute("href");
                        correct = link.contains("skype:csi.anatolyandrov?add");
                    }
                }
            }
        }

        return correct;
    }

    public boolean isVisiblePollManagerInformation() {
        String name, link;
        boolean correct = $(byText("Бассейн")).isDisplayed();
        if (correct) {
            getBody().sendKeys(Keys.PAGE_DOWN);
            $(POOL_BUTTON).click();
            sleep(2000);
            correct = $(POOL_TRAINER_DESCRIPTION).isDisplayed();
            if (correct) {
                correct = $(POOL_MANAGER).$("img").isDisplayed();
                if (correct) {
                    name = $(POOL_MANAGER_NAME).getText();
                    correct = name.contains("Андрей Никонов");
                    if (correct) {
                        link = $(POOL_MANAGER_LINK).getAttribute("href");
                        correct = link.contains("skype:csi.andreynikonov?add");
                    }
                }
            }
        }

        return correct;
    }
}



