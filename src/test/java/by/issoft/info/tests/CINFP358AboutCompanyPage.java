package by.issoft.info.tests;

import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.AboutCompanyPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CINFP358AboutCompanyPage extends BaseTest {
    private static AboutCompanyPage aboutCompanyPage;


    @BeforeClass
    public void openPage() {
        aboutCompanyPage = open(AboutCompanyPage.URL, AboutCompanyPage.class);
    }


    @Test()
    public void verifyPageHeader() {
        Assert.assertTrue(aboutCompanyPage.getHeaderLogo().isDisplayed(), "Page Header is wrong");
    }


    @Test()
    public void verifyArticleHeaderPhoto() {
        Assert.assertTrue(aboutCompanyPage.getArticleHeaderPhoto().isDisplayed(),
                "Article Header Photo is absent");
    }


    @Test()
    public void verifyArticleHeaderText() {
        Assert.assertEquals(aboutCompanyPage.getArticleHeader().getText(), "ISsoft – искусство создавать софт",
                "Article Header Text is wrong");
    }


    @Test()
    public void verifyArticleContent() {
        Assert.assertEquals(aboutCompanyPage.getArticleContent().getText(), "Наши услуги:",
                "Content is wrong");
    }


    @Test()
    public void verifyArticleChart() {
        Assert.assertTrue(aboutCompanyPage.getArticleChart().isDisplayed(), "Article Chart is not displayed");
    }
}
