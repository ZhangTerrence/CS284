/*
Name: Terrence Zhang
Pledge: I pledge my honor that I have abided by the Stevens Honor System.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
    private ArrayList<String> wordList;
    private ArrayList<DictionaryItem> dictArrayList;

    public Dictionary() {
        // Initializes two arraylist data fields given no parameters and calls readFile()
        this.wordList = new ArrayList<String>(1300);
        this.dictArrayList = new ArrayList<DictionaryItem>(1300);
        readFile("ionDictionary.txt");
    }

    public Dictionary(String filename) {
        // Initializes two arraylist data fields given a filename and calls readFile()
        this.wordList = new ArrayList<String>(1300);
        this.dictArrayList = new ArrayList<DictionaryItem>(1300);
        readFile(filename);
    }

    public void printMenu() {
        // Prints 3 menu items
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the Ion Dictionary! This dictionary is created from the book Ion by Plato!");
        System.out.println("Please choose one of the following menu items indicated with 1-3");
        System.out.println("1: To print all the words in the dictionary, choose 1");
        System.out.println("2: To search a word in the dictionary, choose 2");
        System.out.println("3: To quit the program, choose 3");
        try {
            while (processMenuItem(Integer.parseInt(userInput.nextLine()), userInput)) {
                System.out.println("Please choose one of the following menu items indicated with 1-3");
                System.out.println("1: To print all the words in the dictionary, choose 1");
                System.out.println("2: To search a word in the dictionary, choose 2");
                System.out.println("3: To quit the program, choose 3");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR! Please enter a number between 1 and 3.");
            printMenu();
        }
    }

    private boolean processMenuItem(int menuItem, Scanner scan) {
        // Helper method for printMenu() that takes two inputs and calls appropriate function given user input
        if (menuItem < 1 || menuItem > 3) {
            System.out.println("ERROR! Please enter a number between 1 and 3.");
            return true;
        } else {
            if (menuItem == 1) {
                System.out.println("All the words mentioned in the Ion book!");
                System.out.println("Words");
                System.out.println("-----");
                printDictionary();
                return true;
            }
            if (menuItem == 2) {
                System.out.println("Please enter the word you would like to search:");
                String word = scan.nextLine();
                int count = searchDictionary(word);
                if (count < 0) {
                    System.out.println("The word '" + word + "' does not exist in the Ion dictionary!");
                } else {
                    System.out.println("The word '" + word + "' occurred " + count + " times in the book!");
                }
                return true;
            }
            if (menuItem == 3) {
                System.out.println("Thanks for using Ion Dictionary! Bye!");
                return false;
            }
        }
        return false;
    }

    public void readFile(String filename) {
        // Reads file and stores words in wordList and word-count pairs in dictArrayList
        File f = new File(filename);
        Scanner c;
        try {
            c = new Scanner(f);
            for (int i = 0; i < 4; i++) {
                c.nextLine();
            }
            while (c.hasNextLine()) {
                splitStoreLine(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! File not found.");
        }
    }

    private void splitStoreLine(Scanner scan) {
        // Helper method for readFile() that splits line read from the file and stores the word-count pairs in the defined arraylist
        String[] pair = scan.nextLine().split("\\|");
        String word = pair[0].replaceAll("\\s","");
        int count = Integer.parseInt(pair[1].replaceAll("\\s",""));
        this.wordList.add(word);
        DictionaryItem dictItem = new DictionaryItem(word, count);
        this.dictArrayList.add(dictItem);
    }

    public void printDictionary() {
        // Prints all words from wordList
        for (int i = 0; i < this.wordList.size(); i++) {
            System.out.println(this.wordList.get(i));
        }
    }

    public int searchDictionary(String word) {
        // Using the index given from binarySearch(), returns the count of a word from the dictArrayList
        int index = binarySearch(word, 0, this.wordList.size() - 1);
        if (index < 0) {
            return -1;
        } else {
            return this.dictArrayList.get(index).getCount();
        }
    }

    private int binarySearch(String word, int low, int high) {
        // Helper function for searchDictionary(). Returns the index where a word is inside the wordList
        int index = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int compared = word.compareTo(this.wordList.get(mid));
            if (compared == 0) {
                index = mid;
                break;
            }
            if (compared > 0) {
                low = mid + 1;
            }
            if (compared < 0) {
                high = mid - 1;
            }
        }
        return index;
    }
}
