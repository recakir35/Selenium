package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Q03_ {
    public static void main(String[] args) {
        //1-C01_TekrarTesti isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2-https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3-cookies uyarisini kabul ederek kapatin
        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Sayfa Başlığı Testi PASSED");
        } else System.out.println("Sayfa Başlığı Testi FAILED");

        //5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@jsaction='paste:puy29d;']")).sendKeys("Nutella" + Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin
        String actualResult = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println(actualResult);

        //7-sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String actualResultArr[]=actualResult.split(" ");

        int number= Integer.parseInt(actualResultArr[1].replace(".",""));
        if (number>10000000){
            System.out.println("10 Milyon Testi PASSED");
        }else System.out.println("10 Milyon Testi FAILED"+ number);

        //8-Sayfayi kapatin
        driver.close();
    }
}
