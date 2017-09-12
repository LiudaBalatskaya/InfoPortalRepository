package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class AboutCompanyPage extends CommonPage {
    public static final String URL = "/about";

    private static final By ARTICLE_HEADER = By.xpath("//h1");
    private static final By ARTICLE_HEADER_PHOTO = By.xpath("//div[@class='header-photo']");
    private static final By ARTICLE_CONTENT = By.xpath("//p[text()='Наши услуги:']");
    private static final By ARTICLE_CHART = By.xpath("//img[@class='growth-chart']");


    public SelenideElement getArticleHeaderPhoto() {
        return $(ARTICLE_HEADER_PHOTO);
    }


    public SelenideElement getArticleHeader() {
        return $(ARTICLE_HEADER);
    }


    public SelenideElement getArticleContent() {
        return $(ARTICLE_CONTENT);
    }


    public SelenideElement getArticleChart() {
        return $(ARTICLE_CHART);
    }
}
