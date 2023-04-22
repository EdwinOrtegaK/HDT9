public class SpanishEnglishMap {
    ToImplement<Word> tree;

    public SpanishEnglishMap(String algorithm) {
        if (algorithm.equals("SplayTree")) {
            tree = new SplayTree<Word>();
        } else if (algorithm.equals("RedBlackTree")){
            tree = new RedBlackTree<Word>();
        } else {
        throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
    }
}

