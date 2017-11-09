package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HrBonusesPage extends CommonPage {
    public static final String URL = "/hr-bonuses";

    protected static final By BONUS_SYSTEM = By.cssSelector(".hr-bonuses-wrapper");
    protected static final By DESCRIPTION_BONUS_SYSTEM = By.cssSelector(".hr-bonuses-wrapper p");
    protected static final By VACANCIES = By.cssSelector(".vacancies");
    protected static final By VACANCIES_LIST = By.cssSelector(".vacancies div");
    protected static final By HR_FEEDBACK_BUTTON = By.cssSelector(".feedback-button");


    public SelenideElement getHRFeedback() {
        return $(HR_FEEDBACK_BUTTON);
    }

    public SelenideElement getBonusSystem() {
        return $(BONUS_SYSTEM);
    }


    public SelenideElement getVacancies() {
        return $(VACANCIES);
    }


    public int getCountDescriptionItem() {
        ElementsCollection records = $$(DESCRIPTION_BONUS_SYSTEM);
        return records.size();
    }


    public boolean isVisibleDescriptions() {
        String DESCRIPTION[] = { "В нашей компании существует бонусная система вознаграждений,",
                "Первый бонус в размере 1000$",
                "Единственное условие для получения последующих ежеквартальных премий",
                "Бонус выплачивается за всех специалистов, начиная с уровня middle.",
                "За дополнительной информацией обращайтесь к HRам." };
        String header;
        int i = 0;
        getBody().sendKeys(Keys.PAGE_DOWN);
        ElementsCollection records = $$(DESCRIPTION_BONUS_SYSTEM);
        for (SelenideElement record : records) {
            if (!record.getText().contains(DESCRIPTION[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean isVisibleVacancies() {
        String VACANCIES[] = { "Lead Front-End Developer",
                "Front-End Developer",
                ".NET Developer",
                "Business Analyst",
                "SQL Developer",
                "BI Developer",
                "DevOps Engineer",
                "Java Developer",
                "QA Engineer",
                "QA Automation Engineer" };

        String vacancy;
        int i = 0;
        boolean correct = true;
        ElementsCollection records = $$(VACANCIES_LIST);
        for (SelenideElement record : records) {
            vacancy = record.getText();
            for (int j = 0; j < VACANCIES.length; j++) {
                if (!VACANCIES[i].contentEquals(vacancy)) {
                    correct= false;
                    break;
                }
             }
        }
        return correct;
    }
}
