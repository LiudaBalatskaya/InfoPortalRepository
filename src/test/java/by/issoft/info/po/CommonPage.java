package by.issoft.info.po;


import static com.codeborne.selenide.Selenide.$;
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

    public String winHandlePage;
    public String toDepartmentItem = "";
    public WebDriver driver;


    public WebDriver getDriver() {
        return getWebDriver();
    }

    public SelenideElement getISsoftLogo() {
        return $(ISSOFT_LOGO);
    }


    public SelenideElement getCoherentLogo() {
        return $(COHERENT_LOGO);
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


    public SelenideElement getBody() {
        return $(BODY);
    }


    public SelenideElement getFeedback() {
        return $(FEEDBACK_BUTTON);
    }


    public LeftHeaderMenu openLeftHeaderMenu() {
        $(ISSOFT_LOGO).click();
        return new LeftHeaderMenu();
    }


    public String getBracketedTitle() { return $(BRACKETED_TITLE).getText(); }
}
