package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercise;
import utilities.ConfigReader;
import utilities.Driver;

public class MevcutEmailileKullaniciKayit {
    @Test
    public void test05() {
        AutoExercise autoExercise = new AutoExercise();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(autoExercise.automationExerciseIkonu.isDisplayed());
        //4. Click on 'Signup / Login' button
        autoExercise.signInLinki.click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(autoExercise.NUSTexti.isDisplayed());
        //6. Enter name and already registered email address
        autoExercise.NUSNameBox.sendKeys(ConfigReader.getProperty("aeName"));
        autoExercise.NUSEmailAdressBox.sendKeys(ConfigReader.getProperty("aeEmail"));
        //7. Click 'Signup' button
        autoExercise.NUSLoginButton.click();
        //8. Verify error 'Email Address already exist!' is visible
        String expectedHata="Email Address already exist!";
        Assert.assertTrue(autoExercise.NUSHataText.getText().contains(expectedHata));
        Driver.closeDriver();
    }
}
