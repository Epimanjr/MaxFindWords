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

    public static final String FILE_NAME = "file/dictionnaire.txt";

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
    
    public ArrayList<String> getListe(int size, ArrayList<String> lettres) {
        // Init empty list
        ArrayList<String> list = new ArrayList<>();
        // Loop
        this.listOfWords.stream().filter((str) -> (isPossible(str, size, lettres))).forEach((str) -> {
            list.add(str);
        });
        return list;
    }
    
    private boolean isPossible(String str, int size,ArrayList<String> lettres) {
        if(str.length() != size) {
            return false;
        }
        for(int i=0;i<str.length();i++) {
            if(!lettres.contains(getStringWithoutAccent(str.charAt(i)+""))) {
                return false;
            }
        }
        return true;
    }
    
    private String getStringWithoutAccent(String c) {
        String res = c;
        switch(c) {
            case "é":
            case "è":
            case "ê":
                res = "e";
                break;
            case "à":
            case "â":
                res = "a";
                break;
            case "î":
                res = "i";
                break;
            case "ô":
                res = "o";
                break;
            case "û":
            case "ù":
                res = "u";
                break;
            case "ç":
                res = "c";
                break;
        }
        return res;
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
