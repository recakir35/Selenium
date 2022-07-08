package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q01_ {
    //Class W ork A mazon S earch T est
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- arama kutusunu locate edelim
        WebElement serachBox = driver.findElement(By.id("twotabsearchtextbox"));

        //3--“Samsung headphones” ile arama yapalim
        serachBox.sendKeys("Samsung headphones" + Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        List<WebElement> result = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.get(0).getText());

        //5- Ilk urunu tiklayalim
        List<WebElement> firstResult=driver.findElements(By.xpath("//img[@class='s-image']"));
        firstResult.get(0).click();

        //6- Sayfadaki tum basliklari yazdiralim
        List<WebElement> heads=driver.findElements(By.tagName("H1"));
        for (WebElement each: heads){
            System.out.println(each.getText());
        }
        driver.close();
    }
}
