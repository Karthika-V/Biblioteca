//Authenticator authenticates user credentials
package com.tw.biblioteca;

import java.util.ArrayList;

public class Authenticator {

    private ArrayList<User> userCredentials = new ArrayList<>();

    public ArrayList userData() {
        userCredentials.add(new User("111-1111", "qwerty", "user1", "Def@xyz.com", "100", User.Role.USER));
        userCredentials.add(new User("123-4567", "abcd", "user2", "Def@xyz.com", "100", User.Role.LIBRARIAN));
        return userCredentials;
    }

    public User checkCredentials(String inputLibraryNumber, String password) {
        User currentUser = new User(inputLibraryNumber, password, "", "", "", User.Role.GUEST);
        if (userCredentials.contains(currentUser)) {
            for (User user : userCredentials) {
                if (user.equals(currentUser)) {
                    if (user.checkPassword(currentUser)) {
                        return user;
                    }

                }
            }
        }
        return currentUser;
    }
}
