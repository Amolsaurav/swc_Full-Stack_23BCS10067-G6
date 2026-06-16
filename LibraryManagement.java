import java.util.*;

class Book {
    private long bookId;
    private String title;
    private String author;
    private int quantity;

    public Book(long bookId, String title, String author, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int count) {
        quantity += count;
    }

    public void decreaseQuantity(int count) {
        quantity -= count;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Quantity: " + quantity);
    }
}

class User {
    private long userId;
    private String name;
    private List<Book> issuedBooks;

    public User(long userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public boolean hasBook(long bookId) {
        for (Book book : issuedBooks) {
            if (book.getBookId() == bookId) {
                return true;
            }
        }
        return false;
    }

    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    public boolean returnBook(long bookId) {
        Iterator<Book> iterator = issuedBooks.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();

            if (book.getBookId() == bookId) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public void displayIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books issued.");
            return;
        }

        for (Book book : issuedBooks) {
            book.displayBook();
            System.out.println();
        }
    }
}

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBook(List<Book> bookList) {
        books.addAll(bookList);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book getBook(long bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public User getUser(long userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void issueBook(long userId, long bookId) {
        User user = getUser(userId);
        Book book = getBook(bookId);

        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }

        if (user.hasBook(bookId)) {
            System.out.println("Book already issued to this user.");
            return;
        }

        if (book.getQuantity() <= 0) {
            System.out.println("Book not available.");
            return;
        }

        book.decreaseQuantity(1);
        user.issueBook(book);
        System.out.println("Book issued successfully.");
    }

    public void returnBook(long userId, long bookId) {
        User user = getUser(userId);
        Book book = getBook(bookId);

        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }

        if (user.returnBook(bookId)) {
            book.increaseQuantity(1);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued to this user.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");

        for (Book book : books) {
            if (book.getQuantity() > 0) {
                book.displayBook();
                System.out.println();
            }
        }
    }

    public void displayIssuedBooks() {
        System.out.println("Issued Books:");

        for (User user : users) {
            if (!user.getIssuedBooks().isEmpty()) {
                System.out.println("User: " + user.getName());
                user.displayIssuedBooks();
            }
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Available Books");
            System.out.println("6. Display Issued Books");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    long bookId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    library.addBook(new Book(bookId, title, author, quantity));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    long userId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();

                    library.addUser(new User(userId, name));
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    userId = sc.nextLong();

                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextLong();

                    library.issueBook(userId, bookId);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    userId = sc.nextLong();

                    System.out.print("Enter Book ID: ");
                    bookId = sc.nextLong();

                    library.returnBook(userId, bookId);
                    break;

                case 5:
                    library.displayAvailableBooks();
                    break;

                case 6:
                    library.displayIssuedBooks();
                    break;

                case 7:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
