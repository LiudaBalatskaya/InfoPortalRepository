package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class NewsArticlePage extends CommonPage {

    private static final By BANNER_TEXT = By.cssSelector(".banner-text");


    public String getBannerText() {
        return $(BANNER_TEXT).getText();
    }
}
