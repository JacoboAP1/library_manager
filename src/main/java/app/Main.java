package app;

import exceptions.AuthorNotFoundException;
import exceptions.BookListEmptyException;
import exceptions.BookNotFoundException;
import exceptions.FieldNotFilledException;
import model.Book;
import service.Manager;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        JOptionPane.showMessageDialog(null,
                "Welcome to the Library Management System!\n");

        while (true) {
            String option = JOptionPane.showInputDialog("""
                    MAIN MENU
                    -----------------------
                    1. Add book
                    2. List all books
                    3. Search book by ID
                    4. Search book by author
                    5. Delete book by ID
                    6. Exit
                    -----------------------
                    Enter your option:
                    """);

            if (option == null) {
                JOptionPane.showMessageDialog(null, "Exiting system...");
                System.exit(0);
            }

            switch (option) {
                case "1" -> {
                    try {
                        String title = JOptionPane.showInputDialog("Enter book title:");
                        String author = JOptionPane.showInputDialog("Enter author name:");
                        // The year is String because the input from the client is a String
                        // We convert it to Integer in the manager to check the value
                        String year = JOptionPane.showInputDialog("Enter publication year:");
                        String genre = JOptionPane.showInputDialog("Enter book gender:");

                        manager.addBook(title, author, year, genre);

                        JOptionPane.showMessageDialog(null, "Book added successfully!");
                    } catch (FieldNotFilledException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                case "2" -> {
                    try {
                        JOptionPane.showMessageDialog(null, manager.listBooks());
                    } catch (BookListEmptyException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                case "3" -> {
                    try {
                        Integer id = Integer.parseInt(JOptionPane.showInputDialog("Enter book ID:"));
                        Book book = manager.getLibrary().getBookById(id);
                        JOptionPane.showMessageDialog(null, "Book found successfully --> " + "\nId: " + book.getId()
                                + "\nTitle: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\nYear of pub: " + book.getYear() + "\nGender: " + book.getGender());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Enter a valid id format", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (BookNotFoundException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                case "4" -> {
                    try {
                        String author = JOptionPane.showInputDialog("Enter book author:");
                        Book book = manager.getLibrary().getBookByAuthor(author);
                        JOptionPane.showMessageDialog(null, "Book found successfully --> " + "\nId: " + book.getId()
                                + "\nTitle: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\nYear of pub: " + book.getYear() + "\nGender: " + book.getGender());
                    } catch (AuthorNotFoundException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                case "5" -> {
                    try {
                        String idToDelete = JOptionPane.showInputDialog("Enter book ID to delete:");
                        manager.deleteBook(idToDelete);
                        JOptionPane.showMessageDialog(null, "Book deleted successfully (ID: " + idToDelete + ")");
                    } catch (BookNotFoundException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                case "6" -> {
                    JOptionPane.showMessageDialog(null, "Exiting system...");
                    System.exit(0);
                }

                default -> JOptionPane.showMessageDialog(null, "Invalid option, please try again");
            }
        }
    }
}
