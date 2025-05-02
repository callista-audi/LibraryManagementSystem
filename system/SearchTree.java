package system;

import models.Book;

public class SearchTree {
    private class Node {
        Book book;
        Node left, right;
        Node(Book book) { this.book = book; }
    }

    private Node root;

    public void insert(Book book) {
        root = insertRec(root, book);
    }

    private Node insertRec(Node node, Book book) {
        if (node == null) return new Node(book);
        if (book.getTitle().compareToIgnoreCase(node.book.getTitle()) < 0)
            node.left = insertRec(node.left, book);
        else
            node.right = insertRec(node.right, book);
        return node;
    }

    public boolean searchByTitle(String title) {
        return searchRec(root, title);
    }

    private boolean searchRec(Node node, String title) {
        if (node == null) return false;
        if (node.book.getTitle().equalsIgnoreCase(title)) {
            System.out.println("Found: " + node.book);
            return true;
        } else if (title.compareToIgnoreCase(node.book.getTitle()) < 0)
            return searchRec(node.left, title);
        else
            return searchRec(node.right, title);
    }
}
