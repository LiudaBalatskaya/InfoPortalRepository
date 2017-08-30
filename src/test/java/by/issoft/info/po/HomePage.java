package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class HomePage {

    private static final By logo = By.xpath("//img[@class='issoft-logo']");


    public boolean isLogoDisplayed() {
        return $(logo).isDisplayed();
    }

}
