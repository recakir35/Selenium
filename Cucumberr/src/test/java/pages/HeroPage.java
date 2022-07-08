package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HeroPage {
    public HeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@onclick='addElement()']")
    public WebElement addButton;

    @FindBy(xpath = "//button[@onclick='deleteElement()']")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@class='added-manually']")
    public List<WebElement> deleteListesi;
}
