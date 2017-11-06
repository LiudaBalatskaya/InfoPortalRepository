package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class TrainingCenterPage extends CommonPage {

    public static final String URL = "/training-center";

    protected static final By ABOUT_CENTER_HEADER_LINK = By.xpath("//a[text()='О центре']");
    protected static final By SCHEDULE_HEADER_LINK = By.xpath("//a[text()='Расписание']");
    protected static final By TRAININGS_HEADER_LINK = By.xpath("//a[text()='Тренинги']");
    protected static final By TRAINERS_HEADER_LINK = By.xpath("//a[text()='Тренеры']");
    protected static final By NEAREST_TRAININGS_TITLE = By.xpath("h2");
    protected static final By SCHEDULE_BLOCK = By.xpath("//div[2]//li[1]/a//div");
    protected static final By SCHEDULE_BLOCK_LINK = By.cssSelector(".main-content .schedule-2016 a");
    protected static final By YAMMER_BLOCK = By.cssSelector(".tc-yammer.up");

    protected static final By WRITING_TRAINING_BLOCK = By.cssSelector(".tc-material.bottom");
    protected static final By WRITING_TRAINING_ALERT = By.cssSelector(".modal>h1");
    protected static final By CLOSE_WRITING_TRAINING_ALERT = By.cssSelector("ip-modal:nth-child(1) .close-icon");
    protected static final By TRAINING_LIST_BLOCK = By.cssSelector(".tc-list.bottom");
    protected static final By ABOUT_CENTER_BLOCK = By.cssSelector(".post-content");
    protected static final By ABOUT_CENTER_DESCRIPTION = By.cssSelector(".post-content .post-description");

    protected static final By TRAINERS_BLOCK = By.cssSelector(".col-one-second.trainers");
    protected static final By TRAINERS_LIST = By.cssSelector(".col-one-second.trainers li");
    protected static final By TRAINERS_NAMES_LIST = By.cssSelector("li .trainer-name");
    protected static final By TRAINERS_NAME_VISIBLE = By.cssSelector("li[ aria-hidden='false'] .trainer-name");
    protected static final By TRAINER_DESCRIPTION_VISIBLE = By.cssSelector("li[ aria-hidden='false'] .trainer-description");
    protected static final By TRAINER_PHOTO_VISIBLE = By.cssSelector("li[ aria-hidden='false'] .trainer-photo");
    protected static final By VISIBLE_TRAINER_LINK = By.cssSelector("li[ aria-hidden='false'] a");
    protected static final By SHORT_INFO_TRAINER_NAME = By.cssSelector(".short-info>h1");


    protected static final By NEWS_BLOCK = By.cssSelector(".side-news-block-wrapper");
    protected static final By BLOCK_TITLE = By.cssSelector(".block-title");
    protected static final By ALL_NEWS_LINK = By.cssSelector(".all-news-link");
    protected static final By MONTHS = By.cssSelector(".month-label");
    protected static final By NEWS_ITEMS = By.cssSelector(".news-item");
    protected static final By NEWS_ITEMS_LINKS = By.cssSelector(".news-item a");
    protected static final By NEWS_DESCRIPTIONS = By.cssSelector(".news-content");
    protected static final By NEWS_NUMBERS = By.cssSelector(".rule-number");


    public SelenideElement getNewsBlock() {
        return $(NEWS_BLOCK);
    }


    public String getNewsTitle() {
        return $(BLOCK_TITLE).getText();
    }


    public int getNewsItemsSize() {
        ElementsCollection records = $$(NEWS_ITEMS);
        return records.size();
    }


    public SelenideElement getAllNewsLink() {
        return $(ALL_NEWS_LINK);
    }

    public boolean isActiveAllNewsLink() {
        getAllNewsLink().click();
        sleep(2000);
        if (!$(NAVIGATION_LINK_ACTIVE).getText().contains("НОВОСТИ")) {
            return false;
        }
        return true;
    }



    public boolean isVisibleMonthsOfNews() {
        if (!isVisibleMonthOfEachNews()) {
            return false;
        }
        return true;
    }


    public boolean isVisibleDescriptionsOfNews() {
        if (!isVisibleDescriptionOfEachNews()) {
            return false;
        }
        return true;
    }


    public boolean isVisibleNumbersOfNews() {
        if (!isVisibleNumberOfEachNews()) {
            return false;
        }
        return true;
    }

    public boolean isActiveLinksOfNews() {
        if (!isActiveLinkOfEachNews()) {
            return false;
        }
        return true;
    }

    public boolean isActiveLinkOfEachNews() {
        ElementsCollection records = $$(NEWS_ITEMS_LINKS);
        NewsArticlePage newsPage = new NewsArticlePage();
        String newsTitle, bannerTitle;
        int size = records.size();
        int i=0;
        for (SelenideElement record : records) {
            i++;
            if(i<size-1) {
                newsTitle = record.getText();
                record.click();
                sleep(2000);
                bannerTitle = newsPage.getBannerText();
                if (!newsTitle.contains(bannerTitle)) {
                    return false;
                } else {
                    navigator.back();
                    sleep(2000);
                }
            }
           }
        return true;
    }

    public boolean isVisibleLinksOfNews() {
        if (!isVisibleLinkOfEachNews()) {
            return false;
        }
        return true;
    }

    public boolean isVisibleLinkOfEachNews() {
        ElementsCollection records = $$(NEWS_ITEMS);
        for (SelenideElement record : records) {
            if (!record.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isVisibleNumberOfEachNews() {
        ElementsCollection records = $$(NEWS_NUMBERS);

        for (SelenideElement record : records) {
            if (Integer.parseInt(record.getText()) <= 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isVisibleMonthOfEachNews() {
        ElementsCollection records = $$(MONTHS);
        String month;
        for (SelenideElement record : records) {
            month = record.getText();
            if (!isMonthFound(month)) {
                return false;
            }
            ;
        }
        return true;
    }


    public boolean isVisibleDescriptionOfEachNews() {
        ElementsCollection records = $$(NEWS_DESCRIPTIONS);
        String text;
        for (SelenideElement record : records) {
            text = record.getText();
            if (text.length() < 10) {
                return false;
            }
        }
        return true;
    }


    public SelenideElement getAboutCenterHeaderLink() {
        return $(ABOUT_CENTER_HEADER_LINK);
    }


    public SelenideElement getScheduleHeaderLink() {
        return $(SCHEDULE_HEADER_LINK);
    }


    public SelenideElement getTrainingsHeaderLink() { return $(TRAININGS_HEADER_LINK); }


    public SelenideElement getNearestTrainingTitle() { return $(NEAREST_TRAININGS_TITLE); }


    public SelenideElement getTrainersHeaderLink() {
        return $(TRAINERS_HEADER_LINK);
    }


    public SelenideElement getScheduleBlock() { return $(SCHEDULE_BLOCK); }


    public SelenideElement getScheduleBlockImage() { return $(SCHEDULE_BLOCK).$("img"); }


    public SelenideElement getScheduleBlockTitle() { return $(SCHEDULE_BLOCK).$("h2"); }


    public SelenideElement getScheduleBlockLink() { return $(SCHEDULE_BLOCK_LINK); }


    public boolean isActiveScheduleBlockLink() {
        return getScheduleBlockLink().getAttribute("href").equalsIgnoreCase("null");
    }


    public SelenideElement getYammerBlock() { return $(YAMMER_BLOCK); }


    public SelenideElement getYammerBlockTitle() { return $(YAMMER_BLOCK).$("h2"); }


    public SelenideElement getYammerBlockLink() { return $(YAMMER_BLOCK).$("a"); }


    public boolean isActiveYammerBlockLink() {
        String href = getYammerBlockLink().getAttribute("href");
        return href.contains("https://www.yammer.com/coherentsolutions.com/");
    }


    public SelenideElement getWritingTrainingBlock() { return $(WRITING_TRAINING_BLOCK); }


    public SelenideElement getWritingTrainingBlockTitle() { return $(WRITING_TRAINING_BLOCK).$("h2"); }


    public SelenideElement getWritingTrainingBlockLink() { return $(WRITING_TRAINING_BLOCK).$("a"); }


    public SelenideElement getWritingTrainingBlockImage() { return $(WRITING_TRAINING_BLOCK).$("img"); }


    public String isActiveWritingTrainingBlockLink() {
        getWritingTrainingBlockLink().click();
        String title = $(WRITING_TRAINING_ALERT).getText();
        $(CLOSE_WRITING_TRAINING_ALERT).click();
        return title;
    }


    public SelenideElement getTrainingListBlock() { return $(TRAINING_LIST_BLOCK); }


    public boolean isActiveTrainingListBlockLink() {
        String href = getTrainingListBlock().$("a").getAttribute("href");
        return href.contains("/trainings");
    }


    public SelenideElement getAboutCenterBlock() {
        return $(ABOUT_CENTER_BLOCK);
    }


    public SelenideElement getAboutCenterBlockTitle() {
        return $(ABOUT_CENTER_BLOCK).$("h2");
    }


    public boolean isAboutCenterDescriptionVisible() {
        String description = $(ABOUT_CENTER_DESCRIPTION).getText();
        String status = getAboutCenterBlock().$(".post-status").getText();
        return description.contains("Тренинг-центр — подразделение компании ISsoft") & status.contains("Руководитель центра");
    }


    public boolean isAboutCenterLeaderVisible() {
        String leader = getAboutCenterBlock().$("a").getText();
        return leader.contains("Олег Фридлянд");
    }


    public boolean isActiveAboutCenterLinkActive() {
        String leader = getAboutCenterBlock().$("a").getAttribute("href");
        return leader.contains("https://rmsys.issoft.by/Individual");
    }


    public SelenideElement getTrainersListBlock() { return $(TRAINERS_BLOCK); }


    public boolean isVisibleTrainersNamesList() {
        boolean correctly = false;
        String name;
        correctly = getTrainersListBlock().$("a>h2").getText().contains("ТРЕНЕРЫ ЦЕНТРА");
        if (correctly) {
            ElementsCollection records = $$(TRAINERS_NAMES_LIST);
            int size = records.size();

            for (int j = 0; j < size; j++) {
                sleep(3000);
                name = $(TRAINERS_NAME_VISIBLE).getText();
                if (correctly) {
                    correctly = false;
                    for (int i = 0; i < TRAINERS.length; i++) {
                        if (TRAINERS[i].contentEquals(name)) {
                            correctly = true;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return correctly;
    }


    public boolean isVisibleTrainersDescriptions() {
        boolean correctly = false;
        String description;

        ElementsCollection records = $$(TRAINERS_NAMES_LIST);
        int size = records.size();

        for (int j = 0; j < size; j++) {
            sleep(3000);
            correctly = $(TRAINER_DESCRIPTION_VISIBLE).isDisplayed();
            description = $(TRAINER_DESCRIPTION_VISIBLE).getText();
            if (correctly) {
                if (description.length() < 10) {
                    correctly = false;
                    break;
                }
            }
        }
        return correctly;
    }


    public boolean isVisibleTrainersPhotos() {
        boolean correctly = false;
        String description;

        ElementsCollection records = $$(TRAINERS_NAMES_LIST);
        int size = records.size();

        for (int j = 0; j < size; j++) {
            sleep(3000);
            correctly = $(TRAINER_PHOTO_VISIBLE).isDisplayed();
            if (!correctly) {
                break;
            }
        }
        return correctly;
    }


    public boolean isActiveTrainersLinks() {
        boolean correctly = false;
        String name, shortInfoName;

        ElementsCollection records = $$(TRAINERS_NAMES_LIST);
        int size = records.size();

        for (int j = 0; j < size; j++) {
            sleep(3000);
            name = $(TRAINERS_NAME_VISIBLE).getText();
            $(TRAINERS_NAME_VISIBLE).click();
            sleep(1000);
            shortInfoName = $(SHORT_INFO_TRAINER_NAME).getText();
            correctly = name.equalsIgnoreCase(shortInfoName);
            $(".close-icon").click();
            navigator.back();
            if (!correctly) {
                break;
            }
        }

        return correctly;
    }
}
