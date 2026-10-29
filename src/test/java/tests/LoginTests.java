package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TestData.*;


public class LoginTests extends TestBase {

    @Test
    void successfulLoginTest() {
        open("/login");
        $("[data-testid=login-input]").setValue(LOGIN);
        $("[data-testid=password-input]").setValue(PASSWORD).pressEnter();
        $("[data-testid=welcome-message]").shouldBe(text(SUCCESSFUL_LOGIN_MESSAGE));
    }

    @Test
    void wrongPasswordTest() {
        open("/login");
        $("[data-testid=login-input]").setValue(LOGIN);
        $("[data-testid=password-input]").setValue(WRONG_PASSWORD).pressEnter();
        $("[data-testid=error-message]").shouldBe(text(WRONG_CREDENTIALS_MESSAGE));
    }

    @Test
    void missingPasswordTest() {
        open("/login");
        $("[data-testid=login-input]").setValue(LOGIN).pressEnter();
        $("[data-testid=error-message]").shouldBe(text(NO_PASSWORD_MESSAGE));
    }
}
