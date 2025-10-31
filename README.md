# Library Management System (Java + Swing)

A simple yet well-structured **Java application** for managing a small library collection.  
This project focuses on **Object-Oriented Programming (OOP)**, **custom exception handling**, and **clean separation of business logic**.  
It does **not use a database** — all data is stored in memory using collections.

---

## Features

- Add new books (auto-incremented ID)  
- List all registered books  
- Search a book by **ID**  
- Search a book by **author**  
- Delete a book by **ID**  
- Input validation and custom runtime exceptions  
- User interaction through **Swing’s `JOptionPane` dialogs**

---

## Technologies Used

- **Java 21**
- **Swing** for GUI dialogs
- **Collections (ArrayList)** for in-memory storage
- **Custom exceptions** for runtime validation

---

## Project Structure

src/
├── app/
│ └── Main.java → Entry point; menu logic
├── model/
│ ├── Book.java → Represents a book
│ └── Library.java → Manages the book list
├── service/
│ └── Manager.java → Handles all CRUD operations
└── exceptions/
├── FieldNotFilledException.java
├── BookNotFoundException.java
├── AuthorNotFoundException.java
└── BookListEmptyException.java

---

## How It Works

When you run `Main.java`, a menu appears using `JOptionPane` dialogs:

MAIN MENU:
- Add book

- List all books

- Search book by ID

- Search book by author

- Delete book by ID

- Exit

Each option calls the corresponding method in the **Manager** class, which validates user input and interacts with the `Library` collection.

### Example — Adding a Book
1. Choose option **1**.
2. Enter:
    - Title
    - Author
    - Year
    - Genre
3. If any field is empty, a `FieldNotFilledException` is thrown and a message is shown.

---

## Exception Handling

The system includes several **custom exceptions** to keep UI and business logic separated:

| Exception | Description |
|------------|-------------|
| `FieldNotFilledException` | Triggered when any field is blank while adding a book. |
| `BookNotFoundException` | Thrown when a book with a specific ID doesn’t exist. |
| `AuthorNotFoundException` | Raised when no book matches the given author. |
| `BookListEmptyException` | Appears when trying to list books but the library is empty. |

---

## Design Notes

- The **Manager** acts as a bridge between user input and business rules.
- The **Library** stores the data but does not manage it directly.
- This ensures **clean separation of concerns**, making it easier to expand (for example, adding a database later).

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/JacoboAP1/library_manager.git
Open the project in IntelliJ IDEA or any IDE that supports Java 17+.

Run:

src/app/Main.java
Interact through the pop-up dialogs to manage your library collection.

Author: Jacobo Arroyave Pérez
- Systems Engineering Student
- Passionate about backend development, OOP, and education
- Languages: English (B1+)| Français (learning)| Português (learning| Español (maternal)

If you found this project useful, consider giving it a star on GitHub!