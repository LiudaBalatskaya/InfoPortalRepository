package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class NewsPage {
    public static final String URL = "/news";

    private static final By ISSOFT_LOGO = By.xpath("//img[@class='issoft-logo']");
    private static final By COHERENT_LOGO = By.xpath("//img[@class='issoft-coherent-logo']");
    private static final By BRACKETED_TITLE = By.cssSelector("page-title");

    private static final By ABOUT_COMPANY_HEADER_LINK = By.xpath("//a[text()='О компании']");
    private static final By NEWS_HEADER_LINK = By.xpath("//a[text()='Новости']");
    private static final By TEAM_HEADER_LINK = By.xpath("//a[text()='Команда']");
    private static final By YEARS_LIST = By.cssSelector(".years-list li");


    public SelenideElement getISsoftLogo() { return $(ISSOFT_LOGO); }


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


    public SelenideElement getYearsList() {
        return $(YEARS_LIST);
    }


    public int getQuantityOfYears() { return $$(YEARS_LIST).size(); }


    public boolean checkAscendingOrder() {
        ElementsCollection records = $$(YEARS_LIST);
        int year_Before = 0;
        int year_Next;
        for (SelenideElement record : records) {
            year_Next = Integer.parseInt(record.getText());
            if (year_Next <= year_Before) {
                return false;
            }
        }
        return true;
    }


    public String getAttributeOfLastYear() {
        return $$(YEARS_LIST).get(getQuantityOfYears() - 1).attr("class");
    }
}
