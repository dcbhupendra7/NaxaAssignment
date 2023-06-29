package pageObject.site;

import abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.dashboard.Dashboard;

public class Site extends AbstractComponent {
    WebDriver driver;
    Dashboard dashboard;
    public Site(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="a[href*='#/sites']")
    WebElement sitesOption;

    @FindBy(xpath = "//a[text()='Parent Site'][1]")
    WebElement sites;

    public void clickOnSites(){
        waitForElementToBeClickable(sitesOption);
        sitesOption.click();
    }
    public Dashboard selectSite(){
        waitForElementToBeClickable(sites);
        sites.click();
        dashboard=new Dashboard(driver);
        return dashboard;
    }

}
