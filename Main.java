import models.Book;
import models.User;
import system.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        SearchTree searchTree = new SearchTree();
        UserManager userManager = new UserManager();
        BorrowQueue borrowQueue = new BorrowQueue();
        ReturnHistory returnHistory = new ReturnHistory();

        // Dummy books
        for (int i = 1; i <= 10; i++) {
            Book b = new Book("Book" + i, "Author" + i, i % 2 == 0 ? "Fiction" : "Science");
            bookManager.addBook(b);
            searchTree.insert(b);
        }

        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Show All Books");
            System.out.println("2. Add Book");
            System.out.println("3. Edit Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Show Return History");
            System.out.println("9. Show Users");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    bookManager.getBooks().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.print("Author: "); String author = sc.nextLine();
                    System.out.print("Category: "); String category = sc.nextLine();
                    Book newBook = new Book(title, author, category);
                    bookManager.addBook(newBook);
                    searchTree.insert(newBook);
                    System.out.println("Book added.");
                    break;
                case 3:
                    System.out.print("Enter title of the book to edit: ");
                    String oldTitle = sc.nextLine();
                    Book bookToEdit = bookManager.getBookByTitle(oldTitle);
                    if (bookToEdit == null) {
                        System.out.println("Tidak ada buku tersebut di list.");
                        break;
                    }
                    System.out.print("Edit title? (y/n): ");
                    boolean et = sc.nextLine().equalsIgnoreCase("y");
                    String newTitle = et ? sc.nextLine() : bookToEdit.getTitle();
                    System.out.print("Edit author? (y/n): ");
                    boolean ea = sc.nextLine().equalsIgnoreCase("y");
                    String newAuthor = ea ? sc.nextLine() : bookToEdit.getAuthor();
                    System.out.print("Edit category? (y/n): ");
                    boolean ec = sc.nextLine().equalsIgnoreCase("y");
                    String newCat = ec ? sc.nextLine() : bookToEdit.getCategory();
                    bookManager.editBookByTitle(oldTitle, et, newTitle, ea, newAuthor, ec, newCat);
                    System.out.println("Book updated.");
                    break;
                case 4:
                    System.out.print("Title of book to delete: ");
                    String delTitle = sc.nextLine();
                    bookManager.deleteBookByTitle(delTitle);
                    System.out.println("Deleted.");
                    break;
                case 5:
                    System.out.print("Title: ");
                    String searchTitle = sc.nextLine();
                    boolean found = searchTree.searchByTitle(searchTitle);
                    if (!found) System.out.println("Tidak ada buku tersebut di list.");
                    break;
                case 6:
                    System.out.print("Your Name: ");
                    String name = sc.nextLine();
                    User user = userManager.findUser(name);
                    if (user == null) {
                        user = new User(name);
                        userManager.addUser(user);
                    }
                    System.out.println("Available Books:");
                    bookManager.getAvailableBooks().forEach(System.out::println);
                    System.out.print("Book title to borrow: ");
                    Book bookToBorrow = bookManager.getBookByTitle(sc.nextLine());
                    if (bookToBorrow != null && !bookToBorrow.isBorrowed()) {
                        user.borrowBook(bookToBorrow);
                        bookToBorrow.setBorrowed(true);
                        System.out.println("Book borrowed.");
                    } else {
                        System.out.println("Book not available.");
                    }
                    break;
                case 7:
                    System.out.print("Your Name: ");
                    name = sc.nextLine();
                    user = userManager.findUser(name);
                    if (user != null && !user.getBorrowedBooks().isEmpty()) {
                        System.out.println("Your borrowed books:");
                        for (Book b : user.getBorrowedBooks()) System.out.println(b);
                        System.out.print("Book title to return: ");
                        String retTitle = sc.nextLine();
                        Book book = bookManager.getBookByTitle(retTitle);
                        if (book != null && user.getBorrowedBooks().contains(book)) {
                            user.returnBook(book);
                            book.setBorrowed(false);
                            returnHistory.addReturnLog(name + " returned " + book.getTitle());
                            System.out.println("Returned.");
                        } else {
                            System.out.println("You haven't borrowed that book.");
                        }
                    } else {
                        System.out.println("No books to return.");
                    }
                    break;
                case 8:
                    returnHistory.showHistory();
                    break;
                case 9:
                    userManager.printUsers();
                    break;
            }

        } while (choice != 0);
    }
}
