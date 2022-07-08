package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q08_assertFalse {
    //1) Bir class oluşturun: Youtube Assertions
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() {
            driver.close();
    }

    @Test
    public void titleTest() {
        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        //titleTest => Sayfa başlığının YouTube ” oldugunu test edin
        Assert.assertEquals("Sayfa Başlığı", "YouTube", driver.getTitle());
        System.out.println(driver.getTitle());
    }

    @Test
    public void imageTest() {
        // imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());
    }

    @Test
    public void searchBoxTest() {
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='search_query']")).isEnabled());
    }
    @Test
    public void wrongTitleTest() {
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }
}
