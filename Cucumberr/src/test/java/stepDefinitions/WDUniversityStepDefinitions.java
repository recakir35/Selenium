package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.WDUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;
import java.security.Key;
import java.util.List;
import java.util.Set;

public class WDUniversityStepDefinitions {
    Actions action = new Actions(Driver.getDriver());
    WDUniversityPage wdUniversityPage = new WDUniversityPage();
    String ilkWindow;

    @And("Login Portal'a kadar asagi iner")
    public void loginPortalAKadarAsagiIner() {
        action.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Then("Login Portal'a tiklar")
    public void loginPortalATiklar() {
        wdUniversityPage.loginPortalLinkElementi.click();
        ilkWindow = Driver.getDriver().getWindowHandle();
    }

    @Then("Diger window'a gecer")
    public void diger_window_a_gecer() {
        Set<String> windows = Driver.getDriver().getWindowHandles();
        String ikinciWindow = "";
        for (String each : windows) {
            if (!each.equals(ilkWindow)) ikinciWindow = each;
        }
        Driver.getDriver().switchTo().window(ikinciWindow);
    }

    @Then("{string} ve {string} kutularina deger yazar")
    public void ve_kutularina_deger_yazar(String username, String pasword) {
        wdUniversityPage.userNameBox.sendKeys(ConfigReader.getProperty("WDUWrongUsername"));
        wdUniversityPage.passwordBox.sendKeys(ConfigReader.getProperty("WDUWrongPasword"));
    }

    @Then("login butonuna basar")
    public void loginButonunaBasar() {
        wdUniversityPage.loginButton.click();
    }

    @And("Popup'ta cikan yazinin validation failed oldugunu test eder")
    public void popupTaCikanYazininValidationFailedOldugunuTestEder() {
        Assert.assertTrue(Driver.getDriver().switchTo().alert().getText().equals("validation failed"));
    }

    @Then("Ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("Ilk sayfaya geri doner")
    public void ilk_sayfaya_geri_doner() {
Driver.getDriver().switchTo().window(ilkWindow);
    }

    @Then("Ilk sayfaya donuldugunu test eder")
    public void ilk_sayfaya_donuldugunu_test_eder() {
Assert.assertTrue(wdUniversityPage.ilksayfaBarElementi.getText().contains("WebdriverUniversity"));
    }



}
