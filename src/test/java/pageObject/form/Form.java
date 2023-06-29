package pageObject.form;

import abstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Form extends AbstractComponent {
        WebDriver driver;
        public  Form(WebDriver driver){
            super(driver);
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }
        @FindBy(css="a[href*='#/forms']")
        WebElement formsOption;

        @FindBy(css = ".is-between>div>button")
        WebElement createForm;

        @FindBy(id = "name")
        WebElement formName;
        @FindBy(id = "description")
        WebElement formDescription;

        @FindBy(xpath = "//span[text()='Create']")
        WebElement createButton;

        @FindBy(css = ".formBuilder-header__cell--buttonsTopRight>.disabled")
        WebElement deployAndExit;
        public void clickOnForm(){
            waitForElementToBeClickable(formsOption);
            formsOption.click();
        }
        public void clickOnCreateForm(){
            waitForElementToBeClickable(createForm);
            createForm.click();
        }
        public void inputFormnameDescription(String id, String description){
            formName.sendKeys(id);
            formDescription.sendKeys(description);
        }
        public void clickOnCreateButton(){
            createButton.click();
        }

        public void clickOnDeployExit(){
            waitForElementToBeClickable(deployAndExit);
            deployAndExit.click();
        }


}
