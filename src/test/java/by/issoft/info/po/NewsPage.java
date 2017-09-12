package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Calendar;

public class NewsPage extends CommonPage {
    public static final String URL = "/news";

    private static final By YEARS_LIST = By.cssSelector(".years-list li");
    private static final By MONTHS_LIST = By.cssSelector(".legend-months li");


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
        String names = "";
        ElementsCollection records = $$(MONTHS_LIST);
        for (SelenideElement record : records) {
            names += record.getText() + " ";
        }
        return names;
    }


    public String getActiveNameOfMonthList() {
        String monthString = null;
        Calendar now = Calendar.getInstance();
        int year_now = now.get(Calendar.YEAR);
        int year = Integer.parseInt($$(YEARS_LIST).get($$(YEARS_LIST).size() - 1).getText());
        if (year_now > year) {
            monthString = "Октябрь-Декабрь";
        } else {
            int month = now.get(Calendar.MONTH);
            switch (month) {
                case 1:
                    monthString = "Январь-Март";
                    break;
                case 2:
                    monthString = "Январь-Март";
                    break;
                case 3:
                    monthString = "Январь-Март";
                    break;
                case 4:
                    monthString = "Апрель-Июнь";
                    break;
                case 5:
                    monthString = "Апрель-Июнь";
                    break;
                case 6:
                    monthString = "Апрель-Июнь";
                    break;
                case 7:
                    monthString = "Июль-Сентябрь";
                    break;
                case 8:
                    monthString = "Июль-Сентябрь";
                    break;
                case 9:
                    monthString = "Июль-Сентябрь";
                    break;
                case 10:
                    monthString = "Октябрь-Декабрь";
                    break;
                case 11:
                    monthString = "Октябрь-Декабрь";
                    break;
                case 12:
                    monthString = "Октябрь-Декабрь";
                    break;
                default:
                    monthString = "";
                    break;
            }
        }
        return monthString;
    }
}
