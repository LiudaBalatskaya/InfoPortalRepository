package by.issoft.info.po;


import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class CommonPage {
    protected static final By ISSOFT_LOGO = By.xpath("//img[@class='issoft-logo']");
    protected static final By COHERENT_LOGO = By.xpath("//img[@class='issoft-coherent-logo']");
    protected static final By ABOUT_COMPANY_HEADER_LINK = By.xpath("//a[text()='О компании']");
    protected static final By NEWS_HEADER_LINK = By.xpath("//a[text()='Новости']");
    protected static final By TEAM_HEADER_LINK = By.xpath("//a[text()='Команда']");
    protected static final By BRACKETED_TITLE = By.cssSelector(".page-title");


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


    public LeftHeaderMenu openLeftHeaderMenu() {
        $(ISSOFT_LOGO).click();
        return new LeftHeaderMenu();
    }


    public String getBracketedTitle() { return $(BRACKETED_TITLE).getText(); }
}
