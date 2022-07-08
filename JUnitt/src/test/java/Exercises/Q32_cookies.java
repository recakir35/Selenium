package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Q32_cookies extends TestBase {
    @Test
    public void cookiesTest() {
        //1 Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2 tum cookie’leri listeleyin
        Set<Cookie> cookies=driver.manage().getCookies();
        for (Cookie each:cookies){
            System.out.println(each.getName()+": "+each.getValue());
        }
        //3 Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookies.size()>5);
        //4 /ismi i18n prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each: cookies){
            if (each.getName().equals("i18n-prefs") ){
                Assert.assertEquals("USD",each.getValue());
                }
        }

        //5 ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        //6 eklediginiz cookie’nin sayfaya eklendigini test edin
         cookies=driver.manage().getCookies();
        for (Cookie each:cookies){
            System.out.println(each.getName()+": "+each.getValue());
            if (each.getName().equals("en sevdigim cookie")) Assert.assertTrue(each.getValue().equals("cikolatali"));
        }
        //7 ismi skin olan cookie’yi silin ve silindigini test edin
        for (Cookie each:cookies){
            if (each.getName().equals("skin")) driver.manage().deleteCookie(each);
        }
        cookies=driver.manage().getCookies();
        System.out.println("****************Skin Silindi***************************");
        for (Cookie each:cookies){
            System.out.println(each.getName()+": "+each.getValue());
        }
        //8 tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        System.out.println("****************Hepsi Silindi***************************");
        for (Cookie each:cookies){
            System.out.println(each.getName()+": "+each.getValue());

        }
    }
}
