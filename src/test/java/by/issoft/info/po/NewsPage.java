package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class NewsPage {
    public static final String URL = "/news";

    private static final By ISSOFT_LOGO = By.xpath("//img[@class='issoft-logo']");
    private static final By COHERENT_LOGO = By.xpath("//img[@class='issoft-coherent-logo']");

    private static final By ABOUT_COMPANY_HEADER_LINK = By.xpath("//a[text()='О компании']");
    private static final By NEWS_HEADER_LINK = By.xpath("//a[text()='Новости']");
    private static final By TEAM_HEADER_LINK = By.xpath("//a[text()='Команда']");


    public SelenideElement getHeaderLogo() { return $(ISSOFT_LOGO); }


    public SelenideElement getCoherentLogo() { return $(COHERENT_LOGO); }


    public SelenideElement getNewsHeaderLink() {
        return $(NEWS_HEADER_LINK);
    }


    public SelenideElement getTeamHeaderLink() {
        return $(TEAM_HEADER_LINK);
    }


    public SelenideElement getAboutCompanyHeaderLink() {
        return $(ABOUT_COMPANY_HEADER_LINK);
    }
}
