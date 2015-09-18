package com.tw.biblioteca;

import java.util.Scanner;

//Logs in valid user with user number and password
public class Login {

    private Scanner in = new Scanner(System.in);
    private Authenticator authenticator;
    private ConsoleView consoleView;
    private User user;
    private Session session;

    public Login(Authenticator authenticator, ConsoleView consoleView, User user, Session session)
    {
        this.authenticator = authenticator;
        this.consoleView = consoleView;
        this.user = user;
        this.session = session;
    }

    public User loginOperation() {
        consoleView.display("LOGIN");
        consoleView.display("User Library Number:");
        String inputLibraryNumber = in.nextLine();
        consoleView.display("Password:");
        String password = in.nextLine();
        user = authenticator.checkCredentials(inputLibraryNumber, password);
        session.setUser(user);
        return user;
    }


}
