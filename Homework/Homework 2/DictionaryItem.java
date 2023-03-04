/*
Name: Terrence Zhang
Pledge: I pledge my honor that I have abided by the Stevens Honor System.
 */

public class DictionaryItem {
    private String word;
    private int count;

    public DictionaryItem(String word, int count) {
        // Initializes two data fields given a word and a count
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        // Getter for word
        return word;
    }

    public void setWord(String word) {
        // Setter for word
        this.word = word;
    }

    public int getCount() {
        // Getter for count
        return count;
    }

    public void setCount(int count) {
        // Setter for count
        this.count = count;
    }
}
