package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Q28_ExplitlyWait extends TestBase {
    @Test
    public void isEnabledTesti() {
        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());
        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement sonucElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //4. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(sonucElement.isDisplayed());
        //7 . Textbox’in etkin ol dugunu (enabled)
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());
    }
}
