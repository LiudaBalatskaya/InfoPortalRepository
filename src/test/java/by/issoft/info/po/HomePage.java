package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import by.issoft.info.store.Const;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class HomePage {
    private static final String URL = "/";

    private static final By LOGO = By.xpath("//img[@class='issoft-logo']");
    private static final By ABOUT_COMPANY_MENU = By.xpath("//a[text()='О компании']");


    public static String getUrl() {
        return Const.BASE_URL + URL;
    }


    public SelenideElement getLogo() {
        return $(LOGO);
    }


    public SelenideElement getAboutCompanyMenu() {
        return $(ABOUT_COMPANY_MENU);
    }



}
