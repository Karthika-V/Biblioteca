package com.tw.biblioteca;
//A set of users and their roles
public class Users {

    private String userName;
    private String userMail;
    private String userPhone;

    private String[] ROLES = {"User","Librarian","Guest"};

    public Users(String userName, String userMail, String userPhone) {
        this.userName = userName;
        this.userMail = userMail;
        this.userPhone = userPhone;
    }
}
