package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;
import static utils.RandomUtils.getRandomUserName;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();

    @Test
    void successfulRegistrationTest() {
//        String randomUserName = "auto_" + getRandomString(10);
        String randomUserName = "auto_" + getRandomUserName();

        registrationPage.openPage();
        registrationPage.setUserName(randomUserName);
        registrationPage.setPassword(PASSWORD);
        registrationPage.confirmPassword(PASSWORD);
        registrationPage.submit();
        homePage.verifyWelcomeMessage(randomUserName);
    }

    @Test
    void existingUserTest() {
        registrationPage.openPage();
        registrationPage.setUserName(USERNAME);
        registrationPage.setPassword(PASSWORD);
        registrationPage.confirmPassword(PASSWORD);
        registrationPage.submit();
        registrationPage.verifyErrorMessage(EXISTING_USER_MESSAGE);
    }
}
