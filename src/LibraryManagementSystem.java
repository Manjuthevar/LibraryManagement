import book.Book;
import library.Library;
import patron.Patron;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding some books
        library.addBook(new Book("Sherlock Homes", "Arthur Conan Doyle", "123450", 1949));
        library.addBook(new Book("Here There and Everywhere","Sudha Murthy","123451",2018));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "123452", 1960));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "123453", 1925));

        // Adding some patrons
        library.addPatron(new Patron("Vanisha", 1));
        library.addPatron(new Patron("Karthigan", 2));
        library.addPatron(new Patron("Velayudhan", 3));

        // Checkout and return a book
        library.checkoutBook("123450", 1); // Vanisha borrows "1984"
        library.returnBook("123450", 1); // Vanisha returns "1984"

        // Searching books
        List<Book> searchResults = library.searchBooks("Homes");
        for (Book book : searchResults) {
            System.out.println(book);
        }

        // Display available books
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }
}