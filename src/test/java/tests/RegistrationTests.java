package tests;

import dto.UserDto;
import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {
    RegistrationPage registrationPage;

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Bob")
                .lastname("Doe")
                .email(i + "bob_mail@gmail.com")
                .password("PAss123!")
                .build();
        new HomePage(getDriver()).clickBtnRegistrationHeader();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm1(user);
        registrationPage.clickCheckBox();
        registrationPage.clickCBtnYalla();
        Assert.assertTrue(registrationPage.isPopUpMassagePresent());

    }

}
