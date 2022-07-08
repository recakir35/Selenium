package zPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import javax.swing.*;

public class Q05_ {
    @Test
    public void test01() {
        //    http://demo.guru99.com/test/drag_drop.html url e git
        Driver.getDriver().get(" http://demo.guru99.com/test/drag_drop.html");
        //    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        Actions action = new Actions(Driver.getDriver());
        WebElement tasinanBank = Driver.getDriver().findElement(By.xpath("(//a[@class='button button-orange'])[5]"));
        WebElement hedefDebitAccount = Driver.getDriver().findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        action.dragAndDrop(tasinanBank, hedefDebitAccount).perform();
        //    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        WebElement tasinanSales = Driver.getDriver().findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
        WebElement hedefCreditAccount=Driver.getDriver().findElement(By.xpath("//ol[@id='loan']"));
        action.dragAndDrop(tasinanSales,hedefCreditAccount).perform();
        //    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        WebElement tasinan5000=Driver.getDriver().findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
        WebElement hedefDebitAmount=Driver.getDriver().findElement(By.xpath("(//li[@class='placeholder'])[1]"));
        action.dragAndDrop(tasinan5000,hedefDebitAmount).perform();
        //    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
        WebElement tasinan50002=Driver.getDriver().findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
        WebElement hedefCreditAmount=Driver.getDriver().findElement(By.xpath("//ol[@id='amt8']"));
        action.dragAndDrop(tasinan50002,hedefCreditAmount).perform();
        //    Perfect butonun goruntulendigini dogrulayin
        WebElement perfectButtonElementi=Driver.getDriver().findElement(By.xpath("(//a[@class='button button-green'])[1]"));
        Assert.assertTrue(perfectButtonElementi.isDisplayed());
    }
}
