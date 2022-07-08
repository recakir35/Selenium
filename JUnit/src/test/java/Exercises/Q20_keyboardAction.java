package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q20_keyboardAction extends TestBase {
    @Test
    public void test01() {
        //1 Bir Class olusturalim KeyboardActions1
        //2 https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //3 Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        Actions actions=new Actions(driver);
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        actions.sendKeys(aramaKutusu,"samsung A71"+ Keys.ENTER).perform();
        //4 aramanin gerceklestigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().contains("samsung A71"));
    }
}
