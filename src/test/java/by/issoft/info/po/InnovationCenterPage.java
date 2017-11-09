package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.navigator;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class InnovationCenterPage extends CommonPage {
    public static final String URL = "/innovation-center";

    private static final By BOARD_HEADER = By.cssSelector(".kanban-board-header");
    private static final By ACTIVE_PROJECTS_SECTION = By.cssSelector(".active-projects-wrapper");
    private static final By ACTIVE_PROJECTS = By.cssSelector(".active-projects-wrapper .active-project-wrapper");
    private static final By PRODUCTS_CONTAINER = By.cssSelector(".products-wrapper");
    private static final By PRODUCTS_ITEMS = By.cssSelector(".product-item-wrapper");
    private static final By OUR_TEAM_CONTAINER = By.cssSelector(".our-team-container");
    private static final By PROPOSAL_CONTAINER = By.cssSelector(".proposal-container");
    private static final By COL_OUTER = By.cssSelector(".col-outer");
    private static final By YAMMER_LINK_BLOCK = By.cssSelector(".link-block");
    private static final By SIDE_NEWS = By.cssSelector(".side-news-block-wrapper");


    public int getCountProductsItem() {
        ElementsCollection records = $$(PRODUCTS_ITEMS);
        return records.size();
    }


    public int getCountNewsItem() {
        ElementsCollection records = $$(NEWS_ITEM);
        return records.size();
    }


    public SelenideElement getNewsItem() {
        return $(NEWS_ITEM);
    }


    public SelenideElement getNewsSide() {
        return $(SIDE_NEWS);
    }


    public SelenideElement getYammerLinkBlock() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(YAMMER_LINK_BLOCK);
    }


    public SelenideElement getBoardHeader() {
        return $(BOARD_HEADER);
    }


    public SelenideElement getActiveProjectsSection() {
        return $(ACTIVE_PROJECTS_SECTION);
    }


    public int getActiveProjectsCount() {

        ElementsCollection records = $$(ACTIVE_PROJECTS);
        return records.size();
    }


    public boolean isVisibleActiveProjects() {
        String name[] = { "Zeus", "Coherent - InfoPortal", "RecognizeApp", "Trip Tracker", "PoSledam" };
        String description[] = { "Zeus is an application, which helps managing office life in ISsoft.",
                "", "", "", "" };
        String header;
        int i = 0;
        getBody().sendKeys(Keys.PAGE_DOWN);
        ElementsCollection records = $$(ACTIVE_PROJECTS);
        for (SelenideElement record : records) {
            if (!record.$("h3").getText().contains(name[i])) {
                return false;
            }
            if (i == 0) {
                if (!record.$(".section-description").getText().contains(description[i])) {
                    return false;
                }
            }
            if (!record.$(".milestone").getText().contains("Milestone:" + "\n" + "Release")) {
                return false;
            }

            if (!record.$(".active-project-logo").isDisplayed()) {
                return false;
            }
            record.click();

            sleep(2000);

            header = getInnovationActiveHeader().getText();
            if (!header.contains(name[i])) {
                return false;
            } else {
                navigator.back();
                sleep(2000);
                getBody().sendKeys(Keys.PAGE_DOWN);
            }

            i++;
        }
        return true;
    }


    public boolean isVisibleEachDevelopmentItem() {
        String NAME[] = { "Мобильное приложение Zenerger",
                "Приложение Zeus для Meeting rooms",
                "Zebra" };
        String DESCRIPTION[] = { "Zenerger помогает минимизировать негативные последствия для здоровья",
                "Теперь вы можете легко определить доступность комнаты",
                "Незаменимая помощница в поиске конференц-залов." };
        int i = 0;
        ElementsCollection records = $$(PRODUCTS_ITEMS);
        Actions action = new Actions(getDriver());

        for (SelenideElement record : records) {
            if (!record.$(".product-item").getAttribute("style").contains("background-image")) {
                return false;
            }
            if (i > 1) {
                getBody().sendKeys(Keys.PAGE_DOWN);
                sleep(2000);
            }
            action.moveToElement(record.$(".product-description")).build().perform();
            sleep(2000);
            if (!record.$("h3").getText().contains(NAME[i])) {
                return false;
            }
            if (!record.$(".section-description").getText().contains(DESCRIPTION[i])) {
                return false;
            }
            action.release();
            action.build().perform();
            sleep(2000);
            i++;
        }
        return true;
    }


    public SelenideElement getProductsContainerSection() {
        return $(PRODUCTS_CONTAINER);
    }


    public SelenideElement getOurTeamContainerSection() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(OUR_TEAM_CONTAINER);
    }


    public SelenideElement getProposalSection() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(PROPOSAL_CONTAINER);
    }


    public SelenideElement getYammerSection() {
        getBody().sendKeys(Keys.PAGE_DOWN);
        return $(COL_OUTER);
    }


    public boolean isEachNewsItemDisplayed() {
        String header;
        String HEADERS[] = { "Будущее IT-рынка - скромный голос разума",
                "Плоды Innovation Center уже можно вкусить на Google Play",
                "Приложение Zenerger – пора подвигаться!",
                "Innovation Center: открытая дверь в мир инноваций" };
        ElementsCollection records = $$(NEWS_ITEM);
        int i = 0;
        for (SelenideElement record : records) {
            if (!isMonthNewsItem(record)) {
                return false;
            }
            if (!(isRuleNumberOfNews(record))) {
                return false;
            }
            header = record.$(".news-title").getText();
            if (!header.contains(HEADERS[i])) {
                return false;
            }
            i++;
        }
        return true;
    }
}
