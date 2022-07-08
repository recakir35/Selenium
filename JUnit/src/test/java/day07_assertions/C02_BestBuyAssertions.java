package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
    //1) Bir class oluşturun: BestBuy Assertions
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2)https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() {
             driver.close();
    }

    @Test
    public void test01() {
        // a) Sayfa URL’inin https://www.bestbuy.com/‘a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Url Testi", expectedUrl, actualUrl);
    }

    @Test
    public void test02() {
        // b)titleTest => Sayfa başlığının “ Rest” içermediğini(contains) test edin
        String titleTest = driver.getTitle();
        Assert.assertFalse(titleTest.contains("Rest"));
    }

    @Test
    public void test03() {
        // c) logoTest => BestBuy logosunun görüntülen digini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@src='https://www.bestbuy.com/~assets/bby/_com/header-footer/images/bby_logo-a7e90594729ed2e119331378def6c97e.png'])[1]")).isDisplayed());
    }

    @Test
    public void test04() {
        // d) Francais LinkTest => Fransizca Linkin görüntülen diğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang='fr']")).isDisplayed());
    }

}
