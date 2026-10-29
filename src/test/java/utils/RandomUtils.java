package utils;

import net.datafaker.Faker;

import java.security.SecureRandom;

public class RandomUtils {

    static Faker faker = new Faker();

    public static String getRandomUserName() {
        return faker.credentials().username();
    }

    public static String getRandomString(int length) {
//        String LETTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++)
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));

        return result.toString();
    }

}
