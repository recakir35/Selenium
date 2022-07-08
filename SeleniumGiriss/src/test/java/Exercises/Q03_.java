package Exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_ {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanın Boyutları: "+driver.manage().window().getSize());
        System.out.println("Sayfanın Konumu: "+driver.manage().window().getPosition());

        //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(Long.parseLong("3000"));
        driver.manage().window().maximize();

        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Max Sayfanın Boyutları: "+driver.manage().window().getSize());
        System.out.println("Max Sayfanın Konumu: "+driver.manage().window().getPosition());

        //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Full Sayfanın Boyutları: "+driver.manage().window().getSize());
        System.out.println("Full Sayfanın Konumu: "+driver.manage().window().getPosition());

        //9. Sayfayi kapatin
        driver.close();
    }
}
