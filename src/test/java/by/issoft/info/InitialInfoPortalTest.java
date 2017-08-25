package by.issoft.info;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;
import org.openqa.selenium.By;

public class InitialInfoPortalTest {

    @Test
    public void initTestMethod() throws Exception {
        open("http://info.issoft.by");
        $(By.xpath("//a[text()='О компании']")).click();
    }
}
