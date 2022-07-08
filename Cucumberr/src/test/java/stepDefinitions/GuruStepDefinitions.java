package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GuruPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class GuruStepDefinitions {
    List<WebElement> istenenSutundakiElementler = new ArrayList<>();
    GuruPage guruPage = new GuruPage();

    @Given("cookies sorulursa kabul eder")
    public void cookies_sorulursa_kabul_eder() {
        //Driver.getDriver().switchTo().frame(guruPage.cookiesIframe);
        // guruPage.acceptCookies.click();
    }

    @Given("{string}, sutunundaki tum degerleri yazdirir")
    public void sutunundaki_tum_degerleri_yazdirir(String istenenSutun) {

        List<WebElement> tabloBaslikListesi = guruPage.baslikListesi;
        // listemiz webelementlerden olusuyor
        // dolayisiyla bu webelementlerden hangisi
        // istenen sutun basligini tasiyor bilemeyiz
        int istenenBaslikIndexi = -3;
        for (int i = 0; i < tabloBaslikListesi.size(); i++) {
            if (tabloBaslikListesi.get(i).getText().equals(istenenSutun)) {
                istenenBaslikIndexi = i + 1;
                break;
            }
        }

        // for loop ile tum sutun basliklarini bana verilen istenenSutun degeri ile karsilastirdim
        // loop biittiginde basligin bulunup bulunmadigini kontrol etmek ve
        // bulundu ise yoluma devam etmek istiyorum

        if (istenenBaslikIndexi != -3) { // baslik bulundu
            istenenSutundakiElementler = Driver.getDriver().findElements(By.xpath("//tbody//tr//td[" + istenenBaslikIndexi + "]"));
            for (WebElement each : istenenSutundakiElementler
            ) {
                System.out.println(each.getText());
            }


        } else { // baslik bulunamadi
            System.out.println("istenen baslik bulunamadi");
        }

    }

    @And("{string} sirketinin listede oldugunu test eder")
    public void sirketininListedeOldugunuTestEder(String istenenVeri) {
        String actualVeri = "";
        for (WebElement each : istenenSutundakiElementler) {
            if (each.getText().equals(istenenVeri)) actualVeri = each.getText();
        }
        Assert.assertEquals(istenenVeri, actualVeri);
    }

    @And("{string} satir , {string}  sutundaki yazıyıyazdırır")
    public void satirSutundakiYazıyıyazdırır(String satir, String sutun) {
        WebElement istenenVeri = Driver.getDriver().findElement(By.xpath("//body//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(istenenVeri.getText());
    }
}