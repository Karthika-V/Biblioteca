package com.tw.biblioteca;

public class ConfigMessages {

    public String bookNonAvailabilityMessage = "That book is not available";
    public String bookCheckOutMessage = "Thank You! Enjoy the Book";
    public String bookReturnMessage = "Thank You for Returning Book";
    public String invalidBookMessage = "That is not a Valid Book to Return";

    public void displayMessage(String message) {
        ConsoleView consoleView = new ConsoleView();
        consoleView.display(message);
    }

}
