package by.issoft.info.po;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RulesPage extends CommonPage {
    public static final String URL = "/rules";
    private static final By MENUBAR_HEADER_TEXT = By.cssSelector(".menubar-header-text");
    private static final By DAY_SCHEDULE = By.cssSelector("li:nth-of-type(1) .rule-content-part");
    private static final By FIRST_ITEM_TITLE = By.cssSelector(".title-secondary-header-text");
    private static final By SCHEDULE_ICON = By.cssSelector(".navigation-item-image.day-rules-icon");


    private static final By WORK_HOURS = By.cssSelector("li:nth-of-type(2) .rule-content-part");
    private static final By WORK_HOURS_ICON = By.cssSelector(".navigation-item-image.time-rules-icon");
    private static final By WORK_HOURS_LINK = By.cssSelector("li:nth-of-type(2) a");
    private static final By ITEM_TITLE = By.cssSelector(".introduction-part .title-header-text");

    private static final By GROUP_MANAGER = By.cssSelector("li:nth-of-type(3) .rule-content-part");
    private static final By GROUP_MANAGER_ICON = By.cssSelector(".navigation-item-image.group-manager-rules-icon");

    private static final By DINNER = By.cssSelector("li:nth-of-type(4) .rule-content-part");
    private static final By DINNER_ICON = By.cssSelector(".navigation-item-image.dinner-rules-icon");

    private static final By RELAX = By.cssSelector("li:nth-of-type(5) .rule-content-part");
    private static final By RELAX_ICON = By.cssSelector(".navigation-item-image.rest-rules-icon");

    private static final By INTERNET = By.cssSelector("li:nth-of-type(6) .rule-content-part");
    private static final By INTERNET_ICON = By.cssSelector(".navigation-item-image.internet-rules-icon");
    private static final By SECTION_HEADER_INTERNET = By.xpath("//ip-rules/ip-internet-rules/div/h2");
    private static final By INTERNET_SECTION_COLUMNS = By.cssSelector(".rule-3-column.rule-advice-section.rule-content");
    private static final By INTERNET_LICENSE = By.cssSelector(".lycense-section");
    private static final By INTERNET_LICENSE_SECTION = By.cssSelector(".rule-4-column.rule-advice-section.rule-content");
    private static final By INTERNET_OPEN_SOURCE_HEADER = By.cssSelector(".open-source-section .section-header");
    private static final By INTERNET_OPEN_SOURCE_SECTION = By.cssSelector(".rule-4-column.rule-content:last-of-type ");
    private static final By INTERNET_CLOUD_SERVICES_SECTION = By.cssSelector(".introduction-part.rule-wrapper");
    private static final By INTERNET_CLOUD_SERVICES_SECTION_HEADER = By.cssSelector(".introduction-part.rule-wrapper>h2");
    private static final By INTERNET_PROJECT_PORTALS = By.xpath("//div[5]//li[1]//li[2]/a");
    private static final By INTERNET_WEB_MOBILE = By.xpath("//div[5]//li[1]//li[3]/a");
    private static final By INTERNET_ATLASSIAN_CLOUD = By.xpath("//div[5]//li[1]//li[4]/a");
    private static final By INTERNET_BITBUCKET = By.xpath("//div[5]//li[1]//li[5]/a");
    private static final By INTERNET_COHERENT = By.xpath("//div[5]//li[1]//li[6]/a");
    private static final By INTERNET_DOWNLOADING_FILES = By.cssSelector(".rule-2-columns.rule-wrapper li:first-of-type");
    private static final By INTERNET_SOCIAL_NETWORKS = By.cssSelector(".rule-2-columns.rule-wrapper li:last-of-type");

    private static final By PRINTERS = By.cssSelector("li:nth-of-type(7) .rule-content-part");
    private static final By PRINTERS_ICON = By.cssSelector(".navigation-item-image.printer-rules-icon");

    private static final By VACATION = By.cssSelector("li:nth-of-type(8) .rule-content-part");
    private static final By VACATION_ICON = By.cssSelector(".navigation-item-image.vacation-rules-icon");

    private static final By ACCOUNTING = By.cssSelector("li:nth-of-type(9) .rule-content-part");
    private static final By ACCOUNTING_ICON = By.cssSelector(".navigation-item-image.accountant-rules-icon");
    private static final By INTRODUCTION_PART = By.cssSelector(".introduction-part");
    private static final By REFERENCES = By.cssSelector(".about-references");

    private static final By HELPDESK_ITEM = By.cssSelector("li:nth-of-type(10) .rule-content-part");
    private static final By LINK_HELPDESK = By.cssSelector(".about-references>p:nth-of-type(2)");

    private static final By ACCOUNT_DEPARTMENT_SECTION = By.cssSelector(".accountant-department-section");
    private static final By CONTENT_SECTION = By.cssSelector(".main-content-section");
    private static final By ACCOUNT_PERSON_DATA = By.cssSelector(".accountant-department-section .person-data");
    private static final By ATTENTION_ACCOUNTING = By.cssSelector(".warning-wrapper");
    private static final By ACCOUNTING_ISSOFT_NAME_SECTION = By.cssSelector(".warning-wrapper .issoft-name-section");

    private static final By HUMAN_RESOURCE_SECTION = By.cssSelector(".human-resources-department-section");
    private static final By HEADER_ARTICLE_HUMAN_RESOURCE = By.cssSelector(".employee-provider .article-header");
    private static final By CONTENT_ARTICLE_HUMAN_RESOURCE = By.cssSelector(".human-resources-department-section .employee-provider li");
    private static final By HUMAN_RESOURCE_PERSON_DATA = By.cssSelector(".human-resources-department-contacts");

    private static final By HUMAN_RESOURCE_PROVIDER = By.cssSelector(".human-resourses-provider");
    private static final By CONTENT_PROVIDER = By.cssSelector(".human-resourses-provider li");

    private static final By HR_SECTION = By.cssSelector(".hr-section");
    private static final By PERSONAL_DATA_HR_SECTION = By.cssSelector(".human-resources-department-contacts");

    private static final By SUPPORT = By.cssSelector("li:nth-of-type(10) .rule-content-part");
    private static final By SUPPORT_ICON = By.cssSelector(".navigation-item-image.support-rules-icon");

    private static final By DAYS_SCHEDULE = By.cssSelector(".rule-4-columns.rule-wrapper li");
    private static final By RULE_NUMBER = By.cssSelector(".rule-number");
    private static final By RULE_HEADER = By.cssSelector(".rule-header");
    private static final By RULE_DESCRIPTION = By.cssSelector(".rule-description");
    private static final By RULE_SECTION_HEADER = By.xpath("//ip-vacation-rules//div[2]/h2");
    private static final By RULE_DESCRIPTION_COMMAND_ITEM = By.cssSelector(".rule-description.command-item");

    private static final By RULE_STEPS_WORK_HOURS = By.cssSelector(".rule-step");

    private static final By RULE_HEADER_DESCRIPTION = By.cssSelector(".rule-header-description");

    private static final By RULE_QUESTIONS = By.cssSelector(".attention-section");

    private static final By ATTENTION_RULES_LIST = By.cssSelector(".attention-section .list-item");

    private static final By RULE_QUESTIONS_HEADER = By.cssSelector(".attention-section .title-header-text");

    private static final By RULE_QUESTIONS_COLUMNS = By.cssSelector(".attention-section .rule-3-columns");

    private static final By RULE_QUESTIONS_COLUMNS_COLLECTION = By.cssSelector(".rule-3-column.rule-content");

    private static final By RULE_STEP1 = By.cssSelector(".rule-step:nth-of-type(1)");

    private static final By RULE_STEP2 = By.cssSelector(".rule-step:nth-of-type(2)");

    private static final By RULE_STEP3 = By.cssSelector(".rule-step:nth-of-type(3)");

    private static final By RULE_STEP4 = By.cssSelector(".rule-step:nth-of-type(4)");

    private static final By RULE_STEP5 = By.cssSelector(".rule-step:nth-of-type(5)");

    private static final By RULE_STEP6 = By.cssSelector(".rule-step:nth-of-type(6)");

    private static final By RULE_COLUMN1 = By.cssSelector(".rule-3-column.rule-content:nth-of-Type(1)");

    private static final By RULE_COLUMN2 = By.cssSelector(".rule-3-column.rule-content:nth-of-Type(2)");

    private static final By RULE_COLUMN3 = By.cssSelector(".rule-3-column.rule-content:nth-of-Type(3)");

    private static final By WARNING_WRAPPER = By.cssSelector(".warning-wrapper");

    private static final By HEADER_UNPAID_VACATION = By.xpath("//ip-vacation-rules//div[4]/h2");

    private static final By DESCRIPTION_UNPAID_VACATION = By.xpath("//ip-vacation-rules/div/p[1]");

    private static final By CONTINUE_DESCRIPTION_UNPAID_VACATION = By.xpath("//ip-vacation-rules/div/p[2]");

    private static final By LINK_DESCRIPTION_UNPAID_VACATION = By.xpath("//ip-vacation-rules/div/p[2]//a[1]");

    private static final By OFFICE = By.xpath("//ip-vacation-rules/div/h3");

    private static final By PERSON_DATA = By.cssSelector(".person-data.rule-wrapper");

    private static final By INSTRUCTIONS = By.cssSelector(".rule-step:nth-of-type(2) .commands li");

    private static final By ATTENTION_SECTION1 = By.cssSelector(".attention-section:first-of-type .warning-wrapper");
    private static final By ATTENTION_SECTION2 = By.cssSelector(".attention-section:nth-of-type(2) .warning-wrapper");
    private static final By ATTENTION_SECTION3 = By.xpath("//div/div[6]/div");
    private static final By DESCRIPTION_ATTENTION_SECTION = By.xpath("//div/div[6]/div");

    public SelenideElement getAttentionSection1() {
        return $(ATTENTION_SECTION1);
    }

    public SelenideElement getAttentionSection2() {
        return $(ATTENTION_SECTION2);
    }

    public SelenideElement getAttentionSection3() {
        return $(ATTENTION_SECTION3);
    }

    public boolean isDescriptionAttentionSection3() {
        String text = "Использование других сервисов возможно только после разрешения";
        return $(DESCRIPTION_ATTENTION_SECTION).getText().contains(text);
    }

    public SelenideElement getSocialNetworksSection() {
        return $(INTERNET_SOCIAL_NETWORKS);
    }

    public String getSocialNetworksSectionHeader() {
        return $(INTERNET_SOCIAL_NETWORKS).$("h2").getText();
    }

    public SelenideElement getDownloadingFilesSection() {
        return $(INTERNET_DOWNLOADING_FILES);
    }

    public String getDownloadingFilesSectionHeader() {
        return $(INTERNET_DOWNLOADING_FILES).$("h2").getText();
    }

    public String getDownloadingFilesDescription1() {
        return $(INTERNET_DOWNLOADING_FILES).$(".rule-description:first-of-type").getText();
    }

    public String getDownloadingFilesDescription2() {
        return $(INTERNET_DOWNLOADING_FILES).$(".rule-description:last-of-type").getText();
    }

    public SelenideElement getCloudServicesSection() {
        return $(INTERNET_CLOUD_SERVICES_SECTION);
    }

    public String getCloudServicesSectionHeader() {
        return $(INTERNET_CLOUD_SERVICES_SECTION_HEADER).getText();
    }

    public boolean isVisibleCorrectCustomerPortal(){
       boolean correct = $(INTERNET_CLOUD_SERVICES_SECTION).$(byText("Customer Portal")).isDisplayed();
       if(correct){
           correct = $(INTERNET_CLOUD_SERVICES_SECTION).$(byText("Customer Portal")).getAttribute("href").contains("https://clients.coherentsolutions.com");
       }
       return correct;
    }

    public boolean isVisibleCorrectProjectPortals(){
        boolean correct = $(INTERNET_PROJECT_PORTALS).getText().contains("Project Portals");
        if(correct){
            correct = $(INTERNET_PROJECT_PORTALS).getAttribute("href").contains("https://coherentsolutions-my.sharepoint.com/");
        }
        return correct;
    }

    public boolean isVisibleCorrectWebMobile(){
        boolean correct = $(INTERNET_WEB_MOBILE).getText().contains("Web and Mobile Mail Access");
        String href = "https://outlook.office365.com/owa/?realm=coherentsolutions.com&";
        if(correct){
            correct = $(INTERNET_WEB_MOBILE).getAttribute("href").contains(href);
        }
        return correct;
    }

    public boolean isVisibleCorrectAtlassianCloud(){
        boolean correct = $(INTERNET_ATLASSIAN_CLOUD).getText().contains("Atlassian Cloud");
        String href = "https://ru.atlassian.com/licensing";
        if(correct){
            correct = $(INTERNET_ATLASSIAN_CLOUD).getAttribute("href").contains(href);
        }
        return correct;
    }

    public boolean isVisibleCorrectBitbucket(){
        boolean correct = $(INTERNET_BITBUCKET).getText().contains("Bitbucket");
        String href = "https://bitbucket.org";
        if(correct){
            correct = $(INTERNET_BITBUCKET).getAttribute("href").contains(href);
        }
        return correct;
    }

    public boolean isVisibleCorrectCoherentSolutionsWebEx(){
        boolean correct = $(INTERNET_COHERENT).getText().contains("Coherent Solutions WebEx");
        String href = "https://coherentsolutions.webex.com/mw3000/mywebex";
        if(correct){
            correct = $(INTERNET_COHERENT).getAttribute("href").contains(href);
        }
        return correct;
    }

    public String getOpenSourceHeaderInternet() {
        return $(INTERNET_OPEN_SOURCE_HEADER).getText();
    }

    public SelenideElement getOpenSourceSection() {
        return $(INTERNET_OPEN_SOURCE_SECTION);
    }


    public String getLicenseSectionInternet() {
        return $(INTERNET_LICENSE).getText();
    }

    public String getCountLicenseSectionInternet() {
        ElementsCollection records = $$(INTERNET_LICENSE_SECTION);
        return Integer.toString(records.size());
    }


    public boolean isVisibleCorrectLicenseSectionInternet() {
        ElementsCollection records = $$(INTERNET_LICENSE_SECTION);
        boolean correct = true;
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if ($(record).$("img").isDisplayed()) {
                switch (i) {
                    case 1:
                        correct = $(record).$(RULE_NUMBER).getText().contains("01");
                        if (correct) {
                            correct = $(record).$(RULE_DESCRIPTION).getText().contains("Если для выполнения должностных обязанностей вам требуется коммерческое ПО");
                        }
                        break;
                    case 2:
                        correct = $(record).$(RULE_NUMBER).getText().contains("02");
                        if (correct) {
                            correct = $(record).$(RULE_DESCRIPTION).getText().contains("Для покупки лицензии Team Lead");
                        }
                        break;
                    case 3:
                        correct = $(record).$(RULE_NUMBER).getText().contains("03");
                        if (correct) {
                            correct = $(record).$(RULE_DESCRIPTION).getText().contains("После того, как ПО станет доступно,");
                        }
                        break;
                }
            }
            if (!correct) {
                return false;
            }
        }
        return correct;
    }


    public String getCountRulesSectionInternet() {
        ElementsCollection records = $$(INTERNET_SECTION_COLUMNS);
        return Integer.toString(records.size());
    }


    public boolean isVisibleCorrectRulesSectionInternet() {
        ElementsCollection records = $$(INTERNET_SECTION_COLUMNS);
        boolean correct = true;
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if ($(record).$("img").isDisplayed()) {
                switch (i) {
                    case 1:
                        correct = $(record).$(RULE_NUMBER).getText().contains("01");
                        if (correct) {
                            correct = $(record).$(RULE_DESCRIPTION).getText().contains("Не поощряется использование интернета в нерабочих целях");
                        }
                        break;
                    case 2:
                        correct = $(record).$(RULE_NUMBER).getText().contains("02");
                        if (correct) {
                            correct = $(record).$(RULE_DESCRIPTION).getText().contains("Запрещается посещать сайты порнографического и");
                        }
                        break;
                    case 3:
                        correct = $(record).$(RULE_NUMBER).getText().contains("03");
                        if (correct) {
                            correct = $(record).$(RULE_DESCRIPTION).getText().contains("Использование корпоративного Wi-Fi и VPN клиентов");
                        }
                        break;
                }
            }
            if (!correct) {
                return false;
            }
        }
        return correct;
    }


    public String getSectionHeaderInternet() {

       return $(SECTION_HEADER_INTERNET).getText();

    }


    public String getCountInstruction() {
        ElementsCollection records = $$(INSTRUCTIONS);
        return Integer.toString(records.size());
    }


    public boolean isVisibleCorrectInstruction() {
        ElementsCollection records = $$(INSTRUCTIONS);
        boolean correct = true;
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (correct) {
                switch (i) {
                    case 1:
                        correct = $(record).getText().contains("В поле Subject введите краткое описание вашей проблемы");
                        break;
                    case 2:
                        correct = $(record).getText().contains("Укажите приоритет проблемы");
                        break;
                    case 3:
                        correct = $(record).getText().contains("Выберите Category");
                        break;
                    case 4:
                        correct = $(record).getText().contains("В Description опишите все важные детали проблемы");
                        break;
                    case 5:
                        correct = $(record).getText().contains("При необходимости добавьте скриншот");
                        break;
                    case 6:
                        correct = $(record).getText().contains("Нажмите Submit");
                        break;
                }
            }
            if (!correct) {
                return false;
            }
        }
        return correct;
    }


    public SelenideElement getHelpDeskItem() {
        return $(HELPDESK_ITEM);
    }


    public SelenideElement getIntroductionPart() {
        return $(INTRODUCTION_PART);
    }


    public SelenideElement getReference() {
        return $(INTRODUCTION_PART).$(REFERENCES);
    }


    public SelenideElement getHRSection() {
        return $(HR_SECTION);
    }


    public SelenideElement getPersonDataHRSection() {
        return $(HR_SECTION).$(PERSONAL_DATA_HR_SECTION);
    }


    public SelenideElement getHumanResourceProvider() {
        return $(HUMAN_RESOURCE_PROVIDER);
    }


    public SelenideElement getHumanResourceSection() {
        return $(HUMAN_RESOURCE_SECTION);
    }


    public SelenideElement getHumanResourcePersonData() {
        return $(HUMAN_RESOURCE_SECTION).$(HUMAN_RESOURCE_PERSON_DATA);
    }


    public String getHeaderArticleHumanResource() {
        return $(HUMAN_RESOURCE_SECTION).$(HEADER_ARTICLE_HUMAN_RESOURCE).getText();
    }


    public boolean isVisibleCorrectArticleHumanResource() {
        ElementsCollection records = $$(CONTENT_ARTICLE_HUMAN_RESOURCE);
        boolean correct = true;
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (correct) {
                switch (i) {
                    case 1:
                        correct = $(record).getText().contains("Повестки");
                        break;
                    case 2:
                        correct = $(record).getText().contains("Направления на работу");
                        break;
                }
            }
            if (!correct) {
                return false;
            }
        }
        return correct;
    }


    public boolean isVisibleCorrectProviderArticle() {
        ElementsCollection records = $$(CONTENT_PROVIDER);
        boolean correct = true;
        int i = 0;
        for (SelenideElement record : records) {
            i++;
            if (correct) {
                switch (i) {
                    case 1:
                        correct = $(record).getText().contains("Ксерокопию трудовой книжки");
                        break;
                    case 2:
                        correct = $(record).getText().contains("Справку с места работы");
                        break;
                    case 3:
                        correct = $(record).getText().contains("Справку для посольства и других организаций (кроме банка)");
                        break;
                }
            }
            if (!correct) {
                return false;
            }
        }
        return correct;
    }


    public SelenideElement getAccountDepartmentSection() {
        return $(ACCOUNT_DEPARTMENT_SECTION);
    }


    public SelenideElement getContentSection() {
        return $(ACCOUNT_DEPARTMENT_SECTION).$(CONTENT_SECTION);
    }


    public SelenideElement getAttentionAccounting() {
        return $(ATTENTION_ACCOUNTING);
    }

    public String getCountAttentionSection() {
        ElementsCollection records = $$(ATTENTION_ACCOUNTING);
        return Integer.toString(records.size());
    }

    public String getCountIssoftNameSection() {
        ElementsCollection records = $$(ACCOUNTING_ISSOFT_NAME_SECTION);
        return Integer.toString(records.size());
    }


    public boolean isVisibleCorrectIssoftNameSection() {
        ElementsCollection records = $$(ACCOUNTING_ISSOFT_NAME_SECTION);
        int i = 0;
        boolean correct = true;
        for (SelenideElement record : records) {
            i++;
            if (correct) {
                switch (i) {
                    case 1:
                        correct = $(record).$(".article-header").getText().contains("Полное название:");
                        if (correct) {
                            correct = $(record).$(".rule-description").getText().contains("Иностранное производственное унитарное предприятие \"ИССОФТ СОЛЮШЕНЗ\"");
                        }
                        break;
                    case 2:
                        correct = $(record).$(".article-header").getText().contains("Сокращённое название:");
                        if (correct) {
                            correct = $(record).$(".rule-description").getText().contains("Иностранное унитарное предприятие \"ИССОФТ СОЛЮШЕНЗ\"");
                        }
                        break;
                }
            }
            if (!correct) {
                return false;
            }
        }
        return correct;
    }


    public String getCountAccountPersonData() {
        ElementsCollection records = $$(ACCOUNT_PERSON_DATA);
        return Integer.toString(records.size());
    }


    public boolean isVisiblePersonDatesAccountSection() {
        ElementsCollection records = $$(ACCOUNT_PERSON_DATA);
        int i = 0;
        boolean correct = false;
        for (SelenideElement record : records) {
            i++;
            correct = record.$("img").isDisplayed();
            if (correct) {
                correct = $(record).$("div a img").isDisplayed();
            }
            if (correct) {
                switch (i) {
                    case 1:
                        correct = $(record).$(".article-header").getText().contains("Оксана Перепичка");
                        if (correct) {
                            correct = $(record).$(".rule-description").getText().contains("Главный бухгалтер");
                        }
                        if (correct) {
                            correct = $(record).$("div a").getAttribute("href").contains("skype:csi.oksanaperepichka?add");
                        }
                        break;
                    case 2:
                        correct = $(record).$(".article-header").getText().contains("Алена Гриневич");
                        if (correct) {
                            correct = $(record).$(".rule-description").getText().contains("Бухгалтер");
                        }
                        if (correct) {
                            correct = $(record).$("div a").getAttribute("href").contains("skype:csi.LenaGrinevich?add");
                        }
                        break;
                }
            }
            if (!correct) {
                return false;
            }
        }
        return correct;
    }


    public SelenideElement getPersonData() { return $(PERSON_DATA); }


    public String getOffice() {
        return $(OFFICE).getText();
    }


    public String getContinueDescriptionUnpaidVacation() {
        return $(CONTINUE_DESCRIPTION_UNPAID_VACATION).getText();
    }


    public boolean isLinkHomeUnpaidVacation() {
        boolean correct;
        correct = $(LINK_DESCRIPTION_UNPAID_VACATION).getText().contains("Home");
        if (correct) {
            correct = $(LINK_DESCRIPTION_UNPAID_VACATION).getAttribute("href").contains("https://rmsys.issoft.by");
        }
        return correct;
    }


    public String getLinkUnpaidVacation() {
        return $(CONTINUE_DESCRIPTION_UNPAID_VACATION).getText();
    }


    public String getDescriptionUnpaidVacation() {
        return $(DESCRIPTION_UNPAID_VACATION).getText();
    }


    public String getHeaderUnpaidVacation() {
        return $(HEADER_UNPAID_VACATION).getText();
    }


    public String getRuleSectionHeader() {
        return $(RULE_SECTION_HEADER).getText();
    }


    public String getCountRuleDescriptionCommandItem() {
        ElementsCollection records = $$(RULE_DESCRIPTION_COMMAND_ITEM);
        return Integer.toString(records.size());
    }


    public boolean isVisibleDescriptionCommandItems() {
        ElementsCollection records = $$(RULE_DESCRIPTION_COMMAND_ITEM);
        int i = 0;
        boolean correct = true;
        for (SelenideElement record : records) {
            i++;
            if (correct) {
                switch (i) {
                    case 1:
                        correct = $(record).getText().contains("Сотрудникам предоставляется трудовой (оплачиваемый) отпуск");
                        break;
                    case 2:
                        correct = $(record).getText().contains("Сотрудники также вправе брать неоплачиваемые отпуска");
                        break;
                    case 3:
                        correct = $(record).getText().contains("Рекомендуемой практикой в компании является использование 10 дней");
                        break;
                    case 4:
                        correct = $(record).getText().contains("За каждый неиспользованный день трудового отпуска сотруднику полагается компенсация");
                        break;
                    case 5:
                        correct = $(record).getText().contains("Запрос на трудовой отпуск сотрудник должен отправлять как минимум за 10 рабочих дней");
                        break;
                    case 6:
                        correct = $(record).getText().contains("Перед уходом в отпуск сотруднику необходимо заполнить");
                        if (correct) {
                            correct = $(record).$("a").getAttribute("href").contains("rules/time");
                        }
                        break;
                    case 7:
                        correct = $(record).getText().contains("Сотрудник не имеет право уйти в отпуск (оплачиваемый или неоплачиваемый), пока соответствующая информация");
                        if (correct) {
                            correct = $(record).$("a").getAttribute("href").contains("https://rmsys.issoft.by/VacationRequest");
                        }
                        break;
                    default:
                        ;
                        break;
                }
            } else {
                break;
            }
        }
        return correct;
    }


    public SelenideElement getRuleColumn1() { return $(RULE_COLUMN1); }


    public SelenideElement getRuleColumn2() { return $(RULE_COLUMN2); }


    public SelenideElement getRuleColumn3() { return $(RULE_COLUMN3); }


    public SelenideElement getWarningWrapper() { return $(WARNING_WRAPPER); }


    public String getCountRulesStep() {
        ElementsCollection records = $$(RULE_STEPS_WORK_HOURS);
        return Integer.toString(records.size());
    }


    public SelenideElement getRuleStep1() { return $(RULE_STEP1); }


    public SelenideElement getRuleStep2() { return $(RULE_STEP2); }


    public SelenideElement getRuleStep3() { return $(RULE_STEP3); }


    public SelenideElement getRuleStep4() { return $(RULE_STEP4); }


    public SelenideElement getRuleStep5() { return $(RULE_STEP5); }


    public SelenideElement getRuleStep6() { return $(RULE_STEP6); }


    public boolean isVisibleColumnsCollection() {
        ElementsCollection records = $$(RULE_QUESTIONS_COLUMNS_COLLECTION);
        String ruleLitters[] = { "A-I", "K-P", "R-Z" };
        String fullNames[] = { "Екатерина Лубенько", "Наталья Рачкова", "Виктория Статкевич" };
        int size = records.size();
        int i = 0;
        String litters;
        boolean correct = true;
        for (SelenideElement record : records) {

            LOGGER.info("Number of record = " + i);
            getBody().sendKeys(Keys.PAGE_DOWN);
            sleep(2000);

            if (!record.$("h1").getText().contentEquals(ruleLitters[i])) {
                return false;
            }

            if (!record.$(".person-data img").isDisplayed()) {
                return false;
            }

            if (!record.$(".skype-icon").isDisplayed()) {
                return false;
            }

            if (!record.$(".person-data h3").getText().contentEquals(fullNames[i])) {
                return false;
            }

            if (!record.$(".person-data a").getAttribute("href").contains("skype:")) {
                return false;
            }
            i++;
        }

        return true;
    }


    public SelenideElement getRuleQuestionsColumns() { return $(RULE_QUESTIONS_COLUMNS); }


    public String getRuleQuestionsHeader() { return $(RULE_QUESTIONS_HEADER).getText(); }


    public String getRuleQuestionsDescription() { return $(RULE_QUESTIONS).$("p").getText(); }


    public SelenideElement getRuleQuestionsBlock() { return $(RULE_QUESTIONS); }


    public String getCountAttentionRules() {
        ElementsCollection records = $$(ATTENTION_RULES_LIST);
        return Integer.toString(records.size());
    }


    public boolean isAttentionRulesCorrect() {
        ElementsCollection records = $$(ATTENTION_RULES_LIST);
        int i = 0;
        boolean correct = true;
        for (SelenideElement record : records) {
            i++;
            if (correct) {
                switch (i) {
                    case 1:
                        correct = $(record).getText().contains("Оставляйте обувь у входа;");
                        break;
                    case 2:
                        correct = $(record).getText().contains("Используйте воду рационально");
                        break;
                    case 3:
                        correct = $(record).getText().contains("Просьба не использовать более 1 корпоративного полотенца");
                        break;
                    case 4:
                        break;
                    case 5:
                        correct = $(record).getText().contains("Не забудьте перед уходом проверить, выключили ли вы воду и свет");
                        break;
                    default:
                        ;
                        break;
                }
            } else {
                break;
            }
        }
        return correct;
    }


    public boolean isEquelTo9InstructionSteps() {
        ElementsCollection records = $$(RULE_STEPS_WORK_HOURS);
        int size = records.size();
        if (size == 9) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isVisibleInstructionSteps() {
        ElementsCollection records = $$(RULE_STEPS_WORK_HOURS);
        int size = records.size();
        int i = 0;
        boolean correct = true;
        for (SelenideElement record : records) {
            i++;
            correct = record.$(".rule-number").getText().contains("0" + String.valueOf(i));
            if (!record.$(".rule-number").getText().contains("0" + String.valueOf(i))) {
                return false;
            }
            if (record.$(".rule-header").getText().length() < 10) {
                return false;
            }
            if (!record.$("img").isDisplayed()) {
                return false;
            }
        }

        return true;
    }


    public String getRuleHeaderDescription() { return $(RULE_HEADER_DESCRIPTION).getText(); }


    public boolean isActiveRuleHeaderDescriptionLink(String href) {
        return $(RULE_HEADER_DESCRIPTION).$("a").getAttribute("href").contains(href);
    }


    public SelenideElement getRuleHeaderDescriptionBlock() { return $(RULE_HEADER_DESCRIPTION); }


    public SelenideElement getMenubarHeaderText() { return $(MENUBAR_HEADER_TEXT); }


    public SelenideElement getDaySchedule() { return $(DAY_SCHEDULE); }


    public SelenideElement getIconDaySchedule() { return $(SCHEDULE_ICON); }


    public String getFirstItemTitle() { return $(FIRST_ITEM_TITLE).getText(); }


    public String getItemTitle() { return $(ITEM_TITLE).getText(); }


    public SelenideElement getAccordingWorkHours() { return $(WORK_HOURS); }


    public SelenideElement getAccordingWorkHoursLink() { return $(WORK_HOURS_LINK); }


    public SelenideElement getWorkHoursIcon() { return $(WORK_HOURS_ICON); }


    public SelenideElement getGroupManager() { return $(GROUP_MANAGER); }


    public SelenideElement getGroupManagerIcon() { return $(GROUP_MANAGER_ICON); }


    public SelenideElement getDinnerItem() { return $(DINNER); }


    public SelenideElement getDinnerItemIcon() { return $(DINNER_ICON); }


    public SelenideElement getRelaxItem() { return $(RELAX); }


    public SelenideElement getRelaxItemIcon() { return $(RELAX_ICON); }


    public SelenideElement getInternetItem() { return $(INTERNET); }


    public SelenideElement getInternetItemIcon() { return $(INTERNET_ICON); }


    public SelenideElement getPrinterItem() { return $(PRINTERS); }


    public SelenideElement getPrinterItemIcon() { return $(PRINTERS_ICON); }


    public SelenideElement getVacationItem() { return $(VACATION); }


    public SelenideElement getVacationItemIcon() { return $(VACATION_ICON); }


    public SelenideElement getAccountingItem() { return $(ACCOUNTING); }


    public SelenideElement getLinkHelpDesk() {
        return $(INTRODUCTION_PART).$(LINK_HELPDESK);
    }


    public SelenideElement getAccountingItemIcon() { return $(ACCOUNTING_ICON); }


    public SelenideElement getSupportItem() { return $(SUPPORT); }


    public SelenideElement getSupportItemIcon() { return $(SUPPORT_ICON); }


    public boolean isVisibleDaysScheduledInformation() {
        boolean correct = true;
        String scheduleHeader[] = { "Официальное рабочее время — с 10:00 до 18:30",
                "На обеденный перерыв отводится 30 минут в течение дня",
                "Находиться в офисе можно в период с 8:00 до 23:00",
                "В выходные дни работник может попасть в офис только по предварительному списку" };
        int i = 0;
        getBody().sendKeys(Keys.PAGE_DOWN);
        sleep(1000);
        ElementsCollection records = $$(DAYS_SCHEDULE);
        for (SelenideElement record : records) {
            i++;
            if (correct) {
                switch (i) {
                    case 1:
                        correct = $(record).$(RULE_NUMBER).getText().contains("01");
                        if (!correct) {
                            break;
                        }
                        correct = $(record).$(RULE_HEADER).getText().contains(scheduleHeader[i - 1]);
                        if (!correct) {
                            break;
                        }
                        correct = $(record).$(RULE_DESCRIPTION).getText().contains("В летнее время график работы осуществляется");
                        break;
                    case 2:
                        correct = $(record).$(RULE_NUMBER).getText().contains("02");
                        if (!correct) {
                            break;
                        }
                        correct = $(record).$(RULE_HEADER).getText().contains(scheduleHeader[i - 1]);
                        if (!correct) {
                            break;
                        }
                        correct = $(record).$(RULE_DESCRIPTION).getText().contains("Для обеда сотрудник может использовать");
                        break;
                    case 3:
                        correct = $(record).$(RULE_NUMBER).getText().contains("03");
                        if (!correct) {
                            break;
                        }
                        correct = $(record).$(RULE_HEADER).getText().contains(scheduleHeader[i - 1]);
                        if (!correct) {
                            break;
                        }
                        correct = $(record).$(RULE_DESCRIPTION).getText().contains("в выходные допускается с письменного разрешения Team Lead");
                        break;
                    case 4:
                        correct = $(record).$(RULE_NUMBER).getText().contains("04");
                        if (!correct) {
                            break;
                        }
                        correct = $(record).$(RULE_HEADER).getText().contains(scheduleHeader[i - 1]);
                        if (!correct) {
                            break;
                        }
                        correct = $(record).$(RULE_DESCRIPTION).getText().contains("по предъявлению удостоверения личности");
                        break;
                    default:
                        ;
                        break;
                }
            }
        }
        return correct;
    }
}


