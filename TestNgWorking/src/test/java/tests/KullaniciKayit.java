package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercise;
import utilities.ConfigReader;
import utilities.Driver;

public class KullaniciKayit {
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
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(autoExercise.NUSTexti.isDisplayed());
        //6. Enter name and email address
        //7. Click 'Signup' button
        autoExercise.NUSNameBox.sendKeys(ConfigReader.getProperty("aeName")+Keys.TAB+ConfigReader.getProperty("aeEmail")+Keys.TAB+Keys.ENTER);
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(autoExercise.eaiTexti.isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        autoExercise.titleMr.click();
        autoExercise.password.sendKeys(ConfigReader.getProperty("aePassword")+Keys.TAB+"15"+Keys.TAB+"July"+Keys.TAB+"1995");
        //10. Select checkbox 'Sign up for our newsletter!'
        Driver.getDriver().findElement(By.id("newsletter")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        Driver.getDriver().findElement(By.id("optin")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        Driver.getDriver().findElement(By.id("first_name")).sendKeys("Aleyna"+Keys.TAB+"Yalvar"+Keys.TAB+"Yas A.Ş."+Keys.TAB+"İzmir"+Keys.TAB+"Menemen"+Keys.TAB+"Canada"+Keys.TAB+"Menemen"+Keys.TAB+"Asarlık"+Keys.TAB+"35950"+Keys.TAB+"5429632565"+Keys.TAB+Keys.ENTER);
        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//b")).isDisplayed());
        //15. Click 'Continue' button
        Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//b")).isDisplayed());
        //17. Click 'Delete Account' button
        Driver.getDriver().findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Driver.closeDriver();
    }

}
