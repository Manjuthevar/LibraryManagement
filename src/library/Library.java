package library;

import book.Book;
import patron.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> inventory;
    private Map<Integer, Patron> patrons;

    public Library() {
        this.inventory = new HashMap<>();
        this.patrons = new HashMap<>();
    }

    // book.Book Management
    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
    }

    public void removeBook(String ISBN) {
        inventory.remove(ISBN);
    }

    public Book findBookByISBN(String ISBN) {
        return inventory.get(ISBN);
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query) || book.getISBN().equals(query)) {
                results.add(book);
            }
        }
        return results;
    }

    // patron.Patron Management
    public void addPatron(Patron patron) {
        patrons.put(patron.getPatronID(), patron);
    }

    public void updatePatron(int patronID, Patron updatedPatron) {
        patrons.put(patronID, updatedPatron);
    }

    // Lending Process
    public void checkoutBook(String ISBN, int patronID) {
        Book book = inventory.get(ISBN);
        if (book != null && book.isAvailable() && patrons.containsKey(patronID)) {
            book.setAvailable(false);
            patrons.get(patronID).borrowBook(ISBN);
            System.out.println("book.Book checked out successfully.");
        } else {
            System.out.println("Checkout failed: book.Book is not available or patron.Patron does not exist.");
        }
    }

    public void returnBook(String ISBN, int patronID) {
        Book book = inventory.get(ISBN);
        if (book != null && !book.isAvailable() && patrons.containsKey(patronID)) {
            book.setAvailable(true);
            patrons.get(patronID).returnBook(ISBN);
            System.out.println("book.Book returned successfully.");
        } else {
            System.out.println("Return failed: book.Book is not borrowed or patron.Patron does not exist.");
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : inventory.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
