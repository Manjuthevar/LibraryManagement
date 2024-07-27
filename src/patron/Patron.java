package patron;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private int patronID;
    private List<String> borrowedBooks;

    public Patron(String name, int patronID) {
        this.name = name;
        this.patronID = patronID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPatronID() {
        return patronID;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(String ISBN) {
        borrowedBooks.add(ISBN);
    }

    public void returnBook(String ISBN) {
        borrowedBooks.remove(ISBN);
    }
}
