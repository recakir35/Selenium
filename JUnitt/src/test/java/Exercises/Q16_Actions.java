package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class Q16_Actions extends TestBase {
    @Test
    public void test01() {
        //1 Yeni bir class olusturalim: MouseActions1
        //2 https://the internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3 Cizili alan uzerinde sag click yapalim
        Actions actions= new Actions(driver);
        WebElement cizili=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizili).perform();
        //4 Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        Assert.assertTrue(driver.switchTo().alert().getText().equals("You selected a context menu"));
        //5 Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6 Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        //7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> setHandleDegeri=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";
        for (String each: setHandleDegeri){
            if (!each.equals(ilkSayfaHandleDegeri)) ikinciSayfaHandleDegeri=each;
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().equals("Elemental Selenium"));
    }
}
