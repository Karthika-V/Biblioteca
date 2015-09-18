package com.tw.biblioteca;

//Biblioteca Application displays welcome message and menu for the user
public class Biblioteca {

    private ConsoleView consoleView;
    private MenuOptions menuOptions;
    private Session session;
    private MenuFactory menuFactory;

    public Biblioteca(ConsoleView consoleView, MenuOptions menuOptions, Session session, MenuFactory menuFactory) {
        this.consoleView = consoleView;
        this.menuOptions = menuOptions;
        this.session = session;
        this.menuFactory = menuFactory;
    }

    public void start() {
        consoleView.display("\nWelcome to Biblioteca\n");
        while (true) {
            run();
        }
    }

    private void run() {
        User user = session.getUser();
        consoleView.menu(menuFactory.getMenu(user.getRole()));
        menuOptions.optionHandler(consoleView.inputFromUser());
    }
}
