package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;

public class RegistrationTests extends TestBase {

    @Test
    @Disabled("todo: add random username generation")
    void successfulRegistrationTest() {
        open("/register");
        $("[data-testid=register-login-input]").setValue("todo");
        $("[data-testid=register-password-input]").setValue(PASSWORD);
        $("[data-testid=confirm-password-input]").setValue(PASSWORD).pressEnter();
        $("[data-testid=welcome-message]").shouldBe(text(SUCCESSFUL_LOGIN_MESSAGE));
    }

    @Test
    void existingUserTest() {
        open("/register");
        $("[data-testid=register-login-input]").setValue(LOGIN);
        $("[data-testid=register-password-input]").setValue(PASSWORD);
        $("[data-testid=confirm-password-input]").setValue(PASSWORD).pressEnter();
        $("[data-testid=register-error-message]").shouldBe(text(EXISTING_USER_MESSAGE));
    }
}
