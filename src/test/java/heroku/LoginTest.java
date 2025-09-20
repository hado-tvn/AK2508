package heroku;

import base.BaseTest;
import heroku.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static common.Browser.*;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @BeforeMethod
    void openPage(){
        loginPage = new LoginPage();
        loginPage.open();
    }

    @DataProvider
    Object[][] testData(){
        return new Object[][]{
                {"tomsmit","SuperSecretPassword!","https://the-internet.herokuapp.com/login","error","Your username is invalid!"},
                {"tomsmith","SuperSecretPassword","https://the-internet.herokuapp.com/login","error","Your password is invalid!"},
        };
    }

    @Test(dataProvider = "testData")
    void withInvalidCredential(String username, String password,String expectedUrl, String expectedMessageType,String expectedMessageContent)  {
        loginPage.login(username,password);
        Assert.assertEquals(getCurrentUrl(),expectedUrl);

        String errorMessage = loginPage.getFlashMessage(expectedMessageType);
        Assert.assertTrue(errorMessage.contains(expectedMessageContent));
    }
}
