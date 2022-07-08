package zPractise;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q08_hotelMyCampDataProvider {
    HotelmycampPage hotelmycampPage ;

    @DataProvider
    public static Object[][] kullaniciListesi() {
        Object[][] kullaniciBilgileri = {{"Manager", "Manager"}, {"Manager1", "Manager1"},
                {"Manager2", "Manager2"}, {"Manager3", "Manager3"}, {"Manager4", "Manager4"}};
        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void hotelMCTest(String username, String password)  {
        hotelmycampPage = new HotelmycampPage();
        //1.https://www.hotelmycamp.comsayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        //2.TestNg framework @Dataprovider kullanarak asagidaki gorevi tamamlayin
        //3-Login tusuna basin
        hotelmycampPage.loginLinki.click();
        //4-Asagidaki 5 kullanici adi ve sifreyi deneyin ve login olmadigini test edin
        hotelmycampPage.userNameBox.sendKeys(username);
        hotelmycampPage.userPasswordBox.sendKeys(password);
        hotelmycampPage.loginButonu.click();
        Assert.assertTrue(hotelmycampPage.loginButonu.isDisplayed());
        //- Manager Manager,  Manager1 Manager1, Manager2 Manager2,  Manager3 Manager3, Manager4 Manager4
        Driver.closeDriver();
    }
}
