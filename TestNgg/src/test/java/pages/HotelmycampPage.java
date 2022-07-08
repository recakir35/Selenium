package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelmycampPage {
    public HotelmycampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='nav-link'])[7]")
    public WebElement loginLinki;

    @FindBy(id = "UserName")
    public WebElement userNameBox;

    @FindBy(id = "Password")
    public WebElement userPasswordBox;

    @FindBy(id="btnSubmit")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement loginName;

    @FindBy (xpath = "//*[text()='Hotel Management']")
    public WebElement HManagementLinki;

    @FindBy(xpath = "(//a[@href='/admin/HotelAdmin'])[1]")
    public WebElement hotelListLinki;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement ADDHotelButonu;

    @FindBy(id = "Code")
    public WebElement codeBox;

    @FindBy(id = "IDGroup")
    public WebElement idGroup;

    @FindBy(id = "btnSubmit")
    public WebElement saveTusu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement mesajKutusuText;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement mesajButton;

}
