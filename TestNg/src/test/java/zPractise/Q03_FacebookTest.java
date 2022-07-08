package zPractise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q03_FacebookTest {
    @Test
    public void test01() {
        FacebookPage facebookPage=new FacebookPage();
        //1 https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        //2 POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        //3 email ve sifre degerlerini yazdirip, giris butonuna basin
        facebookPage.loginTusu.click();
        //4 Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.getDriver().close();
    }
}
