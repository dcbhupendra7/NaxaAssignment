package baseClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import pageObject.dashboard.Dashboard;
import pageObject.form.Form;
import pageObject.login.LoginPage;
import pageObject.projects.Projects;
import pageObject.site.Site;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;


public class BaseClass {
    WebDriver driver;
    public LoginPage loginPage;
    public Projects projects;
    public Site site;
   public Dashboard dashboard;
    public Form form;

    public WebDriver initializeDriver()  {
        driver = new ChromeDriver();
        return driver;
    }
    @BeforeTest(alwaysRun = true)
    public LoginPage gotoWebsite() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.url();
        return loginPage;
    }
    @AfterClass
    public void closeApplication()
    {
        driver.quit();
        Reporter.log("=====Browser Session End=====", true);

    }
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        // read json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        // String to HashMap jackson databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {

                });
        return data;
    }
}
