import javax.swing.tree.TreeNode;

public class RedBlackTree<T extends Comparable<T>> implements ToImplement<T> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node<T> root;
    private RedBlackTree left;
    private String key;
    private String value;
    private RedBlackTree right;

    public RedBlackTree() {
        this.root = null;
    }

    private static class Node<T> {
        public Node<T> left;
        public Node<T> right;
        public String key;
        T value;
        Node<T> leftChild;
        Node<T> rightChild;
        Node<T> parent;
        boolean color;

        public Node(T value, boolean color) {
            this.value = value;
            this.color = color;
        }
    }


    private Node<T> parentOf(Node<T> node) {
        return (node == null) ? null : node.parent;
    }

    private Node<T> leftOf(Node<T> node) {
        return (node == null) ? null : node.leftChild;
    }

    private Node<T> rightOf(Node<T> node) {
        return (node == null) ? null : node.rightChild;
    }

    private boolean colorOf(Node<T> node) {
        return (node == null) ? BLACK : node.color;
    }

    private void setColor(Node<T> node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    private void rotateLeft(Node<T> node) {
        Node<T> right = node.right;
        node.right = right.left;
        if (right.left != null) {
            right.left.parent = node;
        }
        right.parent = node.parent;
        if (node.parent == null) {
            root = right;
        } else if (node == node.parent.left) {
            node.parent.left = right;
        } else {
            node.parent.right = right;
        }
        right.left = node;
        node.parent = right;
    }

    private void rotateRight(Node<T> node) {
        Node<T> left = node.left;
        node.left = left.right;
        if (left.right != null) {
            left.right.parent = node;
        }
        left.parent = node.parent;
        if (node.parent == null) {
            root = left;
        } else if (node == node.parent.right) {
            node.parent.right = left;
        } else {
            node.parent.left = left;
        }
        left.right = node;
        node.parent = left;
    }
    
    public void insert(T value) {
        Node<T> node = new Node<T>(value, RED);
        if (root == null) {
            root = node;
        } else {
            Node<T> current = root;
            Node<T> parent = null;
            while (current != null) {
                parent = current;
                int cmp = node.value.compareTo(current.value);
                if (cmp < 0) {
                    current = current.leftChild;
                } else if (cmp > 0) {
                    current = current.rightChild;
                } else {
                    return; // El valor ya existe en el árbol
                }
            }

            node.parent = parent;
            if (node.value.compareTo(parent.value) < 0) {
                parent.leftChild = node;
            } else {
                parent.rightChild = node;
            }

            fixAfterInsertion(node);
        }
    }

    public T find(T value) {
        Node<T> node = findNode(value);
        if (node == null || node.value.compareTo(value) != 0) {
            return null; // El valor no se encuentra en el árbol
        }
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

    private void fixAfterInsertion(Node<T> node) {
        node.color = RED;
        while (node != null && node != root && node.parent.color == RED) {
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                Node<T> y = rightOf(parentOf(parentOf(node)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(node), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == rightOf(parentOf(node))) {
                        node = parentOf(node);
                        rotateLeft(node);
                    }
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    rotateRight(parentOf(parentOf(node)));
                }
            } else {
                Node<T> y = leftOf(parentOf(parentOf(node)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(node), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == leftOf(parentOf(node))) {
                        node = parentOf(node);
                        rotateRight(node);
                    }
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    rotateLeft(parentOf(parentOf(node)));
                }
            }
        }
        root.color = BLACK;
    }

    public TreeNode getRoot() {
        return (TreeNode) root;
    }

    public void printInOr(RedBlackTree node) {
        if (node != null) {
            printInOr(node.left);
            System.out.print("(" + node.key + ", " + node.value + ") ");
            printInOr(node.right);
        }
    }

    public TreeNode getHelper(Node<T> node, String key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return (TreeNode) node;
        } else if (key.compareTo(node.key) < 0) {
            return getHelper(node.left, key);
        } else {
            return getHelper(node.right, key);
        }
    }

    public String get(String key) {
        RedBlackTree node = (RedBlackTree) getHelper(this.root, key);
        if (node != null) {
            return node.value;
        } else {
            return "*"+key+"*";
        }
    }
}

