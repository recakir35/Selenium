package zPractise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q04_hotelmycamp {
    @Test
    public void test01() {
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        //1) https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelmycampUrl"));
        //login butonuna bas
        hotelmycampPage.loginLinki.click();
        //test data username:
        hotelmycampPage.userNameBox.sendKeys(ConfigReader.getProperty("hmcWrongUsername"));
        //test data password :
        hotelmycampPage.userPasswordBox.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));
        hotelmycampPage.loginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelmycampPage.loginName.getText().equals(ConfigReader.getProperty("hmcWrongUsername")));
        Driver.closeDriver();
    }
}
