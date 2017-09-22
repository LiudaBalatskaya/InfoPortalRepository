package by.issoft.info.po;


import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class LinkPage {
    public static final String URL = "https://rmsys.issoft.by/Individual/Index#id-383a7cbc-ec61-4f63-90c0-7e946d63fb61";

    protected static final By FULL_NAME = By.xpath("//a[text()='Schneerson, Alexandre']");


    public SelenideElement getFullName() {
        return $(FULL_NAME);
    }
}