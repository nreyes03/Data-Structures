import java.util.*;
import java.util.HashMap;
import java.util.Scanner;
public class Menu1 {
    private static final int QUIT = 0;
    private static final int LIST_BOOKS = 1;
    private static final int CHECKOUT_BOOK = 2;
    private static final int RETURN_BOOK = 3;
    private static final int QUERY_AUTHOR = 4;
    private static final int QUERY_RATING = 5;
    private static final int QUERY_YEAR = 6;

    /**
     *
     * @param args
     */
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
                    case QUERY_RATING:
                        queryRatingBooks(books);
                        break;
                    case QUERY_YEAR:
                        queryYearBooks(books);
                        break;
                    case QUIT:
                        break;
                    default:
                        System.out.printf("Error: Please enter a valid choice %d to %d\n\n", QUIT, QUERY_YEAR);
                }
                if (choice == QUIT)
                    break;
            }
            catch (Exception e) {
                System.out.printf("Error: Please enter a valid choice %d to %d\n\n", QUIT, QUERY_YEAR);
                keyboard.nextLine();  // flush the input buffer
            }
        }
    }
    private static void displayMenu() {
        System.out.println("Library choices: ");
        System.out.printf("%d: List available books\n", LIST_BOOKS);
        System.out.printf("%d: Checkout a book\n", CHECKOUT_BOOK);
        System.out.printf("%d: Return a book\n", RETURN_BOOK);
        System.out.printf("%d: Query an author\n", QUERY_AUTHOR);
        System.out.printf("%d: Query books by rating\n", QUERY_RATING);
        System.out.printf("%d: Query books by year\n", QUERY_YEAR);
        System.out.printf("%d: Quit\n", QUIT);
    }

    /**
     *
     * @param bookList
     */
    private static void listBooks(HashMap<String, Book> bookList ) {
        for (Map.Entry<String, Book> entry : bookList.entrySet()) {
            String title = entry.getKey();
            int availableCopies = entry.getValue().getNumCopies();
            System.out.println("Title: " + title + " | Available Copies: " + availableCopies);
        }
    }

    /**
     *
     * @param bookList
     */
    private static void checkoutBook(HashMap<String, Book> bookList ) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the title of the book to checkout: ");
        String title = keyboard.nextLine();
        Book book = bookList.get(title);
        if (book != null) {
            if (book.getNumCopies() > 0) {
                book.setNumCopies(book.getNumCopies() - 1);
                System.out.printf("You have checked out %s\n\n", title);
            }
            else {
                System.out.printf("Sorry, %s is not available at this time\n\n", title);
            }
        }
        else {
            System.out.printf("Sorry, we don't have %s in our library\n\n", title);
        }
    }

    /**
     *
     * @param bookList
     */
    private static void returnBook(HashMap<String, Book> bookList ) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the title of the book you want to return: ");
        String title = keyboard.nextLine();
        Book book = bookList.get(title);
        if (book == null) {
            System.out.println("Book not found in the library.");
            return;
        }
        if (book.getNumCopies() == book.getMaxCopies()) {
            System.out.println("All copies of the book are already in the library.");
            return;
        }
        book.returnCopy();
        System.out.printf("You have successfully returned a copy of '%s'.\n", book.getTitle());
    }

    /**
     *
     * @param bookList
     */
    private static void queryAuthorBooks(HashMap<String, Book> bookList ) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter author name: ");
        String authorName = keyboard.nextLine();

        System.out.printf("\nBooks by %s:\n", authorName);
        boolean foundBooks = false;

        for (Book book : bookList.values()) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println(book.getTitle());
                foundBooks = true;
            }
        }

        if (!foundBooks) {
            System.out.printf("No books by %s found.\n", authorName);
        }

        System.out.println();
    }

    /**
     *
     * @param bookList
     */
    private static void queryRatingBooks(HashMap<String, Book> bookList ){
        System.out.print("Enter the minimum rating: ");
        Scanner keyboard = new Scanner(System.in);
        double rating = keyboard.nextDouble();
        System.out.println("Books with rating greater than or equal to " + rating + ":");
        for (Book book : bookList.values()) {
            if (book.getRating() >= rating) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + ", " + book.getYearPublished() + ", " + book.getRating() + "/5");
            }
        }
    }

    /**
     *
     * @param bookList
     */
    private static void queryYearBooks(HashMap<String, Book> bookList ){
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the year published: ");
        int year = keyboard.nextInt();

        boolean foundBooks = false;
        for (Book book : bookList.values()) {
            if (book.getYearPublished() == year) {
                System.out.println(book);
                foundBooks = true;
            }
        }

        if (!foundBooks) {
            System.out.println("No books found for year " + year);
        }
    }

    /**
     *
     * @param books
     * @param title
     * @param author
     * @param type
     * @param year
     * @param rating
     * @param copies
     */
    private static void storeBooks(HashMap<String, Book> books, String title, String author, String type,
                                   int year, double rating, int copies) {
        Book book = new Book(title, author, type, year, rating, copies);
        books.put(title, book);
    }

    /**
     *
     * @return
     */
    private static HashMap<String, Book> getBooksFromSomewhere() {
        HashMap<String, Book> books = new HashMap<>();

        Book book1 = new Book("The Hobbit", "Tolkien", "Fiction", 1937, 4.9, 3);
        Book book2 = new Book("The Fellowship of the Ring", "Tolkien", "Fiction", 1954, 4.8, 2);
        Book book3 = new Book("The Two Towers", "Tolkien", "Fiction", 1966, 3.1, 1);
        Book book4 = new Book("The Return of the King", "Tolkien", "Fiction", 1966, 2.5, 3);
        Book book5 = new Book("Brief History of Time", "Hawking", "NonFiction", 1988, 3.5, 2);
        Book book6 = new Book("1984", "Orwell", "Fiction", 1948, 4.7, 10);
        Book book7 = new Book("Animal Farm", "Orwell", "Fiction", 1944, 4.7, 8);
        Book book8 = new Book("Catch-22", "Heller", "Fiction", 1922, 4.3, 6);
        Book book9 = new Book("Anna Karenina", "Tolstoy", "Fiction", 1878, 4.3, 7);
        Book book10 = new Book("War and Peace", "Tolstoy", "Fiction", 1865, 4.5, 6);
        Book book11 = new Book("A Confession", "Tolstoy", "Fiction", 1882, 4.5, 5);
        Book book12 = new Book("How to Win Friends and Influence People", "Carnegie", "NonFiction", 1936, 4.3, 1);
        Book book13 = new Book("Freakonomics", "Levitt", "NonFiction", 2005, 4.9, 7);
        Book book14 = new Book("Super Freakonomics", "Levitt", "NonFiction", 2009, 4.9, 2);
        Book book15 = new Book("Think like a freak", "Levitt", "NonFiction", 2014, 4.9, 6);
        Book book16 = new Book("Gray's Anatomy", "Gray", "Reference", 1858, 3.0, 1);

        books.put(book1.getTitle(), book1);
        books.put(book2.getTitle(), book2);
        books.put(book3.getTitle(), book3);
        books.put(book4.getTitle(), book4);
        books.put(book5.getTitle(), book5);
        books.put(book6.getTitle(), book6);
        books.put(book7.getTitle(), book7);
        books.put(book8.getTitle(), book8);
        books.put(book9.getTitle(), book9);
        books.put(book10.getTitle(), book10);
        books.put(book11.getTitle(), book11);
        books.put(book12.getTitle(), book12);
        books.put(book13.getTitle(), book13);
        books.put(book14.getTitle(), book14);
        books.put(book15.getTitle(), book15);
        books.put(book16.getTitle(), book16);

        return books;
    }
}
class Book {
    private int maxCopies;
    private String title;
    private String author;
    private String category;
    private int yearPublished;
    private double rating;
    private int numCopies;

    /**
     *
     * @param title
     * @param author
     * @param category
     * @param yearPublished
     * @param rating
     * @param numCopies
     */
    public Book(String title, String author, String category, int yearPublished, double rating, int numCopies) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.yearPublished = yearPublished;
        this.rating = rating;
        this.numCopies = numCopies;
    }

    // Setters
    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @param yearPublished
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     *
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     *
     * @param numCopies
     */
    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }


    // Getters

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @return yearPublished
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     *
     * @return rating
     */
    public double getRating() {
        return rating;
    }

    /**
     *
     * @return numCopies
     */
    public int getNumCopies() {
        return numCopies;
    }

    /**
     *
     * @return maxCopies
     */
    public int getMaxCopies() {
        return maxCopies;
    }

    public void returnCopy() {
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Category: " + category
                + ", Year Published: " + yearPublished + ", Rating: " + rating + ", Copies Available: " + numCopies;
    }
}
