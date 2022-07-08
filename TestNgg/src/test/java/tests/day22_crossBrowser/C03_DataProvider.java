package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        //amazon ana sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // nutella aratalım
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella içerdiğini test edelim
        String expectedKelime="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        Driver.closeDriver();

    }

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        Object[][] arananKelimeArrayi= {{"nutella"}, {"java"}, {"çiğdem"} ,{"Netherlands"}};
        return arananKelimeArrayi;
    }


    @Test(dataProvider = "aranacakKelimeler")
    //arayacağımız kelimeleri bir liste gibi tutup bana yollayacak bir veri sağlayacisi oluşturacağız
    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        //amazon ana sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // nutella,java,ciğdem ve Netherlands icin aratalım
        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);
        //sonuclarin aradığımız kelime içerdiğini içerdiğini test edelim
        String expectedKelime=arananKelime;
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        Driver.closeDriver();
    }
}
