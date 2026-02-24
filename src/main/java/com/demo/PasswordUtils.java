package com.demo;

import java.util.Random;

public class PasswordUtils {

    public static String generatePassword() {

        Random random = new Random(); // ❌ Insecure random
        String password = "";

        for (int i = 0; i < 6; i++) {
            password += random.nextInt(10); // ❌ String concat in loop
        }

        return password;
    }
}
