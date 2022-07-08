package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q13_iframe {
    WebDriver driver;
    @Before
    public void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @After
    public void tearDown(){
       driver.quit();
    }
    @Test
    public void iframeTest(){
        //“An IFrame containing….” textini n erisilebilir oldugunu test edin ve konsolda yazdirin.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Merhaba Dünya");
        //TextBox’in altinda bulunan “Elemental Selenium” linkini textini ngorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).getText());
    }

}
