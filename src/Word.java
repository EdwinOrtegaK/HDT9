public class Word implements Comparable<Word> {
    private String spanishWord;
    private String englishWord;

    public Word(String spanishWord, String englishWord) {
        this.spanishWord = spanishWord;
        this.englishWord = englishWord;
    }

    public String getSpanishWord() {
        return spanishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    @Override
    public int compareTo(Word other) {
        return this.spanishWord.compareTo(other.getSpanishWord());
    }
}
