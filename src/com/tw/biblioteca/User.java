package com.tw.biblioteca;

//A set of users and their roles
public class User {

    private String userLibraryNumber;
    private String password;
    private String userName;
    private String userMail;
    private String userPhone;
    private Role userRole;

    public Role getRole() {
        return userRole;
    }

    public enum Role { USER, LIBRARIAN, GUEST};

    public User(String userLibraryNumber, String password, String userName, String userMail, String userPhone, Role userRole) {
        this.userLibraryNumber = userLibraryNumber;
        this.password = password;
        this.userName = userName;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.userRole = userRole;
    }

    public String displayUserDetails() {
        return (String.format("Library Number:%s\n" +
                " User Name:%s\n" +
                " User Mail:%s\n" +
                " Phone Number:%s\n" +
                " Role:%s\n", this.userLibraryNumber, this.userName, this.userMail, this.userPhone, this.userRole ));
    }

    public boolean checkPassword(User newUser) {
        return (this.password.equals(newUser.password));
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        User user = (User) that;
        if (!userLibraryNumber.equals(user.userLibraryNumber)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return userLibraryNumber.hashCode();
    }
}
