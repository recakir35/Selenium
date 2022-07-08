package Exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_ {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com");

        //4. Sayfa basligini(title) yazdirin
        String sayfaTitle = driver.getTitle();
        System.out.println("Sayfa Başlığı: "+sayfaTitle);

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Sayfa Başlığı Testi PASSED");
        }else System.out.println("Sayfa Başlığı Testi FAILED");

        //6. Sayfa adresini(url) yazdirin
        String sayfaUrl=driver.getCurrentUrl();
        System.out.println("Sayfa Url: "+sayfaUrl);

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Sayfa Url Testi PASSED");
        } else System.out.println("Sayfa Url Testi FAILED");

        //8. Sayfa handle degerini yazdirin
        String pageHandle=driver.getWindowHandle();
        System.out.println("Sayfa Handle Değeri: "+pageHandle);

        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        String pageHtml=driver.getPageSource();
        if (pageHtml.contains("alisveris")){
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");

        //10. Sayfayi kapatin.
        driver.close();
    }
}
