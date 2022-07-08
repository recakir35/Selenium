package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {
    public BrcPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement ilklogin;

    @FindBy(xpath = "//input[@id='formBasicEmail']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement ikinciLogin;

    @FindBy(id= "dropdown-basic-button")
    public WebElement kullaniciProfilIsmi;

}
