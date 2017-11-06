package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.RulesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CINFP401AccountantDepartmentTest extends BaseTest {
    private static RulesPage rulesPage;


    @BeforeMethod
    public void openPage() {

        rulesPage = open(RulesPage.URL, RulesPage.class);
        rulesPage.getAccountingItem().click();
    }


    @Test()
    public void verifyAccountantBranchContent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getItemTitle(), "Бухгалтерия, отдел кадров, HR", "Accounted header text is wrong");
        softAssert.assertTrue(rulesPage.getRuleHeaderDescription().contains("Всё, что касается справок и официальных документов,"), "Accounted header description is wrong");
        softAssert.assertTrue(rulesPage.getIntroductionPart().isDisplayed(), "Introduction part isn't displayed");
        softAssert.assertTrue(rulesPage.getReference().$(".bold-text").getText().contains("Где можно взять справку?"), "References header is wrong");
        softAssert.assertTrue(rulesPage.getLinkHelpDesk().getText().contains("Заказ справок осуществляется через систему"), "References string before the link is wrong");
        softAssert.assertEquals(rulesPage.getLinkHelpDesk().$("a").getAttribute("href"), "https://helpdesk.issoft.by/", "HelpDesk link is wrong");
        softAssert.assertAll();
    }


    @Test()
    public void verifyAttentionBlock() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getAttentionAccounting().isDisplayed(), "Attention block isn't displayed");
        softAssert.assertEquals(rulesPage.getAttentionAccounting().$(".title-header-text").getText(), "Обратите внимание!", "Attention block's header is wrong");
        softAssert.assertTrue(rulesPage.getAttentionAccounting().$(".warning-description").getText().contains("Во всех официальных документах просьба использовать"), "Attention block text is wrong");
        softAssert.assertEquals(rulesPage.getAttentionAccounting().$(".warning-header").getText(), "БЕЗ СОКРАЩЕНИЙ! (ИПУП, ИУП, ИП)", "Attention block's warning text is wrong");
        softAssert.assertEquals(rulesPage.getCountIssoftNameSection(), "2", "Count of sections is wrong number");
        softAssert.assertTrue(rulesPage.isVisibleCorrectIssoftNameSection(), "Sections in attention block are wrong");
        softAssert.assertAll();
    }


    @Test(groups = "AccountDepartmentSection")
    public void verifyAccountantDepartmentSection() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(rulesPage.getAccountDepartmentSection().isDisplayed(), "Account department section isn't displayed");
        softAssert.assertEquals(rulesPage.getAccountDepartmentSection().$(".section-header").getText(), "БУХГАЛТЕРИЯ", "Header of account department section is wrong");
        softAssert.assertEquals(rulesPage.getAccountDepartmentSection().$(".location-description").getText(), "118-й офис, кабинет \"Бухгалтерия\"", "Place of Office of account department section is wrong");
        softAssert.assertEquals(rulesPage.getAccountDepartmentSection().$(".article-header").getText(), "В обязательном порядке предоставляем:", "Article header of account department section is wrong");
        softAssert.assertEquals(rulesPage.getAccountDepartmentSection().$(".employee-provider li").getText(), "Больничные листы", "Article of account department section is wrong");
        softAssert.assertEquals(rulesPage.getContentSection().$("div~h3").getText(), "В бухгалтерии вы можете получить:", "Content header of account department section is wrong");
        softAssert.assertEquals(rulesPage.getContentSection().$("div~h3+ul li:first-of-type").getText(), "Справки в банк для получения кредита или поручительства", "Content of account department section is wrong");
        softAssert.assertEquals(rulesPage.getContentSection().$("div~h3+ul li:last-of-type").getText(), "Справки для налоговой", "Content of account department section is wrong");
        softAssert.assertEquals(rulesPage.getAccountDepartmentSection().$(".rule-header").getText(), "По всем вопросам обращайтесь к:", "Rule header of account department section is wrong");
        softAssert.assertAll();
    }


    @Test(groups = "AccountDepartmentSection")
    public void verifyPersonAccountantData() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(rulesPage.getCountAccountPersonData(), "2", "Count of person data is wrong number");
        softAssert.assertTrue(rulesPage.isVisiblePersonDatesAccountSection(), "Person data  are wrong");
        softAssert.assertAll();
    }


    @Test(groups = "HumanResourcesSection")
    public void verifyContentHumanResoursesSection() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(rulesPage.getHumanResourceSection().isDisplayed(), "Human resource section isn't displayed");
        softAssert.assertEquals(rulesPage.getHumanResourceSection().$(".section-header").getText(), "ОТДЕЛ КАДРОВ", "Header of human resource section is wrong");
        softAssert.assertEquals(rulesPage.getHumanResourceSection().$(".location-description").getText(), "118-й офис, кабинет \"Office Managers\"", "Place of office of human resource section is wrong");
        softAssert.assertEquals(rulesPage.getHeaderArticleHumanResource(), "В обязательном порядке предоставляем:", "Article header of human resource section is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectArticleHumanResource(), "Article of Human resource section section is wrong");
        softAssert.assertTrue(rulesPage.getHumanResourceProvider().isDisplayed(), "Human resource provider isn't displayed");
        softAssert.assertEquals(rulesPage.getHumanResourceProvider().$(".article-header").getText(), "Отдел кадров, в свою очередь, сможет предоставить вам:", "Provider header of human resource section is wrong");
        softAssert.assertTrue(rulesPage.isVisibleCorrectProviderArticle(), "Provider content of Human resource section is wrong");
        softAssert.assertAll();
    }


    @Test(groups = "HumanResourcesSection")
    public void verifyPersonDataHumanResourcesSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getHumanResourcePersonData().isDisplayed(), "Person dates of human resources section isn't displayed");
        softAssert.assertEquals(rulesPage.getHumanResourcePersonData().$(".rule-header").getText(), "По всем вопросам обращайтесь к:", "Header of person dates of human resources section is wrong");
        softAssert.assertTrue(rulesPage.getHumanResourcePersonData().$("img").isDisplayed(), "Image of person data of human resources section isn't displayed");
        softAssert.assertEquals(rulesPage.getHumanResourcePersonData().$(".person-description h3").getText(), "Кира Катонова", "Name of human resources section is wrong");
        softAssert.assertEquals(rulesPage.getHumanResourcePersonData().$(".person-description .rule-description").getText(), "Начальник отдела кадров", "Rule description of human resources section is wrong");
        softAssert.assertEquals(rulesPage.getHumanResourcePersonData().$(".person-description a").getAttribute("href"), "skype:csi.kirakatonova?add", "Skype of human resources section is wrong");
        softAssert.assertTrue(rulesPage.getHumanResourcePersonData().$(".person-description a img").isDisplayed(), "Skype icon of human resources section isn't displayed");
        softAssert.assertAll();
    }


    @Test(groups = "HRSection")
    public void verifyContentHRSection() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(rulesPage.getHRSection().isDisplayed(), "HR section isn't displayed");
        softAssert.assertEquals(rulesPage.getHRSection().$(".section-header").getText(), "HR", "Header of HR section is wrong");
        softAssert.assertEquals(rulesPage.getHRSection().$(".location-description").getText(), "111-й офис, кабинет \"HR\"", "Place of office of HR section is wrong");
        softAssert.assertEquals(rulesPage.getHRSection().$(".employee-provider>h3").getText(), "К HR можно обращаться по вопросам:", "Article header of HR section is wrong");
        softAssert.assertEquals(rulesPage.getHRSection().$(".employee-provider li:first-of-type").getText(), "Практики", "Article of HR section is wrong");
        softAssert.assertEquals(rulesPage.getHRSection().$(".employee-provider li:last-of-type").getText(), "Распределения студентов", "Article of HR section is wrong");
        softAssert.assertAll();
    }


    @Test(groups = "HRSection")
    public void verifyPersonDataHRSection() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(rulesPage.getPersonDataHRSection().isDisplayed(), "Person dates of HR section isn't displayed");
        softAssert.assertEquals(rulesPage.getPersonDataHRSection().$(".rule-header").getText(), "По всем вопросам обращайтесь к:", "Header of person dates of HR section is wrong");
        softAssert.assertTrue(rulesPage.getPersonDataHRSection().$("img").isDisplayed(), "Person image of HR section isn't displayed");
        softAssert.assertEquals(rulesPage.getPersonDataHRSection().$(".person-description h3").getText(), "Лена Середина", "Person name of HR section is wrong");
        softAssert.assertEquals(rulesPage.getPersonDataHRSection().$(".person-description .rule-description").getText(), "Руководитель отдела управления персоналом", "Rule description of HR section is wrong");
        softAssert.assertEquals(rulesPage.getPersonDataHRSection().$(".person-description a").getAttribute("href"), "skype:csi.lenaseredina?add", "Skype of HR section is wrong");
        softAssert.assertTrue(rulesPage.getPersonDataHRSection().$(".person-description a img").isDisplayed(), "Skype icon of HR section isn't displayed");
        softAssert.assertAll();
    }
}
