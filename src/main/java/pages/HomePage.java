package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        setDriver(driver);
        driver.get("https://ilcarro.web.app/");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//a[@href = '/login?url=%2Fsearch']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[@href='/registration?url=%2Fsearch']")
    WebElement btnRegistration;

    public void clickBtnLoginHeader() {
        btnLogin.click();
        pause(3);


    }

    public void clickBtnRegistrationHeader() {
        btnRegistration.click();
        pause(3);


    }
}
