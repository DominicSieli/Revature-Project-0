package com.revature.utilities;

public class Encryption {
    public static String hashString(String rawString) {
        int hash = 0;

        for(char chr : rawString.toCharArray()) {
            hash += (int)chr;
        }

        return String.valueOf(hash % 10000);
    }
}