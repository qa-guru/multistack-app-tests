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


    public void openPage() {
        open("/login");
    }

    public void setUserName(String userName) {
        loginInput.setValue(userName);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void submit() {
        submitButton.click();
    }

    public void verifyErrorMessage(String message) {
        errorMessage.shouldHave(text(message));
    }
}
