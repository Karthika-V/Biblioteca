package com.tw.biblioteca;

//Biblioteca Application launches Biblioteca
public class BibliotecaApplication {


    public static void main(String[] args) {
        BibliotecaApplication bibliotecaApplication = new BibliotecaApplication();
        bibliotecaApplication.run();
    }

    private void run() {
        Library library = new Library();
        ConsoleView consoleView = new ConsoleView();
        Authenticator authenticator = new Authenticator();
        User user = new User("", "", "", "", "", User.Role.GUEST);
        Session session = new Session(user);
        Login login = new Login(authenticator, consoleView, user,session);
        MenuOptions menuOptions = new MenuOptions(library, consoleView, login, session, user);
        MenuFactory menuFactory = new MenuFactory();

        Biblioteca biblioteca = new Biblioteca(consoleView, menuOptions, session, menuFactory);
        biblioteca.start();
    }
}
