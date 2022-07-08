package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DataTablesPage;

public class DataTablesStepsDefinitions {
    DataTablesPage dataTablesPage=new DataTablesPage();

    @Then("new butonuna basar")
    public void newButonunaBasar() {
        dataTablesPage.newButonu.click();
    }

    @And("firstname bolumuna {string} yazar")
    public void firstnameBolumunaYazar(String firstname) {
        dataTablesPage.firstName.sendKeys(firstname);
    }

    @And("lastname bolumuna {string} yazar")
    public void lastnameBolumunaYazar(String lastname) {
        dataTablesPage.lastName.sendKeys(lastname);
    }

    @And("position bolumuna {string} yazar")
    public void positionBolumunaYazar(String position) {
        dataTablesPage.position.sendKeys(position);
    }

    @And("office bolumuna {string} yazar")
    public void officeBolumunaYazar(String office) {
        dataTablesPage.office.sendKeys(office);
    }

    @And("extension bolumuna {string} yazar")
    public void extensionBolumunaYazar(String extension) {
        dataTablesPage.extn.sendKeys(extension);
    }

    @And("startDate bolumuna {string} yazar")
    public void startdateBolumunaYazar(String startDate) {
        dataTablesPage.startDate.sendKeys(startDate);
    }

    @And("salary bolumuna {string} yazar")
    public void salaryBolumunaYazar(String salary) {
        dataTablesPage.salary.sendKeys(salary);
    }

    @And("Create tusuna basar")
    public void createTusunaBasar() {
        dataTablesPage.create.click();
    }

    @When("kullanici {string} ile arama yapar")
    public void kullaniciIleAramaYapar(String firstname) {
        dataTablesPage.search.sendKeys(firstname);
    }

    @Then("isim bolumunde {string} oldugunu test eder")
    public void isimBolumundeOldugunuTestEder(String firstname) {
        Assert.assertTrue(dataTablesPage.sonucfirstname.getText().contains(firstname));
    }
}
