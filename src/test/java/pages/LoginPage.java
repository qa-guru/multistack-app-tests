package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement loginInput = $("[data-testid=login-input]");
    private SelenideElement passwordInput = $("[data-testid=password-input]");
    private SelenideElement submitButton = $("[data-testid=submit-button]");
    private SelenideElement errorMessage = $("[data-testid=error-message]");


    public LoginPage openPage() {
        open("/login");

        return this;
    }

    public LoginPage setUserName(String userName) {
        loginInput.setValue(userName);

        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);

        return this;
    }

    public HomePage submit() {
        submitButton.click();

        return new HomePage();
    }

    public LoginPage submitExceptingError() {
        submitButton.click();

        return this;
    }

    public LoginPage verifyErrorMessage(String message) {
        errorMessage.shouldHave(text(message));

        return this;
    }
}
