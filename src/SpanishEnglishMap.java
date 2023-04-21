public class SpanishEnglishMap {
    ToImplement<Word> tree;

    public SpanishEnglishMap(String algorithm) {
        if (algorithm.equals("splay")) {
            tree = new SplayTree<Word>();
        } else if (algorithm.equals("redblack")){
            tree = new RedBlackTree<Word>();
        } else {
        throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
    }
}

