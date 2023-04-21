public class getWords {
    private SplayTree<Word> tree;

    public getWords(SplayTree<Word> tree) {
        this.tree = tree;
    }

    public String get(String englishWord) {
        Word searchWord = new Word(englishWord, "");
        Word result = tree.find(searchWord);
        if (result == null) {
            return null;
        } else {
            return result.getSpanishWord();
        }
    }
}

