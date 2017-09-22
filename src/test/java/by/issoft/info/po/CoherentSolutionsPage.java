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

import java.util.Arrays;
import java.util.List;

public class CoherentSolutionsPage extends CommonPage {
    public static final String URL = "/team/coherent-accountability";

    public static final By BODY_PAGE = By.cssSelector("ip-coherent-accountability ");
    public static final By COHERENT_DEPARTMENTS = By.cssSelector(".person-description");


    public SelenideElement getBodyPage() {
        return $(BODY_PAGE);
    }


    protected static final List<String> DEPARTMENT_NAME = Arrays.asList("Development Center (ISsoft)",
            "President",
            "Strategic Account Management",
            "Sales",
            "Chief Technology Officer",
            "Chief Operation Officer",
            "Finance/Admin/HR",
            "Marketing",
            "Lead Generation",
            "Business Development",
            "Healthcare Practice",
            "IOffice Admin/HR",
            "Marketing Implementation",
            "Tech Sales Support & Solutioning",
            "IT Infrastructure",
            "Technology Partnerships",
            "Delivery Management",
            "Technical Practices",
            "Billable Consultants"
    );

    protected static final List<String> FULL_NAME = Arrays.asList("Alexandre Schneerson",
            "Igor Epshteyn",
            "Mike Kittock",
            "Rob Duff",
            "Maksim Belov",
            "Rob Duff",
            "Dan Schneider",
            "Rob Duff",
            "",
            "Jay Syverson",
            "Jay Syverson",
            "Amy Wollberg",
            "Julia Gordeeva",
            "",
            "Maksim Belov",
            "Maksim Belov",
            "",
            "",
            ""
    );


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
        driver = getWebDriver();
        if (!isVisibleInformation("link")) {
            return false;
        }
        return true;
    }


    public boolean isVisibleInformation(String visibleElement) {

        int i = 0, k;
        boolean findElement = true;
        String text = "";
        By department;

        ElementsCollection records = $$(COHERENT_DEPARTMENTS);
        k = records.size();
        LOGGER.info("Size of records = " + k);

        for (SelenideElement record : records) {
            i = i + 1;
            LOGGER.info("Number of record = " + i);
            if (i > 2) {
                getBody().sendKeys(Keys.PAGE_DOWN);
                sleep(2000);
            }
            switch (visibleElement) {
                case "departmentName":
                    toDepartmentItem = ".person-description" + ":nth-child(" + Integer.toString(i) + ") h3";
                    department = By.cssSelector(toDepartmentItem);
                    text = $(department).getText();
                    if (text.isEmpty()) {
                        findElement = false;
                    } else {

                        findElement = text.contentEquals(DEPARTMENT_NAME.get(i - 1));
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

                        findElement = text.contentEquals(FULL_NAME.get(i - 1));
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
                    if (FULL_NAME.get(i - 1).length() > 2) {
                        if (i == 1) {
                            switchToIndividualPage();
                        } else {
                            switchToIndividualPages();
                        }

                        IndividualPage individualPage = new IndividualPage();
                        text = $(individualPage.FULL_NAME).getText();
                        findElement = text.contentEquals(individualPage.RMSYS_FULLNAME_COHERENT_SOLITIONS.get(i - 1));
                        getWebDriver().switchTo().window(winHandlePage);
                        sleep(2000);
                    }
                    ;
                    break;
            }
        }
        return findElement;
    }


    public void switchToIndividualPage() {
        winHandlePage = driver.getWindowHandle();
        String currentURL = driver.getCurrentUrl();
        $(By.cssSelector(toDepartmentItem)).click();
        Object[] allWindows = driver.getWindowHandles().toArray();
        String linkWindow = "" + allWindows[1];
        driver.switchTo().window(linkWindow);
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        sleep(2000);
    }


    public void switchToIndividualPages() {
        winHandlePage = driver.getWindowHandle();
        String currentURL = driver.getCurrentUrl();
        $(By.cssSelector(toDepartmentItem)).click();
        sleep(4000);
        Object[] allWindows = driver.getWindowHandles().toArray();
        String linkWindow = "" + allWindows[allWindows.length - 1];
        driver.switchTo().window(linkWindow);
        sleep(2000);
    }
}
