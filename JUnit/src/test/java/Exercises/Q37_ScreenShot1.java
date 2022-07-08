package Exercises;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Q37_ScreenShot1 extends TestBase {
    @Test
    public void amazonNutellaSearch() throws IOException {
        //1 amazon anasayfaya gidin
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.id("sp-cc-accept")).click();
        //2 amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        TakesScreenshot ts = (TakesScreenshot) driver;
        File amazonSayfa = new File("target/ekranGoruntuleri/amazonSayfa.jpeg");
        File temp = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp, amazonSayfa);
        //3 Nutella icin arama yapin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        //4 sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("Nutella"));
        WebElement ilkResim=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        File ilkSayfa = new File("target/ekranGoruntuleri/ilksayfa.jpeg");
        File temp2 = ilkResim.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp2, ilkSayfa);
    }
}
