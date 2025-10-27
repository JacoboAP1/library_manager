package app;

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

            switch (option) {
                case "1" -> {
                    String title = JOptionPane.showInputDialog("Enter book title:");
                    String author = JOptionPane.showInputDialog("Enter author name:");
                    int year = Integer.parseInt(JOptionPane.showInputDialog("Enter publication year:"));
                    String genre = JOptionPane.showInputDialog("Enter book genre:");

                    Book book = new Book(title, author, year, genre);
                    manager.addBook(book);

                    JOptionPane.showMessageDialog(null, "Book added successfully!");
                }

                case "2" -> {
                    StringBuilder list = new StringBuilder("LIBRARY COLLECTION:\n-----------------------\n");
                    for (Book b : manager.getLibrary().getBooks()) {
                        list.append(b).append("\n-----------------------\n");
                    }
                    JOptionPane.showMessageDialog(null, list.toString());
                }

                case "3" -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter book ID:"));
                    boolean found = false;
                    for (Book b : manager.getLibrary().getBooks()) {
                        if (b.getId() == id) {
                            JOptionPane.showMessageDialog(null, "Book found:\n\n" + b);
                            found = true;
                            break;
                        }
                    }
                    if (!found) JOptionPane.showMessageDialog(null, "No book found with ID " + id);
                }

                case "4" -> {
                    String searchAuthor = JOptionPane.showInputDialog("Enter author name:");
                    boolean found = false;
                    for (Book b : manager.getLibrary().getBooks()) {
                        if (b.getAuthor().equalsIgnoreCase(searchAuthor)) {
                            JOptionPane.showMessageDialog(null, "Book found:\n\n" + b);
                            found = true;
                        }
                    }
                    if (!found) JOptionPane.showMessageDialog(null, "No books found by author " + searchAuthor);
                }

                case "5" -> {
                    int idToDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter book ID to delete:"));
                    manager.deleteBook(idToDelete);
                    JOptionPane.showMessageDialog(null, "Book deleted successfully (ID: " + idToDelete + ")");
                }

                case "6" -> {
                    JOptionPane.showMessageDialog(null, "Exiting system...");
                    System.exit(0);
                }

                default -> JOptionPane.showMessageDialog(null, "Invalid option, please try again.");
            }
        }
    }
}
