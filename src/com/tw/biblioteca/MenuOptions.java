package com.tw.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

//Menu gives a list of options to the user and handles the option
public class MenuOptions {

    private ArrayList<String> optionsList;
    private Library library = new Library();
    private ConsoleView consoleView = new ConsoleView();
    private Authenticator authenticator = new Authenticator();
    private Login login = new Login(authenticator, consoleView);
    private Scanner in = new Scanner(System.in);
    private User user = new User("","","","","", User.Role.GUEST);

    public MenuOptions() {
        optionsList = new ArrayList<String>();
        optionsList.add("1:List Books");
        optionsList.add("2:Check Out Book");
        optionsList.add("3:Return Book");
        optionsList.add("4:List Movies");
        optionsList.add("5:Check Out Movie");
        optionsList.add("6:Login");
        optionsList.add("7:User Details");
        optionsList.add("8:Logout");
        optionsList.add("9:Checked Out Book Details");
        optionsList.add("q:QUIT");
    }

    public void optionHandler(String option) {
        if (option.contentEquals("1")) {
            consoleView.bookList(library.displayLibraryBooks());
        } else if (option.contentEquals("q")) {
            System.exit(0);
        } else if (option.contentEquals("2")) {
            consoleView.display("Please login to proceed for the selected menu item.");
            User currentUser = login.loginOperation();
            consoleView.display("Enter the book name:");
            library.checkOutBook(in.nextLine());
        } else if (option.contentEquals("3")) {
            consoleView.display("Please login to proceed for the selected menu item.");
            User currentUser = login.loginOperation();
            consoleView.display("Enter the book name:");
            library.checkInBook(library.returnBook(in.nextLine()));
        } else if (option.contentEquals("4")) {
            consoleView.moviesList(library.displayLibraryMovies());
        } else if (option.contentEquals("5")) {
            consoleView.display("Enter the movie name:");
            library.checkOutMovie(in.nextLine());
        } else if (option.contentEquals("6")) {
            User currentUser = login.loginOperation();
        } else if (option.contentEquals("7")) {
            User currentUser = login.loginOperation();
            currentUser.displayUserDetails();
        } else
            System.out.println("Select a valid option!");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < optionsList.size(); i++) {
            stringBuilder.append(optionsList.get(i) + "\n");
        }
        return stringBuilder.toString();
    }
}
