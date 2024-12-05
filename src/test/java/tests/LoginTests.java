package tests;

import dto.UserDto;
import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.Random;

public class LoginTests extends ApplicationManager {
    private String email;
    private String password;

    LoginPage loginPage;

    @BeforeMethod
    public void goToLoginPage() {
        new HomePage(getDriver()).clickBtnLoginHeader();


    }

    @Test
    public void LoginPositiveTest() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("alexmed123@gmail.com")
                .password("Qwerty123!")
                .build();

        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnLogin();


    }
@Test
    public void LoginNegativeTest_WrongEmail() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("alexmed123gmail.com")
                .password("Qwerty123!")
                .build();

        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnLogin();
        Assert.assertTrue(loginPage.validateErrorMassage("It'snot look like email"));


    }
@Test
    public void LoginNegativeTest_EmptyEmail() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("alexmed123@gmail.com")
                .password("")
                .build();

        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnLogin();
        Assert.assertTrue(loginPage.validateErrorMassage("Password is required"));


    }
}