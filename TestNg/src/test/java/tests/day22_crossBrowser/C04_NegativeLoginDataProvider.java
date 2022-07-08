package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
    BrcPage brcPage;

    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciBilgileri={{"firuze@nehaber.com", "123456"},
                                       {"murat@safari.com","123456"},
                                       {"yukari@gel.com","966311"}};
        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userMail, String password) {
        brcPage = new BrcPage();
        //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //      login butonuna bas
        brcPage.ilklogin.click();
        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextbox.sendKeys(userMail);
        //test data password : 12345
        brcPage.passwordTextbox.sendKeys(password);
        //login tusuna basın
        brcPage.ikinciLogin.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLogin.isDisplayed());
        Driver.closeDriver();
    }
}
