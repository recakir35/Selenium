package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q25_UploadFile extends TestBase {
    @Test
    public void test01() {
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));
        //3.Yuklemek istediginiz dosyayi secelim
        String sabitKisim=System.getProperty("user.home");
        String degisenKisim="\\OneDrive\\Masaüstü\\text.txt";
        String dosyaYolu=sabitKisim+degisenKisim;
        dosyaSecButonu.sendKeys(dosyaYolu);
        //4.Upload butonuna bas alim
        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
    }
}
