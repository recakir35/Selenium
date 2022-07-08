package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q21_keyboard extends TestBase {
    @Test
    public void test01() {
        //Yeni bir class olusturalim: D15_MouseActions4
        //1 https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2 Yeni hesap olustur butonuna basalim
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3 Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        actions.sendKeys(driver.findElement(By.xpath("//input[@name='firstname']")),"Recep"+ Keys.TAB)
                .sendKeys("Çakır"+Keys.TAB)
                .sendKeys("rrrsrrrr@gmail.com"+Keys.TAB)
                .sendKeys("rrrsrrrr@gmail.com"+Keys.TAB)
                .sendKeys("585264456"+Keys.TAB+Keys.TAB)
                .sendKeys("15"+Keys.TAB)
                .sendKeys("Eki"+Keys.TAB)
                .sendKeys("2001"+Keys.TAB+Keys.TAB)
                .sendKeys(Keys.DOWN).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                //4 Kaydol tusuna basalim
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
