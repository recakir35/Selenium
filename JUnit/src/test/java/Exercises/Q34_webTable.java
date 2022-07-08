package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class Q34_webTable extends TestBase {
    @Test
    public void webTableTest() {

        //1. https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan department isimlerini yazdirin
        System.out.print(" *** 1- Sayfa Başlıkları :");
        List<WebElement> headersList = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        int istenenIndex = 0;
        for (int i = 0; i < headersList.size(); i++) {
            if (headersList.get(i).getText().equals("Department")) istenenIndex = i;
        }
        List<WebElement> istenenSutun = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td'][" + (istenenIndex + 1) + "]"));
        istenenSutun.stream().filter(t -> !(t.getText().equals(" "))).forEach(t -> System.out.print(t.getText() + " "));

        //3. sutunun basligini yazdirin
        System.out.println("\n *** 2- istenen Sütünun Başlığı: " + headersList.get(istenenIndex).getText());

        //4. Tablodaki tum datalari yazdirin
        System.out.println(" *** 3- Tablodaki tüm Datalar: " + driver.findElement(By.xpath("//div[@class='rt-tbody']")).getText());

        //5. Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> hucreler = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println(" *** 4- Tablodaki dolu hücre sayısı: " + hucreler.stream().filter(t -> !(t.getText().equals(" "))).count());

        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlar = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println(" *** 5- Tablodaki satır sayısı: " + satirlar.stream().count());

        //7. Tablodaki sutun sayisini yazdirin
          System.out.println("\n *** 6- Tablodaki sütün sayısı: " + headersList.size());

        //8. Tablodaki 3.kolonu yazdirin
        System.out.print(" *** 7- 3.Kolon dataları :");
        List<WebElement> ucuncukolon=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        ucuncukolon.stream().filter(t->!(t.getText().equals(" "))).forEach(t-> System.out.print(t.getText()+ " "));

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        List<WebElement> firstNames=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][1]"));
        List<WebElement> salaries=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][5]"));
        for (int i = 0; i <firstNames.size() ; i++) {
            if (firstNames.get(i).getText().equals("Kierra")) System.out.println("\n *** 8- Tabloda ismi Kierra olanın maaşı: " +salaries.get(i).getText());
        }

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        int satir=2;
        int sutun=4;
        datayiGetir(satir,sutun);
    }

    private void datayiGetir(int satir, int sutun) {
        WebElement data=driver.findElement(By.xpath("//div[@class='rt-tr-group']["+satir+"]//div[@class='rt-td']["+sutun+"]"));
        System.out.println(" *** 9- Tabloda "+ satir+".satır "+sutun+".sütun datası: " +data.getText());
    }
}
