package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class LeftHeaderMenu {
    private static final By MENU = By.xpath("//ul[@class='tooltip-list']");
    private static final By GALLERY_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/media']");
    private static final By GALLERY_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/media']/i[@class='icon']");
    private static final By TRAINING_CENTER_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/training-center']");
    private static final By TRAINING_CENTER_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/training-center']/i[@class='icon']");
    private static final By INNOVATION_CENTER_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/innovation-center']");
    private static final By INNOVATION_CENTER_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/innovation-center']/i[@class='icon']");


    public boolean isMenuDisplayed() {
        return $(MENU).isDisplayed();
    }


    public SelenideElement getGalleryIcon() {
        return $(GALLERY_ICON);
    }


    public SelenideElement getGalleryLink() {
        return $(GALLERY_LINK);
    }


    public SelenideElement getTrainingCenterIcon() {
        return $(TRAINING_CENTER_ICON);
    }


    public SelenideElement getTrainingCenterLink() {
        return $(TRAINING_CENTER_LINK);
    }


    public SelenideElement getInnovationCenterIcon() {
        return $(INNOVATION_CENTER_ICON);
    }


    public SelenideElement getInnovationCenterLink() {
        return $(INNOVATION_CENTER_LINK);
    }
}
