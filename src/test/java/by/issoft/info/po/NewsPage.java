package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Calendar;

public class NewsPage {
    public static final String URL = "/news";

    private static final By ISSOFT_LOGO = By.xpath("//img[@class='issoft-logo']");
    private static final By COHERENT_LOGO = By.xpath("//img[@class='issoft-coherent-logo']");
    private static final By BRACKETED_TITLE = By.cssSelector(".page-title");

    private static final By ABOUT_COMPANY_HEADER_LINK = By.xpath("//a[text()='О компании']");
    private static final By NEWS_HEADER_LINK = By.xpath("//a[text()='Новости']");
    private static final By TEAM_HEADER_LINK = By.xpath("//a[text()='Команда']");
    private static final By YEARS_LIST = By.cssSelector(".years-list li");
    private static final By MONTHS_LIST = By.cssSelector(".legend-months li");


    public SelenideElement getISsoftLogo() { return $(ISSOFT_LOGO); }


    public SelenideElement getCoherentLogo() { return $(COHERENT_LOGO); }


    public String getBracketedTitle() { return $(BRACKETED_TITLE).getText(); }


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


    public SelenideElement getMonthsList() {
        return $(MONTHS_LIST);
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
        String names = null;
        ElementsCollection records = $$(MONTHS_LIST);
        for (SelenideElement record : records) {
            names += record.getText() + " ";
        }
        return names;
    }


    public String getActiveNameOfMonthList() {
        Calendar now = Calendar.getInstance();
        int year_now = now.get(Calendar.YEAR);
        int year = Integer.parseInt($$(YEARS_LIST).get($$(YEARS_LIST).size()).getText());
        if (year_now > year) {
            return "Октябрь-Декабрь";
        } else {
            int month = now.get(Calendar.MONTH);
            switch (month) {
                case 1:
                    break;
            }
            return "";
        }
    }
}
