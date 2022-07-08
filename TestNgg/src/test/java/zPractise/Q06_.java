package zPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q06_ {
    @Test
    public void test01() {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");
// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        List<WebElement> urunList=Driver.getDriver().findElements(By.xpath("//p[@class='sc-124al1g-4 eeXMBo']"));
        for (int i = 0; i <urunList.size() ; i++) {
            System.out.println((i+1)+".Ürün: "+urunList.get(i).getText());
        }

// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> urunString=new ArrayList<>();
        for (int i = 0; i < urunList.size(); i++) {
           urunString.add(urunList.get(i).getText());
        }
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın (Her ürün 1 defadan fazla eklenemez!)
        WebElement sepet=Driver.getDriver().findElement(By.xpath("//button[@class='sc-1h98xa9-0 gFkyvN']"));
        List<WebElement> urunEkleme=Driver.getDriver().findElements(By.xpath("//*[text()='Add to cart']"));
        List<String> eklenenUrun=new ArrayList<>();
        Random rnd=new Random();
        double toplamFiyat = 0;
        do {
            int randomOgeIndex = rnd.nextInt(16);
            if (!eklenenUrun.contains(randomOgeIndex)) {
                eklenenUrun.add(String.valueOf(randomOgeIndex));
                System.out.print("Random ürün no : " + (randomOgeIndex+1));
                System.out.println();
                urunEkleme.get(randomOgeIndex).click();
       //         reactShoppingWebSite.Xbutton.click(); // her bir eklemeden sonra X buttona basılmalıdır ki, unvisible element kalmasın.
       //         String urunFiyat = reactShoppingWebSite.pricesList.get(randomOgeIndex).getText();
        //        Double urunFiyatDouble = Double.valueOf(urunFiyat.substring(1));
                //System.out.println(urunFiyatDouble);
         //       toplamFiyat += urunFiyatDouble;
            }
        } while (eklenenUrun.size()<5);

// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
// 7.Checkout'a tıklayın
    }
}
