package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WDUniversityPage {
    public WDUniversityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//h1)[3]")
    public WebElement loginPortalLinkElementi;

    @FindBy(xpath = "//input[@placeholder='Username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@id='nav-title']")
    public WebElement ilksayfaBarElementi;
}
