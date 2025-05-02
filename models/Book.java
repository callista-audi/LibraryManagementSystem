package models;

public class Book {
    private static int idCounter = 1;
    private String id;
    private String title, author, category;
    private boolean isBorrowed;

    public Book(String title, String author, String category) {
        this.id = "B" + idCounter++;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isBorrowed() { return isBorrowed; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setCategory(String category) { this.category = category; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }

    @Override
    public String toString() {
        return id + ": \"" + title + "\" by " + author + " [" + category + "] " + (isBorrowed ? "(Borrowed)" : "(Available)");
    }
}
