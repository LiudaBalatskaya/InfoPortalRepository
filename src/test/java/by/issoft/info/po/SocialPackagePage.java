package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class SocialPackagePage extends CommonPage {
    public static final String URL = "/social-package";

    private static final By SOCIAL_PACKAGE_LIST = By.cssSelector(".social-package-list li");
    private static final By TRAINING_CENTER_ITEM = By.cssSelector(".social-package-list li:first-of-type");
    private static final By BONUSES_ITEM = By.cssSelector(".social-package-list li:nth-of-type(2)");
    private static final By HEALTH_INSURANCES_ITEM = By.cssSelector(".social-package-list li:nth-of-type(3)");
    private static final By MODAL_BLOCK = By.cssSelector(".modal-open");
    private static final By DESCRIPTION_MODAL_BLOCK = By.cssSelector(".modal-open p");
    private static final By ENGLISH_DESCRIPTION_MODAL_BLOCK = By.cssSelector(".modal-open ol li");
    private static final By SERVICES_LIST_MODAL_BLOCK = By.cssSelector(".modal-open ul li");
    private static final By ENGLISH_COACHES = By.cssSelector(".modal-open ol li ul li");
    private static final By ENGLISH_LANGUAGE_ITEM = By.cssSelector(".social-package-list li:nth-of-type(4)");
    private static final By HEADER_OFFICIALS_ENGLISH = By.cssSelector(".modal-open div>span");
    private static final By SPORT_ITEM = By.cssSelector(".social-package-list li:nth-of-type(5)");
    private static final By VACATION_ITEM = By.cssSelector(".social-package-list li:nth-of-type(6)");
    private static final By SCHEDULE_ITEM = By.cssSelector(".social-package-list li:nth-of-type(7)");
    private static final By DINNER_ITEM = By.cssSelector(".social-package-list li:last-of-type");


    public SelenideElement getHeaderOfficialEnglish() {
        return $(HEADER_OFFICIALS_ENGLISH);
    }


    public SelenideElement getDinnerItem() {
        return $(DINNER_ITEM);
    }


    public SelenideElement getScheduleItem() {
        return $(SCHEDULE_ITEM);
    }


    public SelenideElement getVacationItem() {
        return $(VACATION_ITEM);
    }


    public SelenideElement getSportItem() {
        return $(SPORT_ITEM);
    }


    public SelenideElement getEnglishLanguageItem() {
        return $(ENGLISH_LANGUAGE_ITEM);
    }


    public SelenideElement getModalBlock() {
        return $(MODAL_BLOCK);
    }


    public SelenideElement getHealthInsurancesItem() {
        return $(HEALTH_INSURANCES_ITEM);
    }


    public SelenideElement getBonusesItem() {
        return $(BONUSES_ITEM);
    }


    public SelenideElement getTrainingCenterItem() {
        return $(TRAINING_CENTER_ITEM);
    }


    public SelenideElement getSocialPackageList() {
        return $(SOCIAL_PACKAGE_LIST);
    }


    public String getCountSocialPackageList() {
        ElementsCollection records = $$(SOCIAL_PACKAGE_LIST);
        return Integer.toString(records.size());
    }


    public boolean isVisibleCorrectDescriptionHealthModal() {
        ElementsCollection records = $$(DESCRIPTION_MODAL_BLOCK);
        String description[] = { "Каждому сотруднику после прохождения им испытательного срока предоставляется медицинская страховка,",
                "Страховка предоставляется компанией «Белэксимгарант»,",
                "Страховка обеспечивает индивидуальное обслуживание по медицинским показаниям:",
                "По всем вопросам можно обращаться к" };

        String servicesList[] = { "консультации врачей всех специальностей;",
                "все виды диагностики: лабораторная, функциональная, лучевая, ультразвуковая, эндоскопическая, морфологическая;",
                "проведение назначенного лечения;",
                "выдача листка нетрудоспособности по медицинским показаниям",
                "диспансерное наблюдение и обследование." };
        int i = 0, j = 0;
        boolean correct = true;
        for (SelenideElement record : records) {
            if (!($(record).getText().contains(description[i]))) {
                return false;
            }

            if (i == 2) {
                ElementsCollection services = $$(SERVICES_LIST_MODAL_BLOCK);
                for (SelenideElement service : services) {
                    if (!(service.getText().contains(servicesList[j]))) {
                        return false;
                    }
                    j++;
                }
            }
            i++;
        }
        return true;
    }


    public boolean isVisibleCorrectDescriptionEnglishModal() {
        ElementsCollection records = $$(ENGLISH_DESCRIPTION_MODAL_BLOCK);
        String description[] = { "Платные группы от http://itenglish.by.",
                "Бесплатные группы, которые ведут 2 наших сотрудницы." };

        String coachName[] = { "Natalia Rachkova", "Marina Tsitova" };

        int i = 0, j = 0;
        boolean correct = true;
        for (SelenideElement record : records) {
            if (i < 2) {
                if (!(record).getText().contains(description[i])) {
                    return false;
                }
                switch (i) {
                    case 0:
                        if (!(record).$("a").getAttribute("href").contains("http://itenglish.by")) {
                            return false;
                        }
                        break;
                    case 1:
                        ElementsCollection coaches = $$(ENGLISH_COACHES);
                        for (SelenideElement coach : coaches) {
                            if (!coach.$("img").isDisplayed()) {
                                return false;
                            }
                            if (!coach.$("span").getText().contains(coachName[j])) {
                                return false;
                            }

                            if (!coach.$("a").getAttribute("href").contains("https://rmsys.issoft.by/Individual/Index#")) {
                                return false;
                            }
                            j++;
                        }
                        break;
                }
            }
            i++;
        }
        return true;
    }


    public boolean isVisibleCorrectEnglishOfficials() {
        String coachName[] = { "Varvara Paseko", "Vladimir Zolotovsky" };

        ElementsCollection coaches = $$(ENGLISH_COACHES);
        int i = 0;
        for (SelenideElement coach : coaches) {
            if (i > 1) {
                if (!coach.$("img").isDisplayed()) {
                    return false;
                }
                if (!coach.$("span").getText().contains(coachName[i-2])) {
                    return false;
                }

                if (!coach.$("a").getAttribute("href").contains("https://rmsys.issoft.by/Individual/Index#")) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
