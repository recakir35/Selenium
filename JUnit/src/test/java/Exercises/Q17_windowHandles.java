package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Q17_windowHandles extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().equals("Opening a new window"));
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().equals("The Internet"));
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> sayfaHandleDegerleri=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri ="";
        for (String each: sayfaHandleDegerleri){
            if (!each.equals(ilkSayfaHandleDegeri)) ikinciSayfaHandleDegeri=each;
        }
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertTrue(driver.switchTo().window(ikinciSayfaHandleDegeri).getTitle().contains("New Window"));
        //●Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().equals("New Window"));
        //●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Assert.assertTrue(driver.getTitle().equals("The Internet"));
    }

}
