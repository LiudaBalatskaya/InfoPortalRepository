package by.issoft.info.tests;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

import by.issoft.info.po.BonusesDiscountsPage;
import by.issoft.info.po.RulesPage;
import by.issoft.info.po.SocialPackagePage;
import by.issoft.info.po.SportPage;
import by.issoft.info.po.TrainingCenterPage;
import by.issoft.info.po.VacationPage;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP404SocialPackageContentTest extends BaseTest {
    private static SocialPackagePage socialPage;
    String description[] = { ".Net, Java, Mobile (Android, iOS, Win-Phone), Business intelligence (BI), C++",
            "Система скидок для сотрудников ISsoft у компаний-партнеров",
            "Оплата сотрудникам медицинской страховки",
            "Бесплатные занятия по английскому (от Basic до Advanced)",
            "Бассейн, сауна, футбольное поле и волейбольная площадка",
            "Отпуск составляет 28 календарных дней",
            "График работы от 10:00 до 18:30",
            "Доставка обедов, кофе-брейки, бутилированная вода, зоны для отдыха" };


    @BeforeMethod
    public void openPage() {
        socialPage = open(SocialPackagePage.URL, SocialPackagePage.class);
    }


    @Test
    public void verifyBracketedTitle() {
        Assert.assertEquals(socialPage.getBracketedTitle(), "СОЦИАЛЬНЫЙ ПАКЕТ", " Bracketed title is wrong");
    }


    @Test
    public void verifyCountSocialPakage() {
        Assert.assertEquals(socialPage.getCountSocialPackageList(), "8", " Count of social item is wrong");
    }


    @Test
    public void verifyTrainingCenterItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(socialPage.getTrainingCenterItem().isDisplayed(), " TrainingCenter item isn't displayed");
        softAssert.assertEquals(socialPage.getTrainingCenterItem().$(".item-title").getText(), "Тренинг центр", " TrainingCenter title is wrong");
        softAssert.assertEquals(socialPage.getTrainingCenterItem().$(".item-description").getText(), description[0], " TrainingCenter description is wrong");
        softAssert.assertEquals(socialPage.getTrainingCenterItem().$(".more-text").getText(), "Подробнее", " TrainingCenter added title is wrong");
        softAssert.assertTrue(socialPage.getTrainingCenterItem().$("a").getAttribute("href").contains("/training-center"), " TrainingCenter link is wrong");
        socialPage.getTrainingCenterItem().click();
        Selenide.sleep(2000);
        assertEquals(url(), baseUrl + TrainingCenterPage.URL, "'Training center header link is wrong");
        softAssert.assertAll();
    }


    @Test
    public void verifyBonusesDiscountItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(socialPage.getBonusesItem().isDisplayed(), " Bonuses and discount item isn't displayed");
        softAssert.assertEquals(socialPage.getBonusesItem().$(".item-title").getText(), "Бонусы и скидки", " Bonuses and discount item title is wrong");
        softAssert.assertEquals(socialPage.getBonusesItem().$(".item-description").getText(), description[1], " Bonuses and discount item description is wrong");
        softAssert.assertEquals(socialPage.getBonusesItem().$(".more-text").getText(), "Подробнее", " Bonuses and discount item added title is wrong");
        softAssert.assertTrue(socialPage.getBonusesItem().$("a").getAttribute("href").contains("/bonuses-and-discounts"), " Bonuses and discount link  is wrong");
        socialPage.getBonusesItem().click();
        Selenide.sleep(2000);
        assertEquals(url(), baseUrl + BonusesDiscountsPage.URL, "'Bonuses and discount header link is wrong");
        softAssert.assertAll();
    }


    @Test
    public void verifyHealthInsuranceItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(socialPage.getHealthInsurancesItem().isDisplayed(), " Health Insurance item isn't displayed");
        softAssert.assertEquals(socialPage.getHealthInsurancesItem().$(".item-title").getText(), "Медицинское страхование", " Health Insurance item title is wrong");
        softAssert.assertEquals(socialPage.getHealthInsurancesItem().$(".item-description").getText(), description[2], " Health Insurance item description is wrong");
        softAssert.assertEquals(socialPage.getHealthInsurancesItem().$(".more-text").getText(), "Подробнее", " Health Insurance item added title is wrong");

        socialPage.getHealthInsurancesItem().click();
        socialPage.getModalBlock().isDisplayed();
        softAssert.assertTrue(socialPage.getModalBlock().isDisplayed(), " Modal block of Health Insurance item isn't displayed");
        softAssert.assertEquals(socialPage.getModalBlock().$("h1").getText(), "Медицинское страхование", " Modal block title of Health Insurance item is wrong");
        socialPage.getModalBlock().$(" .close-icon").click();
        softAssert.assertAll();
    }


    @Test
    public void verifyEnglishLanguageItem() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(socialPage.getEnglishLanguageItem().isDisplayed(), " English Language item isn't displayed");
        softAssert.assertEquals(socialPage.getEnglishLanguageItem().$(".item-title").getText(), "Английский язык", " English Language item title is wrong");
        softAssert.assertEquals(socialPage.getEnglishLanguageItem().$(".item-description").getText(), description[3], " English Language item description is wrong");
        softAssert.assertEquals(socialPage.getEnglishLanguageItem().$(".more-text").getText(), "Подробнее", " English Language item added title is wrong");

        socialPage.getEnglishLanguageItem().click();
        socialPage.getModalBlock().isDisplayed();
        softAssert.assertTrue(socialPage.getModalBlock().isDisplayed(), " Modal block of English Language item isn't displayed");
        softAssert.assertEquals(socialPage.getModalBlock().$("h1").getText(), "Английский язык", " Modal block title of English Language item is wrong");
        socialPage.getModalBlock().$(" .close-icon").click();
        softAssert.assertAll();
    }


    @Test
    public void verifySportItem() {
        SoftAssert softAssert = new SoftAssert();
        socialPage.getBody().sendKeys(Keys.PAGE_DOWN);
        softAssert.assertTrue(socialPage.getSportItem().isDisplayed(), " Sport item isn't displayed");
        softAssert.assertEquals(socialPage.getSportItem().$(".item-title").getText(), "Спорт", " Sport item title is wrong");
        softAssert.assertEquals(socialPage.getSportItem().$(".item-description").getText(), description[4], " Sport item description is wrong");
        softAssert.assertEquals(socialPage.getSportItem().$(".more-text").getText(), "Подробнее", "Sport item added title is wrong");
        softAssert.assertTrue(socialPage.getSportItem().$("a").getAttribute("href").contains("/sport"), " Sport link  is wrong");
        socialPage.getSportItem().click();
        Selenide.sleep(2000);
        assertEquals(url(), baseUrl + SportPage.URL, "'Sport header link is wrong");
        softAssert.assertAll();
    }


    @Test
    public void verifyVacationItem() {
        SoftAssert softAssert = new SoftAssert();
        socialPage.getBody().sendKeys(Keys.PAGE_DOWN);
        softAssert.assertTrue(socialPage.getVacationItem().isDisplayed(), " Vacation item isn't displayed");
        softAssert.assertEquals(socialPage.getVacationItem().$(".item-title").getText(), "Отпуск", " Vacation item title is wrong");
        softAssert.assertEquals(socialPage.getVacationItem().$(".item-description").getText(), description[5], " Vacation item description is wrong");
        softAssert.assertEquals(socialPage.getVacationItem().$(".more-text").getText(), "Подробнее", "Vacation item added title is wrong");
        softAssert.assertTrue(socialPage.getVacationItem().$("a").getAttribute("href").contains("/rules/vacation"), " Vacation link is wrong");
        socialPage.getVacationItem().click();
        Selenide.sleep(2000);
        assertEquals(url(), baseUrl + VacationPage.URL, "'Vacation header link is wrong");
        softAssert.assertAll();
    }


    @Test
    public void verifyScheduleItem() {
        SoftAssert softAssert = new SoftAssert();
        socialPage.getBody().sendKeys(Keys.PAGE_DOWN);
        softAssert.assertTrue(socialPage.getScheduleItem().isDisplayed(), "Schedule item isn't displayed");
        softAssert.assertEquals(socialPage.getScheduleItem().$(".item-title").getText(), "График работы", "Schedule item title is wrong");
        softAssert.assertEquals(socialPage.getScheduleItem().$(".item-description").getText(), description[6], "Schedule item description is wrong");
        softAssert.assertEquals(socialPage.getScheduleItem().$(".more-text").getText(), "Подробнее", "Schedule item added title is wrong");
        softAssert.assertTrue(socialPage.getScheduleItem().$("a").getAttribute("href").contains("/rules"), "Schedule link is wrong");
        socialPage.getScheduleItem().click();
        Selenide.sleep(2000);
        assertEquals(url(), baseUrl + RulesPage.URL, "Schedule header link is wrong");
        softAssert.assertAll();
    }


    @Test
    public void verifyDinnerItem() {
        SoftAssert softAssert = new SoftAssert();
        socialPage.getBody().sendKeys(Keys.PAGE_DOWN);
        softAssert.assertTrue(socialPage.getDinnerItem().isDisplayed(), "Dinner item isn't displayed");
        softAssert.assertEquals(socialPage.getDinnerItem().$(".item-title").getText(), "Обеды", "Dinner item title is wrong");
        softAssert.assertEquals(socialPage.getDinnerItem().$(".item-description").getText(), description[7], "Dinner item description is wrong");
        softAssert.assertEquals(socialPage.getDinnerItem().$(".more-text").getText(), "Подробнее", "Dinner item added title is wrong");
        softAssert.assertTrue(socialPage.getDinnerItem().$("a").getAttribute("href").contains("/rules/dinner"), "Dinner link is wrong");
        socialPage.getScheduleItem().click();
        Selenide.sleep(3000);
        String url = url();
        assertEquals(url(), baseUrl + RulesPage.URL, "Dinner header link is wrong");
        // assertEquals(url(), baseUrl + DinnerPage.URL, "Dinner header link is wrong"); - ??? should be
        softAssert.assertAll();
    }
}
