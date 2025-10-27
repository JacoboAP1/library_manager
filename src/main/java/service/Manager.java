package service;

import model.Book;
import model.Library;

public class Manager {
    private Library library;
    private static int idCounter = 0; // It must be initialized here

    public Manager() {
        this.library = new Library();
        // idCunter mustn´t be initialized here because every time
        // we create a manager, idCounter resets itself since 0
        // It might make an ID duplicated.
    }

    public void addBook(Book book) {
        idCounter++;
        book.setId(idCounter);
        book.setTitle(book.getTitle());
        book.setYear(book.getYear());
        book.setAuthor(book.getAuthor());
        book.setGender(book.getGender());
        this.library.getBooks().add(book);
    }

    public void deleteBook(int id) {
        // It removes the book with index id-1 because the id is 1
        // plus number than the position
        this.library.getBooks().remove(id - 1);
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
