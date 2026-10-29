package tests;

import org.junit.jupiter.api.Test;

import static testdata.TestData.*;


public class LoginTests extends TestBase {

    @Test
    void successfulLoginTest() {
        loginPage.openPage()
                .setUserName(USERNAME)
                .setPassword(PASSWORD)
                .submit()
                .verifyWelcomeMessage(USERNAME);
    }

    @Test
    void wrongPasswordTest() {
        loginPage.openPage()
                .setUserName(USERNAME)
                .setPassword(WRONG_PASSWORD)
                .submitExceptingError()
                .verifyErrorMessage(WRONG_CREDENTIALS_MESSAGE);
    }

    @Test
    void missingPasswordTest() {
        loginPage.openPage()
                .setUserName(USERNAME)
                .submitExceptingError()
                .verifyErrorMessage(NO_PASSWORD_MESSAGE);
    }
}
