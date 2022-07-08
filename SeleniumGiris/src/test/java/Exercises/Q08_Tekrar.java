package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q08_Tekrar {
    //1. Bir class oluşturun :AmazonSearchTest
    //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a.google web sayfasına gidin. https:// amazon .
        driver.get("https://www.amazon.com");

        //b. Search(ara) “city bike”
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike"+ Keys.ENTER);

        //c.Amazon 'da görüntülenen ilgili sonuçların sayısını yazdırın
        List<WebElement> searchResults=driver.findElements(By.className("sg-col-inner"));
        System.out.println(searchResults.get(0).getText());
        //e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        List<WebElement> serched=driver.findElements(By.className("s-image"));
        serched.get(6).click();
        // Sayfayı kapatın
        driver.close();

    }

}
