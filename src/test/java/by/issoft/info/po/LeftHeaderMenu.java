package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class LeftHeaderMenu {
    private static final By MENU = By.xpath("//ul[@class='tooltip-list']");
    private static final By GALLERY_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/media']");
    private static final By GALLERY_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/media']/i[@class='icon']");
    private static final By TRAINING_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/training-center']");
    private static final By TRAINING_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/training-center']/i[@class='icon']");


    public boolean isMenuDisplayed() {
        return $(MENU).isDisplayed();
    }


    public SelenideElement getGalleryIcon() {
        return $(GALLERY_ICON);
    }


    public SelenideElement getGalleryLink() {
        return $(GALLERY_LINK);
    }


    public SelenideElement getTrainingIcon() {
        return $(TRAINING_ICON);
    }


    public SelenideElement getTrainingLink() {
        return $(TRAINING_LINK);
    }
}
