package com.tw.biblioteca;

//Biblioteca Application displays welcome message and menu for the user
public class Biblioteca {

    private ConsoleView consoleView;
    private MenuOptions menuOptions;
    private User user;

    public Biblioteca(ConsoleView consoleView, MenuOptions menuOptions, User user) {
        this.consoleView = consoleView;
        this.menuOptions = menuOptions;
        this.user = user;
    }

    public void start() {
        consoleView.display("\nWelcome to Biblioteca\n");
        while (true) {
            run();
        }
    }

    private void run() {
        consoleView.menu();
        menuOptions.optionHandler(consoleView.inputFromUser());
    }
}
