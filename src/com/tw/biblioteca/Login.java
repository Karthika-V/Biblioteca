package com.tw.biblioteca;

import java.util.Scanner;

//Logs in valid user with user number and password
public class Login {

    private Scanner in = new Scanner(System.in);
    private Authenticator authenticator;
    private ConsoleView consoleView;

    public Login(Authenticator authenticator, ConsoleView consoleView)
    {
        this.authenticator = authenticator;
        this.consoleView = consoleView;
    }

    public User loginOperation() {
        consoleView.display("LOGIN");
        consoleView.display("User Library Number:");
        String inputLibraryNumber = in.nextLine();
        consoleView.display("Password:");
        String password = in.nextLine();
        return authenticator.checkCredentials(inputLibraryNumber, password);
    }


}
