package maxfindword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Maxime BLAISE
 */
public class Dictionary {

    public static final String FILE_NAME = "file/dictionary.txt";

    /**
     * Our dictionary, a simple list of words.
     */
    private final ArrayList<String> listOfWords;

    /**
     * Instance of Dictionary for Singleton.
     */
    private static final Dictionary DICTIONARY = new Dictionary();

    /**
     * Private constructor: initialize an empty list.
     */
    private Dictionary() {
        listOfWords = new ArrayList<>();
    }

    public static Dictionary getInstance() {
        return DICTIONARY;
    }
    
    public ArrayList<String> getListe(int size) {
        // Init empty list
        ArrayList<String> list = new ArrayList<>();
        // Loop
        this.listOfWords.stream().filter((str) -> (str.length() == size)).forEach((str) -> {
            list.add(str);
        });
        return list;
    }
    
    /**
     * Return the number of words in our dictionary.
     *
     * @return Integer
     */
    public int numberOfWords() {
        return this.listOfWords.size();
    }

    /**
     * Add a new word to the dictionary.
     *
     * @param word String
     */
    public void addWord(String word) {
        this.listOfWords.add(word);
    }

    /**
     * Initialize the list of words with the external file.
     *
     * @throws java.io.FileNotFoundException FileNotFound
     */
    public static void initialize() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            while (br.ready()) {
                DICTIONARY.addWord(br.readLine());
            }
        }
    }
}
