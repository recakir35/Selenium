package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;
import java.util.Set;

public class Q31_windowHandle extends TestBase {
    @Test
    public void windowHandleTest() {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("(//h1)[3]")).click();
        //4.Diger window'a gecin
        String ilkWindowHandle = driver.getWindowHandle();
        Set<String> windowhandles = driver.getWindowHandles();
        String ikinciWindowHandle = "";
        for (String each : windowhandles) {
            if (!each.equals(ilkWindowHandle)) ikinciWindowHandle = each;
        }

        driver.switchTo().window(ikinciWindowHandle);
        //5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("recep" + Keys.TAB);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        Assert.assertTrue(driver.switchTo().alert().getText().equals("validation failed"));
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkWindowHandle);
        //10.Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand']")).getText().contains("New Approach To Learning"));
    }
}
