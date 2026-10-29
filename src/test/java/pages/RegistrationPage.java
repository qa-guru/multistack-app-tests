package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private SelenideElement loginInput = $("[data-testid=register-login-input]");
    private SelenideElement passwordInput = $("[data-testid=register-password-input]");
    private SelenideElement confirmPasswordInput = $("[data-testid=confirm-password-input]");
    private SelenideElement submitButton = $("[data-testid=register-submit-button]");
    private SelenideElement errorMessage = $("[data-testid=register-error-message]");


    public RegistrationPage openPage() {
        open("/register");

        return this;
    }

    public RegistrationPage setUserName(String userName) {
        loginInput.setValue(userName);

        return this;
    }

    public RegistrationPage setPassword(String password) {
        passwordInput.setValue(password);

        return this;
    }

    public RegistrationPage confirmPassword(String password) {
        confirmPasswordInput.setValue(password);

        return this;
    }

    public HomePage submit() {
        submitButton.click();

        return new HomePage();
    }

    public RegistrationPage submitExceptingError() {
        submitButton.click();

        return this;
    }

    public RegistrationPage verifyErrorMessage(String message) {
        errorMessage.shouldHave(text(message));

        return this;
    }
}
