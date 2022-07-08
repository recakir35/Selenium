package Exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05_ {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");

        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Başlık Testi PASSED");
        }else {
            System.out.println("Başlık Testi FAILED");
            System.out.println("Doğru Başlık: " +driver.getTitle());
        }

        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String expectedUrl="facebook";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url Testi PASSED");
        }else {
            System.out.println("Url Testi FAILED");
            System.out.println("Doğru Url: " +driver.getCurrentUrl());
        }

        //4. https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        //5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        expectedTitle="Walmart.com";
        actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Başlık Testi PASSED");
        }else {
            System.out.println("Başlık Testi FAILED");
            System.out.println("Doğru Başlık: " +driver.getTitle());
        }

        //6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //7. Sayfayi yenileyin
        driver.navigate().refresh();

        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //9. Browser’i kapatin
        driver.close();
    }
}
