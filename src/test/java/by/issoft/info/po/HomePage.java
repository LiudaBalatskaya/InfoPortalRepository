package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class HomePage {
    public static final String URL = "/";

    private static final By ISSOFT_LOGO = By.xpath("//img[@class='issoft-logo']");
    private static final By COHERENT_LOGO = By.xpath("//img[@class='issoft-coherent-logo']");
    private static final By ABOUT_COMPANY_MENU = By.xpath("//a[text()='О компании']");


    public SelenideElement getISsoftLogo() {
        return $(ISSOFT_LOGO);
    }


    public SelenideElement getCoherentLogo() {
        return $(COHERENT_LOGO);
    }


    public SelenideElement getAboutCompanyMenu() {
        return $(ABOUT_COMPANY_MENU);
    }
}
