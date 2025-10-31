package exceptions;

public class BookListEmptyException extends RuntimeException {
  public BookListEmptyException(String message) {
    super(message);
  }
}
