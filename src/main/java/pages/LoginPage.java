package pages;

import dto.UserDtoLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }


    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//h2[@class='message']")
    WebElement popUpMassage;

    @FindBy(xpath = "//div[@class='error']")
    WebElement errorMassage;


    public void typeLoginForm(UserDtoLombok user) {

        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());


    }

    public void clickBtnLogin() {
        pause(10);
        btnLogin.click();

    }

    public boolean isPopUpLoginMassagePresent(String text) {
        return isTextinElementPresent(popUpMassage, text);

    }

    public boolean validateErrorMassage(String text) {
        return isTextinElementPresent(errorMassage, text);

    }

}
