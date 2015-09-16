package com.tw.biblioteca;

//Biblioteca Application launches the application
public class BibliotecaApplication {

    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.start();
    }

    public void start() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.display("Welcome to Biblioteca");
        while(true) {
            consoleView.menuView();
            String input = consoleView.inputFromUser();
            MenuOptions menuOptions = new MenuOptions();
            menuOptions.optionHandler(input);
        }
    }
}
