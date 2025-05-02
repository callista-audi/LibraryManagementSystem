package system;

import models.User;

public class UserManager {
    private class Node {
        User user;
        Node left, right;
        Node(User user) { this.user = user; }
    }

    private Node root;

    public void addUser(User user) {
        root = insert(root, user);
    }

    private Node insert(Node node, User user) {
        if (node == null) return new Node(user);
        if (user.getName().compareToIgnoreCase(node.user.getName()) < 0)
            node.left = insert(node.left, user);
        else
            node.right = insert(node.right, user);
        return node;
    }

    public User findUser(String name) {
        return find(root, name);
    }

    private User find(Node node, String name) {
        if (node == null) return null;
        if (node.user.getName().equalsIgnoreCase(name)) return node.user;
        if (name.compareToIgnoreCase(node.user.getName()) < 0)
            return find(node.left, name);
        else
            return find(node.right, name);
    }

    public void printUsers() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.user);
            inOrder(node.right);
        }
    }
}
