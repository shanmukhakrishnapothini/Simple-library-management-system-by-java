import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private Map<Integer, Borrower> borrowers;

    public Library() {
        books = new ArrayList<>();
        borrowers =new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
            book.setAvailable(false);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

    private Book findBookById(int id) {
        for (Book bookRack : books) {
            if (bookRack.getId() == id) {
                return bookRack;
            }
        }
        return null;
    }
    
    public void addBorrower(Borrower borrower) {
        if (borrowers.containsKey(borrower.getId())) {
            System.out.println("Borrower with this ID already exists.");
        } else {
            borrowers.put(borrower.getId(), borrower);
            System.out.println("Borrower added successfully.");
        }
    }
    
    public void lendBook(int bookId, int borrowerId) {
        Book book = findBookById(bookId);
        Borrower borrower = borrowers.get(borrowerId);
        if (book != null && book.isAvailable() && borrower != null) {
            book.setAvailable(false);
            book.setBorrower(borrower);
            System.out.println("Book lent to " + borrower.getName() + " successfully.");
        } else if (book != null && !book.isAvailable()) {
            System.out.println("Book is currently unavailable.");
        } else if (borrower == null) {
            System.out.println("Borrower not found.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            book.setBorrower(null);
            System.out.println("Book returned successfully.");
        } else if (book != null) {
            System.out.println("Book was not lent out.");
        } else {
            System.out.println("Book not found.");
        }
    }
    
    public void displayAllBorrowers() {
        if (borrowers.isEmpty()) {
            System.out.println("No borrowers available.");
        } else {
            for (Borrower borrower : borrowers.values()) {
                System.out.println(borrower);
            }
        }
    }
}
