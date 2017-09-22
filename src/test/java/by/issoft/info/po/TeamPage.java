package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TeamPage extends CommonPage {
    public static final String URL = "/team/issoft-accountability";

    protected static final By ITEM_ISSOFT_OPERATIONS = By.xpath("//a[text()='Issoft (Operations)']");
    protected static final By ITEM_ISSOFT_ADMIN = By.xpath("//a[text()='Issoft (Admin)']");
    protected static final By ITEM_COHERENT_SOLUTIONS = By.xpath("//a[text()='Coherent Solutions']");

    protected static final By GENERAL_MANAGEMENT = By.cssSelector(".person-description:nth-child(1) h3");
    protected static final By PICTURE_GENERAL_MANAGEMENT = By.cssSelector(".person-description:nth-child(1) img");
    protected static final By LINK_GENERAL_MANAGEMENT = By.cssSelector(".person-description:nth-child(1) a");

    protected static final By DEVELOPMENT_DEPARTMENT = By.cssSelector(".person-description:nth-child(2) h3");
    protected static final By PICTURE_DEVELOPMENT_DEPARTMENT = By.cssSelector(".person-description:nth-child(2) img");
    protected static final By LINK_DEVELOPMENT_DEPARTMENT = By.cssSelector(".person-description:nth-child(2) a");

    protected static final By TRAINING_CENTER = By.cssSelector(".person-description:nth-child(3) h3");
    protected static final By PICTURE_TRAINING_CENTER = By.cssSelector(".person-description:nth-child(3) img");
    protected static final By LINK_TRAINING_CENTER = By.cssSelector(".person-description:nth-child(3) a");

    protected static final By QA_DEPARTMENT = By.cssSelector(".person-description:nth-child(4) h3");
    protected static final By PICTURE_QA_DEPARTMENT = By.cssSelector(".person-description:nth-child(4) img");
    protected static final By LINK_QA_DEPARTMENT = By.cssSelector(".person-description:nth-child(4) a");

    protected static final By PMO = By.cssSelector(".person-description:nth-child(5) h3");
    protected static final By PICTURE_PMO = By.cssSelector(".person-description:nth-child(5) img");
    protected static final By LINK_PMO = By.cssSelector(".person-description:nth-child(5) a");

    protected static final By CAREER_DEVELOPMENT = By.cssSelector(".person-description:nth-child(6) h3");
    protected static final By PICTURE_CAREER_DEVELOPMENT = By.cssSelector(".person-description:nth-child(6) img");
    protected static final By LINK_CAREER_DEVELOPMENT = By.cssSelector(".person-description:nth-child(6) a");

    protected static final By BA_MANAGEMENT = By.cssSelector(".person-description:nth-child(7) h3");
    protected static final By PICTURE_BA_MANAGEMENT = By.cssSelector(".person-description:nth-child(7) img");
    protected static final By LINK_BA_MANAGEMENT = By.cssSelector(".person-description:nth-child(7) a");

    protected static final List<String> DEPARTMENT_NAME = Arrays.asList("Ruby Department",
            "QA Auto Department",
            "UI Design Department",
            "BA Department",
            "UX Department",
            ".NET Department",
            "Java Department",
            "Mobile Department",
            "BI Department",
            "Front-End / Web Department",
            "DevOps Department"
    );
    protected static final List<String> FULL_NAME = Arrays.asList("Roman Kapitonov",
            "Michael Sagalovich",
            "Liuda Ivanova",
            "Alexander Zhevnyak",
            "Petr Tisinevich",
            "Andrei Sidoryk",
            "Dmitry Gorbatenko",
            "Slava Kupreev",
            "Valery Shklenski",
            "Vladimir Yurkevich",
            "Valery Shklenski"
    );
    protected static final By DEPARTMENTS = By.cssSelector(".person-description");


    public SelenideElement getSectionNameGeneralManagement() {
        return $(GENERAL_MANAGEMENT);
    }


    public SelenideElement getPictureGeneralManagement() {
        return $(PICTURE_GENERAL_MANAGEMENT);
    }


    public String getFullNameGeneralManagement() {
        return $(LINK_GENERAL_MANAGEMENT).getText();
    }


    public void getLinkGeneralManagement() {
        switchToIndividualPage(LINK_GENERAL_MANAGEMENT);
    }


    public SelenideElement getSectionNameDevelopmentDepartment() {
        return $(DEVELOPMENT_DEPARTMENT);
    }


    public SelenideElement getPictureDevelopmentDepartment() {
        return $(PICTURE_DEVELOPMENT_DEPARTMENT);
    }


    public String getFullNameDevelopmentDepartment() {
        return $(LINK_DEVELOPMENT_DEPARTMENT).getText();
    }


    public void getLinkDevelopmentDepartment() {
        switchToIndividualPage(LINK_DEVELOPMENT_DEPARTMENT);
    }


    public SelenideElement getSectionNameTrainingCenter() {
        return $(TRAINING_CENTER);
    }


    public SelenideElement getPictureTrainingCenter() {
        return $(PICTURE_TRAINING_CENTER);
    }


    public String getFullNameTrainingCenter() {
        return $(LINK_TRAINING_CENTER).getText();
    }


    public void getLinkTrainingCenter() {
        switchToIndividualPage(LINK_TRAINING_CENTER);
    }


    public SelenideElement getSectionNameQADepartment() {
        return $(QA_DEPARTMENT);
    }


    public SelenideElement getPictureQADepartment() {
        return $(PICTURE_QA_DEPARTMENT);
    }


    public String getFullNameQADepartment() {
        return $(LINK_QA_DEPARTMENT).getText();
    }


    public SelenideElement getSectionPMO() {
        return $(PMO);
    }


    public SelenideElement getPicturePMO() {
        return $(PICTURE_PMO);
    }


    public String getFullNamePMO() {
        return $(LINK_PMO).getText();
    }


    public void getLinkPMO() {
        switchToIndividualPage(LINK_PMO);
    }


    public SelenideElement getSectionNameCareerDevelopment() {
        return $(CAREER_DEVELOPMENT);
    }


    public SelenideElement getPictureCareerDevelopment() {
        return $(PICTURE_CAREER_DEVELOPMENT);
    }


    public String getFullNameCareerDevelopment() {
        return $(LINK_CAREER_DEVELOPMENT).getText();
    }


    public void getLinkCareerDevelopment() {
        switchToIndividualPage(LINK_CAREER_DEVELOPMENT);
    }


    public SelenideElement getSectionNameBAMenegment() {
        return $(BA_MANAGEMENT);
    }


    public SelenideElement getPictureBAManagement() {
        return $(PICTURE_BA_MANAGEMENT);
    }


    public String getFullNameBAManagement() {
        return $(LINK_BA_MANAGEMENT).getText();
    }


    public void getLinkPageBAManagement() {
        switchToIndividualPage(LINK_BA_MANAGEMENT);
    }


    public SelenideElement getItemIssoftOperations() {
        return $(ITEM_ISSOFT_OPERATIONS);
    }


    public SelenideElement getItemIssoftAdmin() {
        return $(ITEM_ISSOFT_ADMIN);
    }


    public void getPageIssoftAdmin() {
        $(ITEM_ISSOFT_ADMIN).click();
    }


    public void getPageCoherentSolutions() {
        $(ITEM_COHERENT_SOLUTIONS).click();
    }


    public SelenideElement getItemCoherentSolutions() {
        return $(ITEM_COHERENT_SOLUTIONS);
    }


    public boolean isActiveItemIssoftOperations() {
        String className = $(ITEM_ISSOFT_OPERATIONS).getAttribute("class");
        if (className.contains("active-link")) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isVisibleDepartmentNames() {
        if (!isVisibleInformation("departmentName")) {
            return false;
        }
        return true;
    }


    public boolean isVisibleDepartmentImages() {
        if (!isVisibleInformation("image")) {
            return false;
        }
        return true;
    }


    public boolean isVisibleDepartmentFullNames() {
        if (!isVisibleInformation("fullName")) {
            return false;
        }
        return true;
    }


    public boolean isActiveLinks() {
        if (!isVisibleInformation("link")) {
            return false;
        }
        return true;
    }


    public boolean isVisibleInformation(String visibleElement) {

        int i = 0, indexName = -1, k;
        boolean findElement = true;
        String toDepartmentItem = "", text = "";
        By department;
        boolean bigScreen;

        ElementsCollection records = $$(DEPARTMENTS);
        k = records.size();

        LOGGER.info("Size of records = " + k);

        for (SelenideElement record : records) {
            i++;
            bigScreen = false;
            LOGGER.info("Number of record = " + i);
            if (i == 1) {
                getBody().sendKeys(Keys.PAGE_DOWN);
                sleep(2000);
            }
            if (i > 7) {
                if ((i == 12) || (i == 18)) {
                    bigScreen = true;
                }
                indexName++;
                switch (visibleElement) {
                    case "departmentName":
                        toDepartmentItem = ".person-description" + ":nth-child(" + Integer.toString(i) + ") h3";
                        department = By.cssSelector(toDepartmentItem);
                        text = $(department).getText();
                        if (text.isEmpty()) {
                            findElement = false;
                        } else {

                            findElement = text.contentEquals(DEPARTMENT_NAME.get(indexName));
                        }
                        ;
                        break;
                    case "fullName":
                        toDepartmentItem = ".person-description" + ":nth-child(" + Integer.toString(i) + ") a";
                        department = By.cssSelector(toDepartmentItem);
                        text = $(department).getText();
                        if (text.isEmpty()) {
                            findElement = false;
                        } else {

                            findElement = text.contentEquals(FULL_NAME.get(indexName));
                        }
                        ;
                        break;
                    case "image":
                        toDepartmentItem = ".person-description" + ":nth-child(" + Integer.toString(i) + ") img";
                        department = By.cssSelector(toDepartmentItem);
                        findElement = $(department).isDisplayed();
                        ;
                        break;
                    case "link":
                        toDepartmentItem = ".person-description" + ":nth-child(" + Integer.toString(i) + ") a";
                        if (!bigScreen) {
                            if (i == 8) {
                                switchToIndividualPage(By.cssSelector(toDepartmentItem));
                            } else {

                                switchToIndividualPages(By.cssSelector(toDepartmentItem));
                            }
                            IndividualPage individualPage = new IndividualPage();
                            text = $(individualPage.FULL_NAME).getText();
                            findElement = text.contentEquals(individualPage.FULLNAME.get(indexName));
                            getWebDriver().switchTo().window(winHandlePage);
                        }
                        ;
                        break;
                }
            }
        }
        return findElement;
    }


    public void switchToIndividualPage(By ELEMENT) {
        WebDriver driver = getWebDriver();
        winHandlePage = driver.getWindowHandle();
        $(ELEMENT).click();
        Object[] allWindows = driver.getWindowHandles().toArray();
        String linkWindow = "" + allWindows[1];
        getWebDriver().switchTo().window(linkWindow);
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        sleep(2000);
    }


    public void switchToIndividualPages(By ELEMENT) {
        WebDriver driver = getWebDriver();
        winHandlePage = driver.getWindowHandle();
        $(ELEMENT).click();
        sleep(3000);
        Object[] allWindows = driver.getWindowHandles().toArray();
        String linkWindow = "" + allWindows[allWindows.length - 1];
        getWebDriver().switchTo().window(linkWindow);
        sleep(2000);
    }
}
