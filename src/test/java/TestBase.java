import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

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
