package system;

import models.Book;
import models.User;
import java.util.LinkedList;
import java.util.Queue;

public class BorrowQueue {
    private Queue<User> queue = new LinkedList<>();

    public void addToQueue(User user) { queue.add(user); }

    public void processBorrow(Book book) {
        if (book.isBorrowed()) {
            System.out.println("Book already borrowed.");
            return;
        }
        if (!queue.isEmpty()) {
            User user = queue.poll();
            user.borrowBook(book);
            book.setBorrowed(true);
            System.out.println(user.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("No users in queue.");
        }
    }
}
