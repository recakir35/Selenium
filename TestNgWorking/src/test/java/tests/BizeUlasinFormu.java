package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutoExercise;
import utilities.ConfigReader;
import utilities.Driver;

public class BizeUlasinFormu {
    @Test
    public void test06() {
        AutoExercise autoExercise=new AutoExercise();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(autoExercise.automationExerciseIkonu.isDisplayed());
        //4. Click on 'Contact Us' button
        autoExercise.contactUs.click();
        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(autoExercise.contactUsGetInTouch.isDisplayed());
        //6. Enter name, email, subject and message
        autoExercise.getContactUsGetInTouchName.sendKeys("Ahmet");
        autoExercise.getContactUsGetInTouchEmail.sendKeys("ahmet@hocmail.com");
        autoExercise.getContactUsGetInTouchSubject.sendKeys("Ülke Listesi");
        autoExercise.getContactUsGetInTouchMessage.sendKeys("liste çok önemli");
        //7. Upload file
        String filePath="C:\\Java Recep\\Ders_Selenium\\ulkeler.xlsx";
        System.out.println(filePath);
        autoExercise.getContactUsGetInTouchUploud.sendKeys(filePath);
        //8. Click 'Submit' button
        autoExercise.getContactUsGetInTouchSubmit.click();
        //9. Click OK button
        Driver.getDriver().switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
Assert.assertTrue(autoExercise.getContactUsGetInTouchHataText.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully

    }
}
