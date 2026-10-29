package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class HomePage {

    private SelenideElement welcomeMessage = $("[data-testid=welcome-message]");

    public static final String SUCCESSFUL_LOGIN_TEMPLATE = "Welcome, %s!";


    public void verifyWelcomeMessage(String username) {
        welcomeMessage.shouldHave(text(
                format(SUCCESSFUL_LOGIN_TEMPLATE, username)));
    }

}
