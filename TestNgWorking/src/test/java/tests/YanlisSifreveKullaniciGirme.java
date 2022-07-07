package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class YanlisSifreveKullaniciGirme {
    @Test
    public void test01() {
        // Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        Driver.getDriver().get("http://tutorialsninja.com/demo/index.php?route=common/home");
        // click on Phones & PDAs
        Driver.getDriver().findElement(By.xpath("//*[text()='Phones & PDAs']")).click();
        // get the brandName of phones
        List<WebElement> telefonListesi=Driver.getDriver().findElements(By.xpath("//h4//a"));
        for (WebElement each:telefonListesi) {
            System.out.println(each.getText());
        }
        // click on add to button for all elements
        List<WebElement> eklemeButtonlari=Driver.getDriver().findElements(By.xpath("//span[text()='Add to Cart']"));
        for (WebElement each: eklemeButtonlari) {
            each.click();
        }
        // click on black total added cart button
        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
        // get the names of list from the cart
        List<WebElement> sepetListe=Driver.getDriver().findElements(By.xpath("//tr//td[@class='text-left']"));
        // compare the names from displaying list and cart list
        List<String> telefonListStr=new ArrayList<>();
        for (WebElement each: telefonListesi) {
            telefonListStr.add(each.getText());
        }

        for (WebElement each: sepetListe) {
            System.out.println(each.getText());
            Assert.assertTrue(telefonListStr.contains(each.getText()));
        }
        Driver.closeDriver();
    }
}
