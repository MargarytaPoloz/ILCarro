package pages;

import dto.UserDto;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy//(xpath = "//input[@id='name']")
            (id = "name")
    WebElement inputName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement checkBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement popUpMassage;
   // @FindBy(xpath = "//div[@class='dialog-container']/h2")
    //WebElement errorMassage;
    @FindBy(xpath = "//div[@class='error']")
    WebElement errorMassage;



    public void typeRegistrationForm1(UserDtoLombok user) {
        inputName.sendKeys(user.getName());
        inputLastName.sendKeys(user.getLastname());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
    }

    public void clickCheckBox() {
        //checkBox.click();
        System.out.println(checkBox.getRect().getWidth() + "X" + checkBox.getRect().getHeight());
        int widthCheckBox = checkBox.getRect().getWidth();
        int heightCheckBox = checkBox.getRect().getHeight();
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox, -widthCheckBox / 3, -heightCheckBox / 4).click().perform();
    }


    public void clickCBtnYalla() {
        btnYalla.click();
    }

    public boolean isPopUpMassagePresent() {
        return isTextinElementPresent(popUpMassage, "You are logged in success");

    }
    public boolean isPopUpMassagePresent(String text) {
        return isTextinElementPresent(popUpMassage, text);

    }

    public boolean validateErrorMassage(String text) {
        return isTextinElementPresent(errorMassage, text);
    }

    public boolean btnYallaIsDisabled(){
      return !btnYalla.isEnabled();
    }
}