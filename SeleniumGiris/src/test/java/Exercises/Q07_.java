package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q07_ {
    //1. Bir class oluşturun: LoginTest
    //2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        //b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();

        //c. email textbox,password textbox, and signin button elementlerini locate
        WebElement mailText=driver.findElement(By.id("session_email"));
        WebElement passwordText=driver.findElement(By.id("session_password"));
        WebElement signinButton=driver.findElement(By.name("commit"));

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign i n)buttonunu tıklayın:
        //i. Username :testtechproed@gmail.com
        mailText.sendKeys("testtechproed@gmail.com");
        //ii. Password : Test1234!
        passwordText.sendKeys("Test1234!");
        signinButton.click();

        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        String expectedUser="testtechproed@gmail.com";
        String actualUser= String.valueOf(driver.findElement(By.className("navbar-text")).getText());
        if (actualUser.equals(expectedUser)){
            System.out.println("User Testi PASSED");
        } else System.out.println("User Testi FAILED");

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement adressText=driver.findElement(By.linkText("Addresses"));
        WebElement signText=driver.findElement(By.linkText("Sign out"));
        if (adressText.isDisplayed()){
            System.out.println("Adress Testi PASSED");
        }else System.out.println("Adress Testi FAILED");

        if (signText.isDisplayed()){
            System.out.println("Sign Out Testi PASSED");
        }else System.out.println("Sign Out Testi FAILED");

        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> link=driver.findElements(By.tagName("a"));
        System.out.println(link.size());

        // Linkleri Yazdıralım

        for (WebElement each: link){
            System.out.println(each.getText());
        }
        driver.close();
    }
}
