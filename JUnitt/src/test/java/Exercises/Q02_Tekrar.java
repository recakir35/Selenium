package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02_Tekrar {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get(" http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();


        //3. Login alanine “ yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4.Password alanine “ yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //5. Sign in button una tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
       driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("25");

        //8. tarih kismina “2020 0 9 10 yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");


        //9. Pay button una tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        String actualMessage=driver.findElement(By.xpath("//div[@id='alert_content']")).getText();
        String expectedMessage="The payment was successfully submitted.";
        if (actualMessage.equals(expectedMessage)){
            System.out.println("Mesaage Testi PASSED");
        }else   System.out.println("Mesaage Testi FAILED");

        driver.close();
    }
}
