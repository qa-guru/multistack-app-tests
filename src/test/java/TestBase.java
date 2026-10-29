import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://autotests.ai/stack/" +
                "backend-java-spring/frontend-typescript-react";
    }
}
