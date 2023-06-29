package runner;

import baseClass.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Zite extends BaseClass {

    @Test(dataProvider="getUsernamePassword")
    public void loginToZite(HashMap<String,String> input)   {
        loginPage.loginToApplication(input.get("username"),input.get("password"));
        projects =loginPage.clickLoginButton();
        projects.clickOnProjcts();
        site =projects.selectProject();
        site.clickOnSites();
        dashboard =site.selectSite();
        form=dashboard.clickOnDashboard();
        form.clickOnForm();
        form.clickOnCreateForm();
        }
    @Test(dataProvider = "getFormnameDescription",dependsOnMethods = "loginToZite")
        public void addNewForm(HashMap<String,String> input){
            form.inputFormnameDescription(input.get("name"),input.get("description"));
            form.clickOnCreateButton();
            form.clickOnDeployExit();
        }


    @DataProvider
    public Object[][] getUsernamePassword() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//resources//LoginDetails.json");
        return new Object[][] { { data.get(0) } };
    }
    @DataProvider
    public Object[][] getFormnameDescription() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//resources//FormnameDecriptions.json");
        return new Object[][] { { data.get(0) } };
    }
}
