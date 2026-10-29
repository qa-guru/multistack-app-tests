import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests extends TestBase {

    @Test
    void successfulLoginTest() {
        open("/login");
        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("password1").pressEnter();
        $("[data-testid=welcome-message]").shouldBe(text("Welcome, user1!"));
    }

    @Test
    void wrongPasswordTest() {
        open("/login");
        $("[data-testid=login-input]").setValue("user1");
        $("[data-testid=password-input]").setValue("WRONGPASSWORD").pressEnter();
        $("[data-testid=error-message]").shouldBe(text("Wrong login or password"));
    }

    @Test
    void missingPasswordTest() {
        open("/login");
        $("[data-testid=login-input]").setValue("user1").pressEnter();
        $("[data-testid=error-message]").shouldBe(text("Password is required (minimum 6 characters)"));
    }
}
