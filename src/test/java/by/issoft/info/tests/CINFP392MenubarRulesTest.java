package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.HomePage;
import by.issoft.info.po.LeftHeaderMenu;
import by.issoft.info.po.RulesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP392MenubarRulesTest extends BaseTest {
    private static RulesPage rulesPage;
    private static LeftHeaderMenu leftHeaderMenu;


    @BeforeMethod
    public void openPage() {
        rulesPage = open(RulesPage.URL, RulesPage.class);
    }

    @Test()
    public void openLeftHeaderMenu() {
        HomePage homePage = open(HomePage.URL, HomePage.class);
        leftHeaderMenu = homePage.openLeftHeaderMenu();
        leftHeaderMenu.getRulesLink().click();
        rulesPage = new RulesPage();
        Assert.assertEquals(rulesPage.getMenubarHeaderText().getText(), "Как мы работаем?", "Page is wrong");
    }

    @Test()
    public void verifyDayScheduleItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getMenubarHeaderText().getText(), "Как мы работаем?", "Menubar header text is wrong");
        softAssert.assertTrue(rulesPage.getDaySchedule().isDisplayed(), "Day Schedule isn't displayed");
        softAssert.assertTrue(rulesPage.getIconDaySchedule().isDisplayed(), "Day Schedule icon isn't displayed");
        softAssert.assertEquals(rulesPage.getFirstItemTitle(), "Распорядок дня", "Day Schedule Title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyAccordingWorkHoursItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getAccordingWorkHours().isDisplayed(), "According Work Hours item isn't displayed");
        softAssert.assertEquals(rulesPage.getAccordingWorkHours().getText(), "Учёт рабочего времени", "According Work Hours item is wrong");
        softAssert.assertTrue(rulesPage.getWorkHoursIcon().isDisplayed(), "According Work Hours icon isn't displayed");
        rulesPage.getAccordingWorkHours().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Как заполнить свои часы", "According Work Hours title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyGroupManagerItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getGroupManager().isDisplayed(), "Group manager item isn't displayed");
        softAssert.assertEquals(rulesPage.getGroupManager().getText(), "Group Manager", "Group manager item is wrong");
        softAssert.assertTrue(rulesPage.getGroupManagerIcon().isDisplayed(), "Group manager icon isn't displayed");
        rulesPage.getGroupManager().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Group Manager", "Group manager Title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyDinnerItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getDinnerItem().isDisplayed(), "Dinner item isn't displayed");
        softAssert.assertEquals(rulesPage.getDinnerItem().getText(), "Обед", "Dinner item item is wrong");
        softAssert.assertTrue(rulesPage.getDinnerItemIcon().isDisplayed(), "Dinner item icon isn't displayed");
        rulesPage.getDinnerItem().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Как проголосовать за обед", "Dinner item title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyRelaxItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getRelaxItem().isDisplayed(), "Relax item isn't displayed");
        softAssert.assertEquals(rulesPage.getRelaxItem().getText(), "Отдых", "Relax item is wrong");
        softAssert.assertTrue(rulesPage.getRelaxItemIcon().isDisplayed(), "Relax item icon isn't displayed");
        rulesPage.getRelaxItem().click();
        softAssert.assertEquals(rulesPage.getFirstItemTitle(), "Отдых", "Relax item title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyInternetItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getInternetItem().isDisplayed(), "Internet item isn't displayed");
        softAssert.assertEquals(rulesPage.getInternetItem().getText(), "Интернет", "Internet item is wrong");
        softAssert.assertTrue(rulesPage.getInternetItemIcon().isDisplayed(), "Internet item icon isn't displayed");
        rulesPage.getInternetItem().click();
        softAssert.assertEquals(rulesPage.getFirstItemTitle(), "Интернет", "Internet item title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyHardwareEnvironmentItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getPrinterItem().isDisplayed(), " Hardware environment item isn't displayed");
        softAssert.assertEquals(rulesPage.getPrinterItem().getText(), "Принтеры и оборудование", "Hardware environment item is wrong");
        softAssert.assertTrue(rulesPage.getPrinterItemIcon().isDisplayed(), "Hardware environment item icon isn't displayed");
        rulesPage.getPrinterItem().click();
        softAssert.assertEquals(rulesPage.getFirstItemTitle(), "Принтеры и оборудование", "Hardware environment item title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyVacationItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getVacationItem().isDisplayed(), " Vacation item isn't displayed");
        softAssert.assertEquals(rulesPage.getVacationItem().getText(), "Отпуск", "Hardware environment item is wrong");
        softAssert.assertTrue(rulesPage.getVacationItemIcon().isDisplayed(), "Vacation item icon isn't displayed");
        rulesPage.getVacationItem().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Как оформить свой отпуск?", "Vacation item title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyAccountingItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getAccountingItem().isDisplayed(), "Accounting item isn't displayed");
        softAssert.assertEquals(rulesPage.getAccountingItem().getText(), "Бухгалтерия, отдел кадров", "Accounting item is wrong");
        softAssert.assertTrue(rulesPage.getAccountingItemIcon().isDisplayed(), "Accounting item icon isn't displayed");
        rulesPage.getAccountingItem().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Бухгалтерия, отдел кадров, HR", "Accounting item title is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifySupportItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getSupportItem().isDisplayed(), "Support item isn't displayed");
        softAssert.assertEquals(rulesPage.getSupportItem().getText(), "Служба поддержки", "Support item is wrong");
        softAssert.assertTrue(rulesPage.getSupportItemIcon().isDisplayed(), "Support item icon isn't displayed");
        rulesPage.getSupportItem().click();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Служба поддержки", "Support item title is wrong");
        softAssert.assertAll();
    }
}

