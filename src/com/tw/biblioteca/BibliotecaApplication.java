package com.tw.biblioteca;

//Biblioteca Application launches Biblioteca
public class BibliotecaApplication {


    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.run();
    }

    private void run() {
        ConsoleView consoleView = new ConsoleView();
        MenuOptions menuOptions = new MenuOptions();
        MenuFactory menuFactory = new MenuFactory();
        User user = new User("", "", "", "", "", User.Role.GUEST);
        Session session = new Session(user);
        Biblioteca biblioteca = new Biblioteca(consoleView, menuOptions, session, menuFactory);
        biblioteca.start();
    }
}
