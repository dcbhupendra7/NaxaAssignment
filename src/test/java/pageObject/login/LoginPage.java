package pageObject.login;

import abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObject.projects.Projects;

public class LoginPage extends AbstractComponent {
    WebDriver driver;
    Projects projects;

    //constructor to initiate driver and page factory
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@name='email_or_username']")
    WebElement usernameElement;

    @FindBy(css = "input[name='password']")
    WebElement passwordElement;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public void url() {
        driver.get("https://zite.zite.io/");
    }

    public void loginToApplication(String email, String password){
        usernameElement.sendKeys(email);
        passwordElement.sendKeys(password);
    }
    public Projects clickLoginButton(){
        loginButton.click();
        projects= new Projects(driver);
        return projects;
    }
}
