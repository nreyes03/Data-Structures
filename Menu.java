import java.util.*;
public class Menu {
    private static final int QUIT = 0;
    private static final int LIST_BOOKS = 1;
    private static final int CHECKOUT_BOOK = 2;
    private static final int RETURN_BOOK = 3;
    private static final int QUERY_AUTHOR = 4;
    // Add one more for Query book rating

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        HashMap<String, Book> books =  getBooksFromSomewhere();
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                int choice = keyboard.nextInt();
                switch (choice) {
                    case LIST_BOOKS:
                        listBooks(books);
                        break;
                    case CHECKOUT_BOOK:
                        checkoutBook(books);
                        break;
                    case RETURN_BOOK:
                        returnBook(books);
                        break;
                    case QUERY_AUTHOR:
                        queryAuthorBooks(books);
                        break;
                    // Add one more for Query book rating
                    case QUIT:
                        break;
                    default:
                        System.out.printf("Error: Please enter a valid choice %d to %d\n\n", QUIT, QUERY_AUTHOR);
                }
                if (choice == QUIT)
                    break;
            }
            catch (Exception e) {
                System.out.printf("Error: Please enter a valid choice %d to %d\n\n", QUIT, QUERY_AUTHOR);
                keyboard.nextLine();  // flush the input buffer
            }
        }
    }

    private static void listBooks(HashMap<String, Book> bookList ) {
        // Blah blah
    }

    private static void displayMenu() {
        System.out.println("Library choices: ");
        System.out.printf("%d: List available books\n", LIST_BOOKS);
        System.out.printf("%d: Checkout a book\n", CHECKOUT_BOOK);
        System.out.printf("%d: Return a book\n", RETURN_BOOK);
        System.out.printf("%d: Query an author\n", QUERY_AUTHOR);
        System.out.printf("%d: Quit\n", QUIT);
    }

    private static void checkoutBook(HashMap<String, Book> bookList ) {
        // Blah blah
   }

    private static void returnBook(HashMap<String, Book> bookList ) {
        // Blah blah
    }

    private static void queryAuthorBooks(HashMap<String, Book> bookList ) {
        //  Blah blah
    }

    private static void storeBooks(HashMap<String, Book> books, String title, String author, String type,
                                                    int year, double rating, int copies) {
        // Blah blah
    }

    private static HashMap<String, Book> getBooksFromSomewhere() {
        HashMap<String, Book> books = new HashMap<>();
        // Blah blah
        return books;
    }
}
