package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercise;
import utilities.ConfigReader;
import utilities.Driver;

public class DogruSifreGirisveKullaniciSilme {
    @Test
    public void test01() {
        AutoExercise autoExercise = new AutoExercise();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        //4. Click on 'Signup / Login' button
        autoExercise.signInLinki.click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(autoExercise.LTYATexti.isDisplayed());
        //6. Enter correct email address and password
        //7. Click 'login' button
        Driver.getDriver().findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("aliy12@veli.com" + Keys.TAB + "12345" + Keys.TAB + Keys.ENTER);
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//b")).isDisplayed());
        //9. Click 'Delete Account' button
        Driver.getDriver().findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        Driver.closeDriver();
    }
}
