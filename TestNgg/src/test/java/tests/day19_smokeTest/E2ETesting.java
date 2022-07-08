package tests.day19_smokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class E2ETesting {
    @Test
    public void createHotel() {
        HotelmycampPage hotelmycampPage=new HotelmycampPage();
        //1.https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        //2. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //a. Username : manager , b. Password: Manager 1
        hotelmycampPage.loginLinki.click();
        hotelmycampPage.userNameBox.sendKeys(ConfigReader.getProperty("hmcWrongUserName"));
        hotelmycampPage.userPasswordBox.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));
        //3. Login butonuna tıklayın.
        hotelmycampPage.loginButonu.click();
        //4 . Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        hotelmycampPage.HManagementLinki.click();
        hotelmycampPage.hotelListLinki.click();
        hotelmycampPage.ADDHotelButonu.click();
        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        hotelmycampPage.codeBox.sendKeys(   "3527"+ Keys.TAB+"Recep"+Keys.TAB+"İzmir"+Keys.TAB+"543698756"+Keys.TAB+"resjhas@hghj.com");
        Select select=new Select(hotelmycampPage.idGroup);
        select.selectByVisibleText("Hotel Type1");
        //8 . Save butonuna tıklayın.
        hotelmycampPage.saveTusu.click();
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        hotelmycampPage.mesajKutusuText.getText().equals("Hotel was inserted successfully");
        //10 . OK butonuna tıklayın.
        hotelmycampPage.mesajButton.click();
        Driver.closeDriver();

    }
}
