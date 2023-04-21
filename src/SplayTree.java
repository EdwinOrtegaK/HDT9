public class SplayTree<T extends Comparable<T>> implements ToImplement<T>{
    private Node<T> root;

    private static class Node<T> {
        T value;
        Node<T> parent;
        Node<T> leftChild;
        Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }
    }

    public void insert(T value) {
        if (root == null) {
            root = new Node<T>(value);
            return;
        }

        Node<T> node = findNode(value);
        if (node.value.compareTo(value) == 0) {
            return; // El valor ya existe en el árbol
        }

        Node<T> newNode = new Node<T>(value);
        newNode.parent = node;
        if (value.compareTo(node.value) < 0) {
            node.leftChild = newNode;
        } else {
            node.rightChild = newNode;
        }

        splay(newNode);
    }

    public T find(T value) {
        Node<T> node = findNode(value);
        if (node == null || node.value.compareTo(value) != 0) {
            return null; // El valor no se encuentra en el árbol
        }
        splay(node);
        return node.value;
    }

    private Node<T> findNode(T value) {
        Node<T> node = root;
        while (node != null) {
            int cmp = node.value.compareTo(value);
            if (cmp == 0) {
                return node;
            } else if (cmp < 0) {
                node = node.rightChild;
            } else {
                node = node.leftChild;
            }
        }
        return null;
    }

    private void splay(Node<T> node) {
        while (node.parent != null) {
            Node<T> parent = node.parent;
            Node<T> grandparent = parent.parent;

            if (grandparent == null) { // Zig
                if (node == parent.leftChild) {
                    rotateRight(parent);
                } else {
                    rotateLeft(parent);
                }
            } else if (node == parent.leftChild && parent == grandparent.leftChild) { // Zig-Zig
                rotateRight(grandparent);
                rotateRight(parent);
            } else if (node == parent.rightChild && parent == grandparent.rightChild) { // Zig-Zig
                rotateLeft(grandparent);
                rotateLeft(parent);
            } else if (node == parent.rightChild && parent == grandparent.leftChild) { // Zig-Zag
                rotateLeft(parent);
                rotateRight(grandparent);
            } else { // Zig-Zag
                rotateRight(parent);
                rotateLeft(grandparent);
            }
        }
        root = node;
    }

    private void rotateLeft(Node<T> node) {
        Node<T> rightChild = node.rightChild;
        node.rightChild = rightChild.leftChild;
        if (rightChild.leftChild != null) {
            rightChild.leftChild.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.leftChild) {
            node.parent.leftChild = rightChild;
        } else {
            node.parent.rightChild = rightChild;
        }
        rightChild.leftChild = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node<T> node) {
        Node<T> leftChild = node.leftChild;
        node.leftChild = leftChild.rightChild;
        if (leftChild.rightChild != null) {
            leftChild.rightChild.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.rightChild) {
            node.parent.rightChild = leftChild;
        } else {
            node.parent.leftChild = leftChild;
        }
        leftChild.rightChild = node;
        node.parent = leftChild;
    }
}
