package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    BrcPage brcPage;
    @Test
    public void yanlisSifre() {
        brcPage = new BrcPage();
        //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage.ilklogin.click();
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextbox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        //test data password : 12345
        brcPage.passwordTextbox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //login tusuna basın
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void yanlisUser() {
        brcPage = new BrcPage();
        //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage.ilklogin.click();
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextbox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data password : 12345
        brcPage.passwordTextbox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        //login tusuna basın
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void yanlisUserTanlisPassword() throws InterruptedException {
        brcPage = new BrcPage();
        //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        Thread.sleep(5000);
        brcPage.ilklogin.click();
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextbox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data password : 12345
        brcPage.passwordTextbox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //login tusuna basın
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());
        Driver.closeDriver();
    }
}
