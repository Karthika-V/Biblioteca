package com.tw.biblioteca;

import java.util.Scanner;

//MenuOptions gives a list of options to the user and handles the option
public class MenuOptions {

    private Library library;
    private ConsoleView consoleView;
    private Login login;
    private Scanner in = new Scanner(System.in);
    private Session session;
    private User user;

    public MenuOptions(Library library, ConsoleView consoleView, Login login, Session session, User user) {
        this.library = library;
        this.consoleView = consoleView;
        this.login = login;
        this.session = session;
        this.user = user;
    }

    public void optionHandler(String option) {
        if (option.contentEquals("1")) {
            consoleView.bookList(library.books());
        } else if (option.contentEquals("q")) {
            System.exit(0);
        } else if (option.contentEquals("2") && sessionCheckNotGuest()) {
            consoleView.display("Enter the book name:");
            library.checkOutBook(in.nextLine(), session.getUser());
        } else if (option.contentEquals("3") && sessionCheckNotGuest()) {
            consoleView.display("Enter the book name:");
            library.checkInBook(library.returnBook(in.nextLine(), session.getUser()));
        } else if (option.contentEquals("4")) {
            consoleView.moviesList(library.movies());
        } else if (option.contentEquals("5")) {
            consoleView.display("Enter the movie name:");
            library.checkOutMovie(in.nextLine());
        } else if (option.contentEquals("6")) {
            session.setUser(login.loginOperation());
        } else if (option.contentEquals("7")) {
            consoleView.display(session.getUser().displayUserDetails());
        } else if (option.contentEquals("8")) {
            User user = new User("", "", "", "", "", User.Role.GUEST);
            session.setUser(user);
        } else if (option.contentEquals("9")) {
            consoleView.checkedOutBookDetails(library.checkedOutBookDetails());
        } else
            System.out.println("Select a valid option!");
    }

    private boolean sessionCheckNotGuest() {
        return !session.getUser().getRole().equals(User.Role.GUEST);
    }

}
