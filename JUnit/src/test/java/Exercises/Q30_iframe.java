package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q30_iframe extends TestBase {
    @Test
    public void iframeTest() throws InterruptedException {
        //1.“http://webdriveruniversity.IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        driver.switchTo().frame(driver.findElement(By.id("frame")));
        driver.findElement(By.linkText("Our Products")).click();

        //3. Cameras product”i tiklayin
        driver.findElement(By.linkText("Cameras")).click();

        //4. Popup mesajini yazdirin
        System.out.println("Popup Menü Mesajı: " + driver.findElement(By.xpath("//h4")));
        // System.out.println(driver.switchTo().alert().getText());
        //5. “close” butonuna basin
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
        //6."WebdriverUniversity.com IFrame )" linkini tiklayin
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
        //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
    }
}
