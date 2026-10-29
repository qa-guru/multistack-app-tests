package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage = new RegistrationPage();
    HomePage homePage = new HomePage();


    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://autotests.ai/stack/" +
                "backend-java-spring/frontend-typescript-react";
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }
    
    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}
