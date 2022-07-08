package zPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class Q02_SoftAssert extends TestBase {
    @Test
    public void testName() {
    //Yeni bir Class Olusturun : C03_SoftAssert
    //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
    //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
    //3. Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username"+ Keys.TAB);
    //4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
    //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();
    //6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
    //7. “Purchase Foreign Currency” tusuna basin
driver.findElement(By.xpath("//li[@class='ui-state-default ui-corner-top'][2]")).click();
    //8. “Currency” drop down menusunden Eurozone’u secin
       WebElement ddm= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByIndex(6);
    //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(select.getFirstSelectedOption().equals("Eurozone(euro)"));
        softAssert.assertAll();
    //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    //"Select One"One", "Australia ( dollar)", "Canada ( dollar)",,"Switzerland ( franc)",,"China
    //( yuan)",,"Denmark ( krone)",,"Eurozone ( euro)",,"Great Britain ( pound)",,"Hong Kong
    //( dollar)",,"Japan ( yen)",,"Mexico ( peso)",,"Norway ( krone)",,"New Zealand
    //( dollar)",,"Sweden ( krona)",,"Singapore ( dollar)",,"Thailand (
    }
}
