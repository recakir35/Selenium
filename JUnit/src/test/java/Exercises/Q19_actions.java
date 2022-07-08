package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q19_actions extends TestBase {
    @Test
    public void test01() {
        //Yeni bir class olusturalim: MouseActions3
        //1 https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        //2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        Actions actions= new Actions(driver);
        WebElement webElement=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actions.moveToElement(webElement).perform();
        //3 --“Create a list” butonuna basalim
        driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();
        //4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@role='heading'])[1]")).getText().equals("Your Lists"));
    }

}
