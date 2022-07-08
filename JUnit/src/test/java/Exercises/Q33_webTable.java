package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q33_webTable extends TestBase {
    @Test
    public void webTableTest() {
        // login(login() metodun oluşturun ve oturum
        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        // Username : manager
        // Password : Manager 1
        girisYap();

        //Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//th"));
        System.out.println("Sutun Sayısı: "+sutunSayisi.size());
        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        for (WebElement each: sutunSayisi){
            System.out.println("Başlıklar"+each.getText());
        }
        //printRows(printRows() metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satır Sayısı: "+satirSayisi.size());
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satirSayisi){
            System.out.println("Satırlar: "+each.getText());
        }
        //4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> rowDort=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each: rowDort){
            System.out.println(each.getText());
        }

    }

    private void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager"+ Keys.TAB);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("manager1!");
        driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();



    }
}
