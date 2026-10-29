package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;
import static testdata.TestData.*;
import static utils.RandomUtils.getRandomString;
import static utils.RandomUtils.getRandomUserName;

public class RegistrationTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
//        String randomUserName = "auto_" + getRandomString(10);
        String randomUserName = "auto_" + getRandomUserName();
        String welcomeMessage = format(SUCCESSFUL_LOGIN_TEMPLATE, randomUserName);

        open("/register");
        $("[data-testid=register-login-input]").setValue(randomUserName);
        $("[data-testid=register-password-input]").setValue(PASSWORD);
        $("[data-testid=confirm-password-input]").setValue(PASSWORD).pressEnter();
        $("[data-testid=welcome-message]").shouldBe(text(welcomeMessage));
    }

    @Test
    void existingUserTest() {
        open("/register");
        $("[data-testid=register-login-input]").setValue(USERNAME);
        $("[data-testid=register-password-input]").setValue(PASSWORD);
        $("[data-testid=confirm-password-input]").setValue(PASSWORD).pressEnter();
        $("[data-testid=register-error-message]").shouldBe(text(EXISTING_USER_MESSAGE));
    }
}
