package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Q11_Tekrar {
    public static void main(String[] args) {

        //1.C01_TekrarTesti isimli bir class olusturun
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //2.https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3.Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4.Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5. Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String titleWeb=driver.getTitle();

        if (titleWeb.contains("Spend less")){
            System.out.println("Spend Less Testi PASSED");
        } else System.out.println("Spend Less Testi FAILED");

        //6. Gift Cards sekmesine basin
         driver.findElement(By.linkText("Gift Cards")).click();

        //7.Birthday butonuna basin
        driver.findElement(By.xpath("//img[@src='https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_Birthday_346x130.png']")).click();

        //8.Best Seller bolumunden ilk urunu tiklayin
        List<WebElement> bestSeller = driver.findElements(By.xpath("//img[@src='https://images-na.ssl-images-amazon.com/images/I/41zRJ1VZdYL._AC_SX184_.jpg']"));
        bestSeller.get(0).click();

        //9.Gift card details’den 25 $’i secin
        List<WebElement> yirbesDolar = driver.findElements(By.xpath("//button[@id='gc-mini-picker-amount-1']"));
        yirbesDolar.get(0).click();

        //10.Urun ucretinin 25$ oldugunu test edin
        WebElement urunUcret=driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));
        if (urunUcret.getText().equals("$25.00")){
            System.out.println("Ürün Ücret Testi PASSED");
        }else System.out.println("Ürün Ücret Testi FAILED");

        //11.Sayfayi kapatin
        driver.close();
    }
}
