package Exercises;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q26_FakerClass extends TestBase {
    @Test
    public void test01() {
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3. “firstName” giris kutusuna bir isim yazin
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        actions.sendKeys(driver.findElement(By.xpath("//input[@name='firstname']")), faker.name().firstName()).sendKeys(Keys.TAB)
                //4. “surname” giris kutusuna bir soyisim yazin
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                //5. “email” giris kutusuna bir email yazin
                .sendKeys(email).sendKeys(Keys.TAB)
                //6. “email” onay kutusuna emaili tekrar yazin
                .sendKeys(email).sendKeys(Keys.TAB)
                //7. Bir sifre girin
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                //8.Tarih icin gun secin
                .sendKeys("13").sendKeys(Keys.TAB)
                //9. Tarih icin ay secin
                .sendKeys("Kas").sendKeys(Keys.TAB)
                //10. Tarih icin yil secin
                .sendKeys("2005").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                //11. Cinsiyeti secin
                .sendKeys(Keys.DOWN).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
