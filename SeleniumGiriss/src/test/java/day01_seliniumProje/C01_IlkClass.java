package day01_seliniumProje;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkClass {
    public static void main(String[] args) throws InterruptedException {
        /* En ilkel haliyle bir otomaston yapmak için classımıza otomasyon
         için gerekli olan webdrıverin yerini göstermemiz gerekir.
        Bunun için Java kutüphanesinden System.setProperty methodu kullanırız.
        --> ilki kullanacagımız driver : webdriver.chrome.driver
                --> ikincisi ise bu diriverin fiziki yolu :
                */
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        driver.close();

    }
}
