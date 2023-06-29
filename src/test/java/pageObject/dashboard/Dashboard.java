package pageObject.dashboard;

import abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.form.Form;

public class Dashboard extends AbstractComponent {
    WebDriver driver;
    Form form;
    public Dashboard(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css="a[href*='#/dashboard']")
    WebElement dashboardOption;


    public Form clickOnDashboard(){
        waitForElementToBeClickable(dashboardOption);
        dashboardOption.click();
        form=new Form(driver);
        return form;
    }
}
