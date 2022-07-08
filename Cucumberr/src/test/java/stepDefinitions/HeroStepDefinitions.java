package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HeroPage;
import utilities.Driver;

import java.time.Duration;

public class HeroStepDefinitions {
    HeroPage heroPage=new HeroPage();

    @Given("add element butonuna basar")
    public void add_element_butonuna_basar() {
        heroPage.addButton.click();
    }
    @Then("Delete butonu gorunur oluncaya kadar bekler")
    public void delete_butonu_gorunur_oluncaya_kadar_bekler() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(heroPage.deleteButton));
    }
    @Then("Delete butonunun gorunur oldugunu test eder")
    public void delete_butonunun_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(heroPage.deleteButton.isDisplayed());
    }
    @Then("Delete butonuna basar")
    public void delete_butonuna_basar() {
        heroPage.deleteButton.click();
    }
    @Then("Delete butonunun gorunmedigini test eder")
    public void delete_butonunun_gorunmedigini_test_eder() {
        Assert.assertTrue(heroPage.deleteListesi.isEmpty());
    }
}