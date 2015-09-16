package com.tw.biblioteca;

import java.util.HashMap;

public class Authenticator {

    private HashMap<String, String> credentials = new HashMap();

    public HashMap userData() {
        credentials.put("123-4567", "qwerty");
        credentials.put("111-1111", "abcd");
        return credentials;
    }

}
