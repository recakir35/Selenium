package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    //Bir Class olusturalim YanlisEmailTesti
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //2.http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");

        //3.Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //4.Email kutusuna @isareti olmayan bir mail yazip enter’a
        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("recakiryahoo.com"+ Keys.ENTER);

        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertEquals("Uyarı","Invalid email address.",driver.findElement(By.xpath("(//li)[15]")).getText());
    }

}
