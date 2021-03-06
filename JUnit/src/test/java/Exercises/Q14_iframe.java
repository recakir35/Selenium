package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q14_iframe {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
     //   driver.quit();
    }
    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> frame= driver.findElements(By.xpath("//iframe"));
        System.out.println(frame.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame("//iframe[@src='https:/www.youtube.com/embed/lYCEQqSM08I']");
        //4)
        //ilk iframe'den çıkıp ana sayfaya dönünüz
        //5)
        //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium project.html)
        //tıklayınız

    }

}
