package tests;

import dto.UserDto;
import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
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

    @Test
    public void RegistrationNegativeTest_EmptyName() {
        UserDtoLombok user = UserDtoLombok.builder()
                .name("")
                .lastname("Doe")
                .email("bob_mail@gmail.com")
                .password("PAss123!")
                .build();

        new HomePage(getDriver()).clickBtnRegistrationHeader();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm1(user);
        registrationPage.clickCheckBox();
        registrationPage.clickCBtnYalla();
        Assert.assertTrue(registrationPage.validateErrorMassage("Name is required"));
    }

    @Test
    public void RegistrationNegativeTest_WrongLastName() {
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Bob")
                .lastname(" ")
                .email("bob_mail@gmail.com")
                .password("PAss123!")
                .build();
        new HomePage(getDriver()).clickBtnRegistrationHeader();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm1(user);
        registrationPage.clickCheckBox();
        registrationPage.clickCBtnYalla();
        Assert.assertTrue(registrationPage.isPopUpMassagePresent("must not be blank"));

    }

    @Test
    public void RegistrationNegativeTest_WrongEmail() {
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Bob")
                .lastname("Doe")
                .email("bob_mailgmail.com")
                .password("PAss123!")
                .build();

        new HomePage(getDriver()).clickBtnRegistrationHeader();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm1(user);
        registrationPage.clickCheckBox();
        registrationPage.clickCBtnYalla();
        Assert.assertTrue(registrationPage.validateErrorMassage("Wrong email format"));
    }

    @Test
    public void RegistrationNegativeTest_WrongPassword() {
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Bob")
                .lastname("Doe")
                .email("bob_mail@gmail.com")
                .password("PAss123")
                .build();

        new HomePage(getDriver()).clickBtnRegistrationHeader();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm1(user);
        registrationPage.clickCheckBox();
        registrationPage.clickCBtnYalla();
        Assert.assertTrue(registrationPage.validateErrorMassage("Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]"));
    }

    @Test
    public void RegistrationNegativeTest_NotPush_CheckBox() {
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Bob")
                .lastname("Doe")
                .email("bob_mail@gmail.com")
                .password("PAss123!")
                .build();
        new HomePage(getDriver()).clickBtnRegistrationHeader();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm1(user);
        registrationPage.clickCBtnYalla();
        Assert.assertTrue(registrationPage.btnYallaIsDisabled());
    }
}
