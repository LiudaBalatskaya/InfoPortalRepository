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

public class IssoftAdminPage extends CommonPage {
    public static final String URL = "/team/issoft-admin-chart";

    public static final By BODY_PAGE = By.cssSelector("ip-issoft-admin-chart ");
    protected static final By DEPARTMENTS = By.cssSelector(".person-description");

    protected static final List<String> DEPARTMENT_NAME = Arrays.asList("ISsoft General Management",
            "President",
            "Chief Technology Officer",
            "Operations Center",
            "Innovation Center",
            "Sales",
            "IT Director",
            "Information Security Group",
            "Process Engineer",
            "Sales Department",
            "IT Department",
            "Office Management",
            "Personnel Office",
            "Facilities & Special Projects",
            "IT Purchasing",
            "HelpDesk",
            "ISsoft Marketing",
            "Human Resource",
            "Accounting Department",
            "Physical Security"
    );
    protected static final List<String> ISSOFT_ADMIN_FULL_NAME = Arrays.asList("Alexandre Schneerson",
            "Igor Epshteyn",
            "Maksim Belov",
            "TBD",
            "Dmitry Petruchenya",
            "Rob Duff",
            "Maksim Belov",
            "Alexey Evmenkov",
            "Eugen Kapelko",
            "Kirill Mikhailovsky",
            "Sergey Hilevsky",
            "Lena Fominchik",
            "Kira Katonova",
            "Andrey Nikonov",
            "Sergey Smelovsky",
            "Matvey Montvolinsky",
            "Kirill Mikhailovsky",
            "Lena Seredina",
            "Oksana Perepichka",
            "Stanislav Shostak"
    );


    public SelenideElement getBodyPage() {
        return $(BODY_PAGE);
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
        boolean bigBrowser;

        ElementsCollection records = $$(DEPARTMENTS);
        k = records.size();
        LOGGER.info("Size of records = " + k);

        for (SelenideElement record : records) {
            i = i + 1;
            bigBrowser = false;
            LOGGER.info("Number of record = " + i);
            if (i > 5) {
                getBody().sendKeys(Keys.PAGE_DOWN);
                sleep(3000);
            }
            if (i == 6) {
                bigBrowser = true;
            }
            if (i == 10) {
                bigBrowser = true;
            }
            if (i == 14) {
                bigBrowser = true;
            }
            if (i == 20) {
                bigBrowser = true;
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

                        findElement = text.contentEquals(ISSOFT_ADMIN_FULL_NAME.get(i - 1));
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
                    if (ISSOFT_ADMIN_FULL_NAME.get(i - 1).length() > 3) {
                        if (!bigBrowser) {
                            toDepartmentItem = ".person-description" + ":nth-child(" + Integer.toString(i) + ") a";
                            if (i == 1) {
                                switchToIndividualPage();
                            } else {
                                switchToIndividualPages();
                            }
                            IndividualPage individualPage = new IndividualPage();
                            text = $(individualPage.FULL_NAME).getText();
                            findElement = text.contentEquals(individualPage.RMSYS_FULLNAME_ISSOFT_ADMIN.get(i - 1));
                            getWebDriver().switchTo().window(winHandlePage);
                        }
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
        $(By.cssSelector(toDepartmentItem)).click();
        sleep(3000);
        Object[] allWindows = driver.getWindowHandles().toArray();
        String linkWindow = "" + allWindows[allWindows.length - 1];
        driver.switchTo().window(linkWindow);
        sleep(2000);
    }
}
