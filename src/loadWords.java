import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class loadWords {
    private SpanishEnglishMap map;

    public loadWords(SpanishEnglishMap map) {
        this.map = map;
    }

    public void loadWordsFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\t");
            String englishWord = parts[0];
            String spanishWord = parts[1];
            Word word = new Word(englishWord, spanishWord);
            map.tree.insert(word);
        }
        scanner.close();
    }
}