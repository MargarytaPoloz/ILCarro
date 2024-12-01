package pages;

import dto.UserDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement labelCheck;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnRegistration;
    @FindBy(xpath = "//button[@type='button']")
    WebElement btnOk;


    public void typeRegistrationForm(String name, String lastName, String email, String password) {
        inputName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        labelCheck.click();
        btnRegistration.click();
        btnOk.click();


    }

    public void typeRegistrationForm(UserDto user) {
        inputName.sendKeys(user.getName());
        inputLastName.sendKeys(user.getLastname());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        labelCheck.click();
        btnRegistration.click();
        btnOk.click();


    }
}
