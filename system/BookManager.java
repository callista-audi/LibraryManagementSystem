package system;

import models.Book;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public List<Book> getBooks() { return books; }

    public Book getBookByTitle(String title) {
        for (Book b : books)
            if (b.getTitle().equalsIgnoreCase(title)) return b;
        return null;
    }

    public void deleteBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public void editBookByTitle(String title, boolean editTitle, String newTitle,
                                boolean editAuthor, String newAuthor,
                                boolean editCategory, String newCategory) {
        Book b = getBookByTitle(title);
        if (b != null) {
            if (editTitle) b.setTitle(newTitle);
            if (editAuthor) b.setAuthor(newAuthor);
            if (editCategory) b.setCategory(newCategory);
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book b : books)
            if (!b.isBorrowed()) available.add(b);
        return available;
    }
}
