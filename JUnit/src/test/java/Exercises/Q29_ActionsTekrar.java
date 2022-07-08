package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q29_ActionsTekrar extends TestBase {
    @Test
    public void actionsTekrar() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"))).perform();
        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='click-box']"))).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@id='click-box']")).getText());
        //8. "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//h2"))).perform();
    }
}
