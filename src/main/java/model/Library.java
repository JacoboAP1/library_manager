package model;

import exceptions.AuthorNotFoundException;
import exceptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(Integer id) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found with id " + id);
    }

    public Book getBookByAuthor(String author) throws AuthorNotFoundException {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        throw new AuthorNotFoundException("Book not found with author " + author);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}