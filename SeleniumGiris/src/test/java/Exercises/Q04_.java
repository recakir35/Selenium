package Exercises;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04_ {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfa Boyutları: "+ driver.manage().window().getSize());
        System.out.println("Sayfa Konumu: "+driver.manage().window().getPosition());

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setSize(new Dimension(1000, 500));
        driver.manage().window().setPosition(new Point(-6, -6));

        System.out.println("Yeni Sayfa Boyutları: "+ driver.manage().window().getSize());
        System.out.println("Yeni Sayfa Konumu: "+driver.manage().window().getPosition());

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        String actualSize= String.valueOf(driver.manage().window().getSize());
        String expectedSize= "(1000, 500)";

        if (actualSize.equals(expectedSize)){
            System.out.println("Boyut Testi PASSED");
        }else System.out.println("Boyut Testi FAILED");

        String actualPosition= String.valueOf(driver.manage().window().getSize());
        String expectePosition= "(-6, -6)";

        if (actualPosition.equals(expectePosition)){
            System.out.println("Konum Testi PASSED");
        }else System.out.println("Konum Testi FAILED");

        //8. Sayfayi kapatin
        driver.close();
    }
}
