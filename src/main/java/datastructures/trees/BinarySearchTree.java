package datastructures.trees;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount = 0;

    private Node<T> root = null;


    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEmpty() {
        return nodeCount == 0;
    }

    public int size() {
        return nodeCount;
    }

    public boolean add(T elem) {
        if (contains(elem)) {
            return false;
        } else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    private Node<T> add(Node<T> node, T elem) {
        if (node == null) {
            node = new Node<>(elem, null, null);
        } else {
            if (elem.compareTo(node.data) < 0) {
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }
        return node;
    }

    public boolean remove(T elem) {
        if (contains(elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node<T> remove(Node<T> node, T elem) {
        if (node == null) return null;
        int compared = elem.compareTo(node.data);
        if (compared < 0) {
            node.left = remove(node.left, elem);
        } else if (compared > 0) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) {
                Node<T> rightChild = node.right;
                node.data = null;
                return rightChild;
            } else if (node.right == null) {
                Node<T> leftChild = node.left;
                node.data = null;
                return leftChild;
            } else {
                Node<T> tmp = digLeft(node.right);
                node.data = tmp.data;
                node.right = remove(node.right, tmp.data);
            }
        }
        return node;
    }

    private Node<T> digLeft(Node<T> node) {
        Node<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node<T> digRight(Node<T> node) {
        Node<T> current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node<T> node, T element) {
        if (node == null) return false;
        int cmp = element.compareTo(node.data);
        if (cmp == 0) return true;
        else if (cmp < 0) {
            return contains(node.left, element);
        } else {
            return contains(node.right, element);
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public Iterator<T> traverse(TraversalOrder traversalOrder) {
        switch (traversalOrder) {
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            case LEVEL_ORDER:
                return levelOrderTraversal();
            default:
                return null;
        }
    }

    private Iterator<T> levelOrderTraversal() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    private Iterator<T> postOrderTraversal() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    private Iterator<T> inOrderTraversal() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    private Iterator<T> preOrderTraversal() {
        throw new UnsupportedOperationException("Method is not implemented");
    }


    public enum TraversalOrder {
        PRE_ORDER, IN_ORDER, POST_ORDER, LEVEL_ORDER
    }
}
