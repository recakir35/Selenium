package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutoExercise {
    public AutoExercise() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signInLinki;

    @FindBy(xpath = "//a[@href='/contact_us']")
    public WebElement contactUs;

    @FindBy(xpath = "(//h2[@class='title text-center'])[2]")
    public WebElement contactUsGetInTouch;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement getContactUsGetInTouchName;

    @FindBy(xpath = "(//input[@class='form-control'])[2]")
    public WebElement getContactUsGetInTouchEmail;

    @FindBy(xpath = "(//input[@class='form-control'])[3]")
    public WebElement getContactUsGetInTouchSubject;

    @FindBy(xpath = "(//input[@class='form-control'])[4]")
    public WebElement getContactUsGetInTouchUploud;

    @FindBy(xpath = "//input[@class='btn btn-primary pull-left submit_form']")
    public WebElement getContactUsGetInTouchSubmit;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement getContactUsGetInTouchHataText;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    public WebElement getContactUsGetInTouchHomeButton;


    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement getContactUsGetInTouchMessage;

    @FindBy(xpath = "(//b)[1]")
    public WebElement eaiTexti;

    @FindBy(id = "id_gender1")
    public WebElement titleMr;

    @FindBy(id = "password")
    public WebElement password;


    @FindBy(xpath = "//div[@class='logo pull-left']")
    public WebElement automationExerciseIkonu;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement LTYATexti;

    @FindBy(xpath = "(//input[@type='email'])[1]")
    public WebElement LTYAEmailAdress;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement LTYAPassword;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement LTYALoginButton;

    @FindBy(xpath = "//li//a//b")
    public WebElement loginInAsUsername;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logout;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement NUSTexti;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement NUSNameBox;

    @FindBy(xpath = "(//input[@type='email'])[2]")
    public WebElement NUSEmailAdressBox;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement NUSLoginButton;

    @FindBy(xpath = "//p[@style='color: red;']")
    public WebElement NUSHataText;

}