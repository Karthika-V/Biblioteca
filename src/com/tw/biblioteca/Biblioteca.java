package com.tw.biblioteca;

//Biblioteca Application displays welcome message and menu for the user
public class Biblioteca {

    private ConsoleView consoleView;
    private MenuOptions menuOptions;
    private User user;
    private Session session;

    public Biblioteca(ConsoleView consoleView, MenuOptions menuOptions, User user, Session session) {
        this.consoleView = consoleView;
        this.menuOptions = menuOptions;
        this.user = user;
        this.session = session;
    }

    public void start() {
        consoleView.display("\nWelcome to Biblioteca\n");
        while (true) {
            run();
        }
    }

    private void run() {
        User user = session.getUser();
        consoleView.menu();
        menuOptions.optionHandler(consoleView.inputFromUser());
    }
}
