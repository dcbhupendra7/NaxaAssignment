package pageObject.projects;

import abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.site.Site;

public class Projects extends AbstractComponent {
    WebDriver driver;
    Site site;
    //constructor to initiate driver and page factory
    public Projects(WebDriver driver) {
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css="a[href*='#/projects']")
    WebElement projetsOption;

    @FindBy(css = ".org")
    WebElement projects;

    public void clickOnProjcts(){
        waitForElementToBeClickable(projetsOption);
        projetsOption.click();
    }
    public Site selectProject(){
        waitForElementToBeClickable(projects);
        projects.click();
        site=new Site(driver);
        return site;
    }
}
