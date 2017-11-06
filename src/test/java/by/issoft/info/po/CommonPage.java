package by.issoft.info.po;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    public static final By INDICATOR = By.cssSelector(".page-title");
    protected static final By ISSOFT_LOGO = By.xpath("//img[@class='issoft-logo']");
    protected static final By COHERENT_LOGO = By.xpath("//img[@class='issoft-coherent-logo']");
    protected static final By ABOUT_COMPANY_HEADER_LINK = By.xpath("//a[text()='О компании']");
    protected static final By NEWS_HEADER_LINK = By.xpath("//a[text()='Новости']");
    protected static final By TEAM_HEADER_LINK = By.xpath("//a[text()='Команда']");
    protected static final By BRACKETED_TITLE = By.cssSelector(".page-title");
    protected static final By BODY = By.cssSelector("body");
    private static final By FEEDBACK_BUTTON = By.cssSelector(".button.secondary-button-color");
    protected static final By DEPARTMENTS = By.cssSelector(".person-description");
    protected static final By NAVIGATION_LINK_ACTIVE = By.cssSelector(".navigation-link.router-link-active");

    public String winHandlePage;
    public String toDepartmentItem = "";
    public WebDriver driver;

    public static String[] TRAINERS = new String[]{ "Vitaly Kliauzo", "Igor Korshuk", "Sergey Babitsky",
            "Sergey Gorbaba", "Slava Leventuyev", "Alexey Sas", "Andrey Lapitsky", "Andrey Protas",
            "Roman Malinovskii", "Slava Kupreev", "Andrey Vershadov", "Nikolai Petushkov",
            "Sveta Leventuyeva", "Tatiana Mikhalenok", "Alesya Popkova", "Andrey Frantov",
            "Timofey Gavrilenko", "Eugen Yushin", "Lena Bashmakova", "Viktor Alekseev",
            "Andrey Ramanouski", "Dmitry Kavtur", "Alexey Volosevich", "Hanna Kaleinik", "Oleg Yaroshenko",
            "Dmitry Petruchenya", "Eugen Gvozd", "Eugen Borisik", "Igor Efremenko", "Marina Lepeshko", "Oleg Lavruschik" };

    public static String[] MONTHS = new String[]{ "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };


    public boolean isMonthFound(String month) {
        for (int i = 0; i < MONTHS.length; i++) {
            if (MONTHS[i].contentEquals(month)) {
                return true;
            }
        }
        return false;
    }


    public boolean isMonth(String month) {
        String listsMonth;
        for (int i = 0; i < MONTHS.length; i++) {
            listsMonth = MONTHS[i].toLowerCase();
            if (listsMonth.contains(month)) {
                return true;
            }
        }
        return false;
    }


    public WebDriver getDriver() {
        return getWebDriver();
    }


    public SelenideElement getISsoftLogo() {
        return $(ISSOFT_LOGO);
    }


    public SelenideElement getCoherentLogo() {
        return $(COHERENT_LOGO);
    }


    public SelenideElement getNavigationActiveLink() {
        return $(NAVIGATION_LINK_ACTIVE);
    }


    public SelenideElement getNewsHeaderLink() {
        return $(NEWS_HEADER_LINK);
    }


    public SelenideElement getTeamHeaderLink() {
        return $(TEAM_HEADER_LINK);
    }


    public SelenideElement getAboutCompanyHeaderLink() {
        return $(ABOUT_COMPANY_HEADER_LINK);
    }


    public SelenideElement getBody() { return $(BODY); }


    public SelenideElement getFeedback() {
        return $(FEEDBACK_BUTTON);
    }


    public LeftHeaderMenu openLeftHeaderMenu() {
        $(ISSOFT_LOGO).click();
        return new LeftHeaderMenu();
    }


    public String getBracketedTitle() { return $(BRACKETED_TITLE).getText(); }


    public String getTitle() { return $("title").getText(); }


    public void switchToLoadedPage(SelenideElement ELEMENT) {
        WebDriver driver = getWebDriver();
        winHandlePage = driver.getWindowHandle();
        $(ELEMENT).click();
        Object[] allWindows = driver.getWindowHandles().toArray();
        String linkWindow = "" + allWindows[1];
        getWebDriver().switchTo().window(linkWindow);
        sleep(2000);

    }

}
