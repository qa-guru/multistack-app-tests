package tests;

import org.junit.jupiter.api.Test;

import static testdata.TestData.*;
import static utils.RandomUtils.getRandomUserName;

public class RegistrationTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
//        String randomUserName = "auto_" + getRandomString(10);
        String randomUserName = "auto_" + getRandomUserName();

        registrationPage.openPage()
                .setUserName(randomUserName)
                .setPassword(PASSWORD)
                .confirmPassword(PASSWORD)
                .submit()
                .verifyWelcomeMessage(randomUserName);
    }

    @Test
    void existingUserTest() {
        registrationPage.openPage()
                .setUserName(USERNAME)
                .setPassword(PASSWORD)
                .confirmPassword(PASSWORD)
                .submitExceptingError()
                .verifyErrorMessage(EXISTING_USER_MESSAGE);
    }
}
