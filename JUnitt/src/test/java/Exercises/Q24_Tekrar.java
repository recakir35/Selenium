package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;
import java.util.Set;

public class Q24_Tekrar extends TestBaseClass {
    @Test
    public void test01() {
        //1 amazon gidin
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.id("sp-cc-accept")).click(); // Çerezleri Kabul ediyor
        //2 Arama kutusunun solundaki drop down menuyu handle edip listesini ekrana yazdırın
        WebElement ddm1 = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options1 = new Select(ddm1);
        List<WebElement> optionsList = options1.getOptions();
        for (WebElement each : optionsList) {
            System.out.println(each.getText());
        }
        //3 drop down menude 21 eleman olduğunu doğrulayın
        Assert.assertTrue(optionsList.size() == 21);

        // @Test2
        //1 dropdown menuden elektronik bölümü seçin
        options1.selectByIndex(4);
        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırı n
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
        //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().contains("iphone"));
        //4 ikinci ürüne relative locater kullanarak tıklay in
        driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();
        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String urunBasligi1 = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String urunfiyati1 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        //@Test3
        //1 yeni bir sekme açarak amazon a nasayfaya gidin
        String ilkwindowhadleDegeri = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> windowHandles = driver.getWindowHandles();
        String ikinciSayfaWindowHandle = "";
        for (String each : windowHandles) {
            if (!each.equals(ilkwindowhadleDegeri)) ikinciSayfaWindowHandle = each;
        }
        driver.switchTo().window(ikinciSayfaWindowHandle);
        driver.get("https://www.amazon.com.tr");
        //2 dropdown’dan bebek bölümüne secin
        WebElement ddm2 = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options2 = new Select(ddm2);
        options2.selectByVisibleText("Bebek");
        //3 bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puset" + Keys.ENTER);
        //4 sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().contains("puset"));
        //5 üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//img[@class='s-image'])[3]")).click();
        //6 title ve fiyat bilgilerini assign edelim ve ürünü sepete ekley in
        String urunBasligi2 = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String urunfiyati2 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

        // @Test4
        //1 sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        System.out.println(urunBasligi1 + ": " + urunfiyati1);
        System.out.println(urunBasligi2 + ": " + urunfiyati2);
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]")).getText().equals(urunBasligi1));
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='a-price-whole'])[3]")).getText().equals(urunfiyati1));
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).getText().equals(urunBasligi2));
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]")).getText().equals(urunfiyati2));

    }


}
