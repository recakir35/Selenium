package zPractise;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q01_priority extends TestBase {
    @Test(priority = 0)
    public void test01() {
        //1) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        //2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
        // titleTest => Sayfa başlığının YouTube ” oldugunu test edin
        Assert.assertTrue(driver.getTitle().equals("YouTube"));
    }

    @Test(priority = 1)
    public void test02() {
   //imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        driver.get("https://www.youtube.com");
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());
    }

    @Test (priority = 2)
    public void test03() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        driver.get("https://www.youtube.com");
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
    }

    @Test (priority = 3)
    public void test04() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        driver.get("https://www.youtube.com");
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }

}

