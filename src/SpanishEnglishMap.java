public class SpanishEnglishMap {
    SplayTree<Word> tree;

    public SpanishEnglishMap(String algorithm) {
        if (algorithm.equals("splay")) {
            tree = new SplayTree<Word>();
        } else {
            throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
    }
}

