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


    public void openPage() {
        open("/register");
    }

    public void setUserName(String userName) {
        loginInput.setValue(userName);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordInput.setValue(password);
    }

    public void submit() {
        submitButton.click();
    }

    public void verifyErrorMessage(String message) {
        errorMessage.shouldHave(text(message));
    }
}
