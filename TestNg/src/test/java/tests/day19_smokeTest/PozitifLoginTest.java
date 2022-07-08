package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifLoginTest {
    BrcPage brcPage=new BrcPage();
    @Test
    public void positiveLoginTest() {
        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // login butonuna bas
        brcPage.ilklogin.click();
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextbox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        //test data password : 12345
        brcPage.passwordTextbox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        // login butonuna tıklayın
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName=brcPage.kullaniciProfilIsmi.getText();
        String expectedName=ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(expectedName,actualUserName);

        Driver.closeDriver();
    }
}
