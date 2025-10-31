package service;

import exceptions.BookListEmptyException;
import exceptions.BookNotFoundException;
import exceptions.FieldNotFilledException;
import model.Book;
import model.Library;

import javax.swing.*;

public class Manager {
    private Library library;
    private static int idCounter = 0; // It must be initialized here

    public Manager() {
        this.library = new Library();
        // idCunter mustn´t be initialized here because every time
        // we create a manager, idCounter resets itself since 0
        // It might make an ID duplicated.
    }

    public void addBook(String title, String author, String yearInput, String gender) throws FieldNotFilledException {
        if (title == null || title.isBlank() ||
                author == null || author.isBlank() ||
                yearInput == null || yearInput.isBlank() ||
                gender == null || gender.isBlank()) {
            throw new FieldNotFilledException("You must fill in all the fields before adding a book");
        }

        // It has to convert the string input to integer to see if there´s any value
        // Else throw a new exception
        Integer year;
        try {
            year = Integer.parseInt(yearInput);
        } catch (NumberFormatException e) {
            throw new FieldNotFilledException("The publication year must be a valid number");
        }

        idCounter++;
        Book book = new Book(title, author, year, gender);
        book.setId(idCounter);

        this.library.getBooks().add(book);
    }

    public void deleteBook(String idInput) throws BookNotFoundException {
        // It removes the book with index id-1 because the id is 1
        // plus number than the position
        Integer id;

        try {
            id = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
            throw new FieldNotFilledException("The id must be a valid number");
        }

        if (this.library.getBookById(id) == null) {
            throw new BookNotFoundException("Book not found with ID: " + id);
        }

        this.library.getBooks().remove(id - 1);
    }

    public String listBooks() throws BookListEmptyException {
        StringBuilder list = new StringBuilder("LIBRARY COLLECTION:\n-----------------------\n");

        if (library.getBooks().isEmpty()) {
            list.append("No books registered yet\n");
            throw new BookListEmptyException("Add at least one book to see the list");
        }
        else {
            for (Book b : library.getBooks()) {
                list.append("ID: ").append(b.getId()).append("\n")
                        .append("Title: ").append(b.getTitle()).append("\n")
                        .append("Author: ").append(b.getAuthor()).append("\n")
                        .append("Year: ").append(b.getYear()).append("\n")
                        .append("Genre: ").append(b.getGender()).append("\n")
                        .append("-----------------------\n");
            }
        }

        return list.toString();
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
