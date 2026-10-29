package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static testdata.TestData.*;


public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    void successfulLoginTest() {
        loginPage.openPage();
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.submit();
        homePage.verifyWelcomeMessage(USERNAME);
    }

    @Test
    void wrongPasswordTest() {
        loginPage.openPage();
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(WRONG_PASSWORD);
        loginPage.submit();
        loginPage.verifyErrorMessage(WRONG_CREDENTIALS_MESSAGE);
    }

    @Test
    void missingPasswordTest() {
        loginPage.openPage();
        loginPage.setUserName(USERNAME);
        loginPage.submit();
        loginPage.verifyErrorMessage(NO_PASSWORD_MESSAGE);
    }
}
