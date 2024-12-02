package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;


import java.util.Random;

public class LoginTests extends ApplicationManager {
    private String email;
    private String password;


    @BeforeMethod
    public void Registration() {

        int i = new Random().nextInt(1000);
        email = "polozmargaryta" + i + "@gmail.com";
        password = "Password123@";
        new HomePage(getDriver()).clickBtnRegistrationHeader();
        //new RegistrationPage(getDriver()).typeRegistrationForm(user);


    }

    @Test

    public void LoginPositiveTest() {

        int i = new Random().nextInt(1000);
        UserDto user = new UserDto("name", "last_name", email, password);
        new HomePage(getDriver()).clickBtnLoginHeader();
        new LoginPage(getDriver()).typeLoginForm(user);
    }
}