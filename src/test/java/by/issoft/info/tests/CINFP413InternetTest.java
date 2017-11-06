package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP413InternetTest extends BaseTest {
    private static RulesPage rulesPage;


    @BeforeMethod
    public void openPage() {

        rulesPage = open(RulesPage.URL, RulesPage.class);
        rulesPage.getInternetItem().click();
    }


    @Test()
    public void verifyGeneralRulesSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getFirstItemTitle(), "Интернет", "Header text of Internet is wrong");
        softAssert.assertTrue(rulesPage.getSectionHeaderInternet().contains("ОБЩИЕ ПРАВИЛА"), "Header <ОБЩИЕ ПРАВИЛА> of Internet section isn't displayed");
        softAssert.assertEquals(rulesPage.getCountRulesSectionInternet(), ("3"), "Count of general rule section is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectRulesSectionInternet(), "General rule section description is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyLicenseSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getLicenseSectionInternet(), "КОММЕРЧЕСКАЯ ЛИЦЕНЗИЯ НА ПО", "Header of license section is wrong");
        softAssert.assertEquals(rulesPage.getCountLicenseSectionInternet(), ("3"), "Count of license section is wrong number");
        softAssert.assertTrue(rulesPage.isVisibleCorrectLicenseSectionInternet(), "License section description is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyOpenSourceSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getOpenSourceHeaderInternet(), "OPEN-SOURCE ПО", "Header of OPEN-SOURCE section is wrong");
        softAssert.assertTrue(rulesPage.getOpenSourceSection().$(".rule-description").getText().contains("Для установки open-source/бесплатных программ"),
                "Description of open-source section is wrong number");
        softAssert.assertTrue(rulesPage.getOpenSourceSection().$("img").isDisplayed(), "Image of open-source section isn't displayed");
        softAssert.assertAll();
    }


    @Test()
    public void verifyCloudServicesSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getCloudServicesSection().isDisplayed(), "Cloud services section isn't displayed");
        softAssert.assertEquals(rulesPage.getCloudServicesSectionHeader(), "ОБЛАЧНЫЕ СЕРВИСЫ", "Header of cloud services section is wrong");
        softAssert.assertTrue(rulesPage.getCloudServicesSection().$("li:first-of-type h3").getText().contains("Разрешённые сервисы для обмена любой ценной"),
                "Left header of cloud services section is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectCustomerPortal(), "Customer portal information is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectProjectPortals(), "Project portals information is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectWebMobile(), "Web and Mobile Mail Access information is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectAtlassianCloud(), "Atlassian Cloud information is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectBitbucket(), "Bitbucket information is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectCoherentSolutionsWebEx(), "Coherent Solutions WebEx information is wrong");

        softAssert.assertTrue(rulesPage.getCloudServicesSection().$("li:last-of-type h3").getText().contains("Разрешённые сервисы для обмена не чувствительной информацией по проекту"),
                "Right header of cloud services section is wrong");
        softAssert.assertTrue(rulesPage.getCloudServicesSection().$("li:last-of-type .rule-description").isDisplayed(), "Right block description of cloud services section is wrong");

        softAssert.assertAll();
    }


    @Test()
    public void verifyDownloadingFilesSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getDownloadingFilesSection().isDisplayed(), "Downloading files section isn't displayed");

        softAssert.assertEquals(rulesPage.getDownloadingFilesSectionHeader(), "СКАЧИВАНИЕ ФАЙЛОВ", "Header of downloading files section is wrong");
        softAssert.assertTrue(rulesPage.getDownloadingFilesDescription1().contains("Скачивание больших объёмов информации (>500 Мb) "),
                "First article description of downloading files section is wrong");
        softAssert.assertTrue(rulesPage.getDownloadingFilesDescription2().contains("При необходимости скачать в рабочее время, "),
                "Second article description of downloading files section is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifySocialNetworksSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().isDisplayed(), "Social networks section isn't displayed");
        softAssert.assertEquals(rulesPage.getSocialNetworksSectionHeader(), "СОЦИАЛЬНЫЕ СЕТИ", "Header of Social networks section is wrong");
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("h3:first-of-type").getText().contains("Facebook, Twitter, Одноклассники, ВКонтакте и др."),
                "Header of first article is wrong");
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("span:first-of-type").getText().contains("Пользоваться социальными сетями в личных целях"),
                "Description of first article is wrong");
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("span:first-of-type a").getText().contains("General Policy"),
                "Link's name of first article is wrong");
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("span:first-of-type a").getAttribute("href").contains("http://practices.issoft.by/issoft-general-policy-2/"),
                "Link of first article is wrong");

        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("h3:nth-of-type(2)").getText().contains("LinkedIn"),
                "Header of second article is wrong");
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("span:nth-of-type(2)").getText().contains("Использование LinkedIn в личных и профессиональных целях"),
                "Description of second article is wrong");

        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("h3:last-of-type").getText().contains("Yammer"),
                "Header of last article is wrong");
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("span:last-of-type").getText().contains("Социальная сеть Yammer является официальной платформой"),
                "Description of last article is wrong");
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("span:last-of-type a").getText().contains("Yammer Acceptable Use Policies"),
                "Link's name  of last article is wrong");
        softAssert.assertTrue(rulesPage.getSocialNetworksSection().$("span:last-of-type a").getAttribute("href").contains("https://www.yammer.com/coherentsolutions.com"),
                "Link of last article is wrong");

        softAssert.assertAll();
    }

    @Test()
    public void verifyAttentionSections() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getAttentionAccounting().isDisplayed(), "Attention sections are't displayed");
        softAssert.assertEquals(rulesPage.getCountAttentionSection(), "3", "Count of Attention's sections is wrong number");
        softAssert.assertTrue(rulesPage.getAttentionSection1().isDisplayed(), "Attention section 1 isn't displayed");
        softAssert.assertTrue(rulesPage.getAttentionSection1().$("span").getText().contains("Пользоваться нелицензионным ПО категорически запрещено"),
                "Description of attention sections 1 is wrong");

        softAssert.assertTrue(rulesPage.getAttentionSection2().isDisplayed(), " Second attention section isn't displayed");
        softAssert.assertTrue(rulesPage.getAttentionSection2().$("span").getText().contains("По каждому сотруднику ведутся логи пользования интернетом"),
                "Description of attention sections 2 is wrong");
        softAssert.assertTrue(rulesPage.getAttentionSection3().isDisplayed(), "The third attention sections isn't displayed");
        softAssert.assertTrue(rulesPage.isDescriptionAttentionSection3(), "Description of attention sections 3 is wrong");
        softAssert.assertAll();
    }
}
