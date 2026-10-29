package testdata;

import static java.lang.String.format;

public class TestData {
    public static final String LOGIN = "user1";
    public static final String PASSWORD = "password1";
    public static final String WRONG_PASSWORD = "1244351341";

    // Login page
    public static final String SUCCESSFUL_LOGIN_TEMPLATE = "Welcome, %s!";
    public static final String SUCCESSFUL_LOGIN_MESSAGE = format(SUCCESSFUL_LOGIN_TEMPLATE, LOGIN);
    public static final String WRONG_CREDENTIALS_MESSAGE = "1244351341";
    public static final String NO_PASSWORD_MESSAGE = "Password is required (minimum 6 characters)";

    // Registration page
    public static final String EXISTING_USER_MESSAGE = "Username already taken";
}

