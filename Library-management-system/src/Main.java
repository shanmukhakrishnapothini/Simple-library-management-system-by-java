import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Library Management System");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Search Book by Title");
                System.out.println("4. Display All Books");
                System.out.println("5. Add Borrower");
                System.out.println("6. Lend Book");
                System.out.println("7. Return Book");
                System.out.println("8. Display All Borrowers");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter book id: ");
                        int bookId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scanner.nextLine();
                        Book book = new Book(bookId, title, author);
                        library.addBook(book);
                        break;
                    case 2:
                        System.out.print("Enter book id to remove: ");
                        int removeId = scanner.nextInt();
                        library.removeBook(removeId);
                        break;
                    case 3:
                        System.out.print("Enter book title to search: ");
                        String searchTitle = scanner.nextLine();
                        library.searchBookByTitle(searchTitle);
                        break;
                    case 4:
                        library.displayAllBooks();
                        break;
                    case 5:
                        System.out.print("Enter borrower id: ");
                        int borrowerId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter borrower name: ");
                        String borrowerName = scanner.nextLine();
                        Borrower borrower = new Borrower(borrowerId, borrowerName);
                        library.addBorrower(borrower);
                        break;
                    case 6:
                        System.out.print("Enter book id to lend: ");
                        int lendBookId = scanner.nextInt();
                        System.out.print("Enter borrower id: ");
                        int lendBorrowerId = scanner.nextInt();
                        library.lendBook(lendBookId, lendBorrowerId);
                        break;
                    case 7:
                        System.out.print("Enter book id to return: ");
                        int returnBookId = scanner.nextInt();
                        library.returnBook(returnBookId);
                        break;
                    case 8:
                        library.displayAllBorrowers();
                        break;
                    case 9:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
