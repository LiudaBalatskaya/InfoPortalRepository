package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

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
    private static final By SPORT_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/sport']");
    private static final By SPORT_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/sport']/i[@class='icon']");
    private static final By HR_BONUSES_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/hr-bonuses']");
    private static final By HR_BONUSES_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/hr-bonuses']/i[@class='icon']");
    private static final By TEAM_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/team']");
    private static final By TEAM_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/team']/i[@class='icon']");
    private static final By RULES_LINK = By.xpath("//ul[@class='tooltip-list']//a[@href='/rules']");
    private static final By RULES_ICON = By.xpath("//ul[@class='tooltip-list']//a[@href='/rules']/i[@class='icon']");


    public boolean isMenuDisplayed() {
        return $(MENU).isDisplayed();
    }


    public int getQuantityOfMenuItems() {
        return $$(MENU).size();
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


    public SelenideElement getSportIcon() {
        return $(SPORT_ICON);
    }


    public SelenideElement getSportLink() {
        return $(SPORT_LINK);
    }


    public SelenideElement getHrBonusesIcon() {
        return $(HR_BONUSES_ICON);
    }


    public SelenideElement getHrBonusesLink() {
        return $(HR_BONUSES_LINK);
    }


    public SelenideElement getTeamIcon() {
        return $(TEAM_ICON);
    }


    public SelenideElement getTeamLink() {
        return $(TEAM_LINK);
    }


    public SelenideElement getRulesIcon() {
        return $(RULES_ICON);
    }


    public SelenideElement getRulesLink() {
        return $(RULES_LINK);
    }
}
