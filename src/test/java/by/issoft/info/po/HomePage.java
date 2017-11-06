package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends CommonPage {
    public static final String URL = "/";

    private static final By SPORT_SLIDE = By.cssSelector(".home-page-event-slide.slick-active");

    private static final By START_DAYS_NUMBER = By.cssSelector(".start-month-number");
    private static final By START_MONTH_NAME = By.cssSelector(".start-month-name");
    private static final By START_TIME = By.cssSelector(".start-time-number");
    private static final By START_TIME_TEXT = By.cssSelector(".start-time-text");
    private static final By EVENT_TYPE = By.cssSelector(".event-type");
    private static final By EVENT_TITLE = By.cssSelector(".event-title");
    private static final By EVENT_SLIDE_IMAGE = By.cssSelector(".event-slide-image");
    private static final By BUTTON_NEXT = By.cssSelector(".slick-next");
    private static final By BUTTON_PREVIOUS = By.cssSelector(".slick-prev");

    private static final By GALLERY = By.cssSelector(".gallery-inner-wrapper");
    private static final By GALLERY_LINK = By.cssSelector(".gallery");

    private static final By TRAINING = By.cssSelector(".training");
    private static final By HR_BLOCK = By.cssSelector(".hr-bonuses");
    private static final By INNOVATION = By.cssSelector(".innovation-centre");
    private static final By INNOVATION_LINK = By.xpath("//a[@href='/innovation-center']");

    private static final By NEWS_BLOCK = By.cssSelector(".side-news-block-wrapper");
    private static final By MONTH_NEWS_BLOCK = By.cssSelector(".side-news-block-wrapper .news-item .month-label");
    private static final By NEWS_ITEMS = By.cssSelector(".side-news-block-wrapper .news-item");
    private static final By ALL_NEWS = By.cssSelector(".all-news-link");

    private static final By RULES = By.cssSelector(".rules.hover-effect");
    private static final By RULES_LINK = By.cssSelector(".col-1:first-of-type a");
    private static final By SOCIAL_PACKAGE = By.cssSelector(".benefits.hover-effect");
    private static final By SOCIAL_PACKAGE_LINK = By.cssSelector(".col-1:nth-of-type(2) a");
    private static final By INFO_SECURITY = By.cssSelector(".team.hover-effect");
    private static final By INFO_SECURITY_LINK = By.cssSelector(".col-1:nth-of-type(3) a");
    private static final By SPORT = By.cssSelector(".sports-wrapper");
    private static final By SPORT_LINK = By.cssSelector(".col-1:nth-of-type(4) a");
    private static final By BONUSES = By.cssSelector(".bonuses-wrapper");
    private static final By BONUSES_LINK = By.cssSelector(".col-1:nth-of-type(5) a");

    private static final By FOOT_ISSOFT = By.cssSelector(".footer>span:first-of-type");
    private static final By FOOT_ISSOFT_BY = By.cssSelector(".footer>span:nth-of-type(3)");
    private static final By FOOT_COHERENT = By.cssSelector(".footer>span:nth-of-type(5)");
    private static final By FOOT_RMSYS = By.cssSelector(".footer>span:nth-of-type(7)");
    private static final By FOOT_INTACCT = By.cssSelector(".footer>span:nth-of-type(9)");
    private static final By FOOT_LUNCH_VOTING = By.cssSelector(".footer>span:nth-of-type(11)");
    private static final By FOOT_DOCUMENTS = By.cssSelector(".footer>span:nth-of-type(13)");
    private static final By SOCIAL_ICONS = By.cssSelector(".social-icons a");


    public boolean isVisibleActiveSocialIcons() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        ElementsCollection records = $$(SOCIAL_ICONS);
        int size = records.size();
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (record.isDisplayed()) {
                if (!record.$("img").isDisplayed()) {
                    return false;
                }
                switch (i) {
                    case 1:
                        if (!record.$("img").getAttribute("src").contains("assets/footer/facebook.svg")) {
                            return false;
                        }
                        break;
                    case 2:
                        if (!record.$("img").getAttribute("src").contains("assets/footer/g+.svg")) {
                            return false;
                        }
                        break;
                    case 3:
                        if (!record.$("img").getAttribute("src").contains("assets/footer/linkedin.svg")) {
                            return false;
                        }
                        break;
                    case 4:
                        if (!record.$("img").getAttribute("src").contains("assets/footer/twitter.svg")) {
                            return false;
                        }
                        break;
                    case 5:
                        if (!record.$("img").getAttribute("src").contains("assets/footer/vk.svg")) {
                            return false;
                        }
                        break;
                    default:
                        ;
                        break;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public SelenideElement getFootDocuments() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(FOOT_DOCUMENTS);
    }


    public SelenideElement getFootLunchVoiting() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(FOOT_LUNCH_VOTING);
    }


    public SelenideElement getFootIntacct() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(FOOT_INTACCT);
    }


    public SelenideElement getFootRMSYS() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(FOOT_RMSYS);
    }


    public SelenideElement getFootCoherent() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(FOOT_COHERENT);
    }


    public SelenideElement getFootIssoftBy() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(FOOT_ISSOFT_BY);
    }


    public SelenideElement getFootIssoft() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(FOOT_ISSOFT);
    }


    public SelenideElement getBonusesLink() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(BONUSES_LINK);
    }


    public SelenideElement getSportLink() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(SPORT_LINK);
    }


    public SelenideElement getInfoSecurityLink() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(INFO_SECURITY_LINK);
    }


    public SelenideElement getSocialPackageLink() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(SOCIAL_PACKAGE_LINK);
    }


    public SelenideElement getRulesLink() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(RULES_LINK);
    }


    public SelenideElement getBonusesBlock() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(BONUSES);
    }


    public SelenideElement getSportBlock() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(SPORT);
    }


    public SelenideElement getInfoSecurity() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(INFO_SECURITY);
    }


    public SelenideElement getSocialPackage() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(SOCIAL_PACKAGE);
    }


    public SelenideElement getRules() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(RULES);
    }


    public SelenideElement getAllNewsLink() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(ALL_NEWS);
    }


    public boolean isVisibleNumbersNewsItems() {
        boolean correct = false;
        ElementsCollection records = $$(NEWS_ITEMS);
        int size = records.size();
        int i = 0;
        ElementsCollection numbers;
        for (SelenideElement record : records) {
            i++;
            if (i < 3) {
                correct = record.isDisplayed();
                if (correct) {
                    numbers = record.$$(".rule-number");
                    for (SelenideElement number : numbers) {
                        correct = number.isDisplayed();
                        if (!correct) {
                            break;
                        }
                    }
                }
                if (!correct) {
                    return false;
                }
            } else {
                break;
            }
        }
        return correct;
    }


    public boolean isVisibleNewsItemTitles() {
        boolean correct = false;
        ElementsCollection records = $$(NEWS_ITEMS);
        ElementsCollection titles;
        int size = records.size();
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (i < 3) {
                correct = record.isDisplayed();
                if (correct) {
                    titles = record.$$("news-title");
                    for (SelenideElement title : titles) {
                        correct = title.isDisplayed();
                        if (!correct) {
                            break;
                        }
                    }
                }
                if (!correct) {
                    return false;
                }
            } else {
                break;
            }
        }
        return correct;
    }


    public boolean isVisibleCorrectMonthNews() {
        boolean correct = false;
        String month;
        ElementsCollection records = $$(MONTH_NEWS_BLOCK);
        int size = records.size();
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (i < 3) {
                correct = record.isDisplayed();
                if (correct) {
                    month = record.getText();
                    correct = isMonthFound(month);
                }
                if (!correct) {
                    return false;
                }
            }
        }
        return correct;
    }


    public SelenideElement getNewsBlock() {
        return $(NEWS_BLOCK);
    }


    public SelenideElement getInnovationBlock() {
        return $(INNOVATION);
    }


    public SelenideElement getInnovationLink() {
        return $(INNOVATION_LINK);
    }


    public SelenideElement getHRBlock() {
        return $(HR_BLOCK);
    }


    public SelenideElement getTraining() {
        return $(TRAINING);
    }


    public SelenideElement getGalleryLink() {
        return $(GALLERY_LINK);
    }


    public SelenideElement getGallery() {
        return $(GALLERY);
    }


    public SelenideElement getActiveSportSlide() {
        return $(SPORT_SLIDE);
    }


    public SelenideElement getButtonNext() {
        return $(BUTTON_NEXT);
    }


    public SelenideElement getButtonPrevious() {
        return $(BUTTON_PREVIOUS);
    }


    public SelenideElement getEventType() {
        return $(SPORT_SLIDE).$(EVENT_TYPE);
    }


    public SelenideElement getEventTitle() {
        return $(SPORT_SLIDE).$(EVENT_TITLE);
    }


    public SelenideElement getEventSlideImage() {
        return $(SPORT_SLIDE).$(EVENT_SLIDE_IMAGE);
    }


    public SelenideElement getActiveDaysNumber() {

        return $(SPORT_SLIDE).$(START_DAYS_NUMBER);
    }


    public SelenideElement getActiveNameMonth() {

        return $(SPORT_SLIDE).$(START_MONTH_NAME);
    }


    public SelenideElement getStartTime() {

        return $(SPORT_SLIDE).$(START_TIME);
    }


    public SelenideElement getStartTimeText() {

        return $(SPORT_SLIDE).$(START_TIME_TEXT);
    }


    public boolean isCorrectStartTime() {

        String time = getStartTime().getText();
        boolean correct;

        if ((time.length() == 5) && (time.contains(":"))) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isCorrectActiveDaysNumber() {

        String activeDay = getActiveDaysNumber().getText();
        if (Integer.parseInt(activeDay) < 32) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isCorrectNameActiveMonth() {
        String month = getActiveNameMonth().getText().toLowerCase();
        month = month.substring(0, month.length() - 1);
        if (!isMonth(month)) {
            return false;
        }
        return true;
    }
}
