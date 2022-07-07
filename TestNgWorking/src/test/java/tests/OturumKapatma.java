package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercise;
import utilities.ConfigReader;
import utilities.Driver;

public class OturumKapatma {
    @Test
    public void test04() {
        AutoExercise autoExercise = new AutoExercise();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(autoExercise.automationExerciseIkonu.isDisplayed());
        //4. Click on 'Signup / Login' button
        autoExercise.signInLinki.click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(autoExercise.LTYATexti.isDisplayed());
        //6. Enter correct email address and password
        autoExercise.LTYAEmailAdress.sendKeys(ConfigReader.getProperty("aeValidEmail"));
        autoExercise.LTYAPassword.sendKeys(ConfigReader.getProperty("aeValidPassword"));
        //7. Click 'login' button
        autoExercise.LTYALoginButton.click();
        //8. Verify that 'Logged in as username' is visible
        String expectedUserName = ConfigReader.getProperty("aeName");
        Assert.assertTrue(autoExercise.loginInAsUsername.getText().contains(expectedUserName));
        //9. Click 'Logout' button
        autoExercise.logout.click();
        //10. Verify that user is navigated to login page
        Assert.assertTrue(autoExercise.LTYATexti.isDisplayed());
        Driver.closeDriver();
    }
}
