package by.issoft.info.po;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class InnovationCenterPage extends CommonPage {
    public static final String URL = "/innovation-center";

    private static final By BOARD_HEADER = By.cssSelector(".kanban-board-header");
    private static final By ACTIVE_PROJECTS = By.cssSelector(".active-projects-wrapper");
    private static final By PRODUCTS_CONTAINER = By.cssSelector(".products-wrapper");
    private static final By OUR_TEAM_CONTAINER = By.cssSelector(".our-team-container");
    private static final By PROPOSAL_CONTAINER = By.cssSelector(".proposal-container");
    private static final By COL_OUTER = By.cssSelector(".col-outer");

    public SelenideElement getBoardHeader() {
                return $(BOARD_HEADER);
    }

    public SelenideElement getActiveProjectsSection() {
        return $(ACTIVE_PROJECTS);
    }

    public SelenideElement getProductsContainerSection() {
        return $(PRODUCTS_CONTAINER);
    }

    public SelenideElement getOurTeamContainerSection() {
        return $(OUR_TEAM_CONTAINER);
    }

    public SelenideElement getProposalSection() {
        return $(PROPOSAL_CONTAINER);
    }

    public SelenideElement getYammerSection() {
        return $(COL_OUTER);
    }
}
