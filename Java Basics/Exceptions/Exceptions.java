package Exceptions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args){
        Exceptions ee = new Exceptions();
        // ee.readFile("myFile.txt");
        int[] a = new int[3];
        try {
            a[0]= 1;
            a[1]= 2;
            a[2]= 3;
            // System.out.println(ee.get(a,-3)); // Will return error
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Careful!");
        }
    }

    // Java FileIO - FileNotFoundException
    public void readFile(String filename){
        File f = new File(filename);
        Scanner c; // Scanner is used to get user input (similar to input() in Python)
        try {
            c = new Scanner(f);
            while(c.hasNextLine()) {
                System.out.println(c.nextLine());
            }
            c.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
    }
    // ArrayIndexOutOfBoundsException
    public int get(int a[], int index){
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index is less than 0");
        }
        return a[index];
    }
}
