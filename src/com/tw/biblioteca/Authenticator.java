package com.tw.biblioteca;

import java.util.HashMap;
//Authenticator authenticates user credentials
public class Authenticator {

    private HashMap<String, String> credentials = new HashMap();

    public HashMap userData() {
        credentials.put("123-4567", "qwerty");
        credentials.put("111-1111", "abcd");
        return credentials;
    }

    public void checkCredentials(String inputLibraryNumber, String password) {
        if(userData().get(inputLibraryNumber).equals(password)) {
            System.out.println("Login Successful");
        }
    }

}