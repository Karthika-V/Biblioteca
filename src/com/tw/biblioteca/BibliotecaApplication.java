package com.tw.biblioteca;

//Biblioteca Application displays welcome message and menu for the user
public class BibliotecaApplication {

    private ConsoleView consoleView = new ConsoleView();
    private MenuOptions menuOptions = new MenuOptions();

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }

    private void start() {
        consoleView.display("Welcome to Biblioteca");
        while (true) {
            consoleView.menuView();
            menuOptions.optionHandler(consoleView.inputFromUser());
        }
    }
}
