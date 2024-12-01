package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void RegistrationPositiveTest() {
        int i = new Random().nextInt(1000);
        UserDto user = new UserDto("Margaryta", "Poloz", "polozmargaryta" + i + "@gmail.com", "Password123@");
        new HomePage(getDriver()).clickBtnRegistrationHeader();
        new RegistrationPage(getDriver()).typeRegistrationForm(user);


    }
}
