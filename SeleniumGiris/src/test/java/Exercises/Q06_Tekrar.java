package Exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q06_Tekrar {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String expectedTitle = "youtube";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Youtube Başlık Testi PASSED");
        }else System.out.println("Youtube Başlık Testi FAILED. Doğru Başlık: "+ driver.getTitle());

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String expectedUrl="youtube";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Youtube Url Testi PASSED");
        }else System.out.println("Youtube Url Testi FAILED. Doğru Url: "+ driver.getCurrentUrl());

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().forward();

        //8.Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        expectedTitle="Amazon";
        actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Amazon Başlık Testi PASSED");
        }else System.out.println("Amazon Başlık Testi FAILED. Doğru Başlık: "+ driver.getTitle());

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        expectedUrl="https://www.amazon.com/";
        actualUrl=driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Amazon Url Testi PASSED");
        }else System.out.println("Amazon Url Testi FAILED. Doğru Url: "+ driver.getCurrentUrl());

        //11.Sayfayi kapatin
        driver.close();
    }
}
