package zPractise;

import org.apache.commons.math3.ode.FirstOrderConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Q07_Amazon {
    AmazonPage amazonPage;
    @Test
    public void test01() {
        amazonPage=new AmazonPage();
        //Amazon anasayfaya gidebilecek sekilde bir page sayfasi olusturun : AmazonPage
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Amazon ana sayfasinda en altta bulunan Webtable’i inceleyebilmek icin AmazonPage clasinda en altta gitme isini yapacak bir method olusturun
        //Bu class’in altinda bir test method olusturun : satirSayisi() ve webtable’da 10 satir oldugunu test edin
        Assert.assertEquals(amazonPage.tableSatirlar.size(),10);
        //Yeni bir method olusturun : sutunSayisi() ve yazi olan sutun sayisinin 7 oldugunu test edin
        List<WebElement> tableDoluSutunlar=new ArrayList<>();
        for (WebElement each: amazonPage.tableSutunlar){
            if ( !each.getText().isEmpty()){
                tableDoluSutunlar.add(each);
            }
        }
        Assert.assertEquals(tableDoluSutunlar.size(),7);


    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        amazonPage=new AmazonPage();
        //AmazonPage sayfasinda istedigim satir ve sutun sayisi ile cagirdigimda bana hucredeki yaziyi  getirecek bir method olusturun
        String satir="3";
        String sutun="7";
        String istenenHucre=Driver.getDriver().findElement(By.xpath("//tr["+satir+"]//td["+sutun+"]")).getText();
        System.out.println(istenenHucre);
        // webtable’da 3. satir 7.sutundaki yazinin “Home Services” yazisi icerdigini test edin
        Assert.assertTrue(istenenHucre.contains("Home Services"));
        //  tabloda 9 Hucrede “Amazon” yazisi bulundugunu test edin
        int count=0;
        for (WebElement each: amazonPage.tableHucre ) {
            if (each.getText().contains("Amazon")) count++;
        }
        Assert.assertEquals(count,9);

    }
}
