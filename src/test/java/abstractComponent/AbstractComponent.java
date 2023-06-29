package abstractComponent;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
//    constructor
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeClickable(WebElement elemnt){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.elementToBeClickable(elemnt));
    }






}
