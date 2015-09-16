package com.tw.biblioteca;

import java.util.Scanner;

//Logs in valid user with user number and password
public class Login {

    Scanner in = new Scanner(System.in);
    private String inputLibraryNumber;
    private String password;
    Authenticator authenticator = new Authenticator();
    ConsoleView consoleView = new ConsoleView();

    public void loginOperation() {
        consoleView.display("LOGIN");
        consoleView.display("User Library Number:");
        inputLibraryNumber = in.nextLine();
        consoleView.display("Password:");
        password = in.nextLine();
        if (isValidLibraryNumber(inputLibraryNumber)) {
            authenticator.checkCredentials(inputLibraryNumber, password);
        }
    }

    public boolean isValidLibraryNumber(String number) {
        String[] tokens = number.split("-");
        if (tokens[0].length() == 3 && tokens[1].length() == 4) {
            return true;
        }
        return false;
    }
}
