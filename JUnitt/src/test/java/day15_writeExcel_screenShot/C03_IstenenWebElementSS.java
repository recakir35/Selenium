package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        //Amazona Gidip Nutella aratalım sonuç sayısının olduğu web elementin fotografını çekelim
driver.get("https://www.amazon.com");
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYaziElement= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYaziElementSS=new File("target/ekranGoruntuleri/sonucYazisi.jpeg");
        File temp=sonucYaziElement.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,sonucYaziElementSS);
    }
}
