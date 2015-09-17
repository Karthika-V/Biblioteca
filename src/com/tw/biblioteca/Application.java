package com.tw.biblioteca;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        ConsoleView consoleView = new ConsoleView();
        MenuOptions menuOptions = new MenuOptions();
        Biblioteca biblioteca = new Biblioteca(consoleView, menuOptions);
        biblioteca.start();
    }
}
