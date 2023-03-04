package Types;
import java.sql.SQLOutput;

public class TestTypes {
    public static void main(String[] args){
        // Widening casts are automatically done
        // Int to double
        int integer = 42;
        double double_ = integer;
        System.out.println(double_); // 42.0

        // Narrowing casts need to be explicitly done using type casting
        // Double to int
        double y = 3.14;
        int x = (int) y; // Type casting
        System.out.println(x); // 12

        // Memory allocation
        String greeting;
        greeting = "Welcome";
        String welcome = greeting;
        System.out.println(welcome); //prints "Welcome"
        greeting = "Hello";
        System.out.println(welcome); //prints "Welcome"
        System.out.println(greeting); //prints "Hello"

        int[] data1 = {1,2,3,4,5};
        int[] data2 = data1;
        System.out.println(data1[0]); //prints 1
        data2[0] = 8;
        System.out.println(data1[0]); //prints 8
        // How to have a copy of the array, while elements are not referred by same addresses
        int[] data3 = {1,2,3,4,5};
        int data4[] = data3.clone();
        System.out.println(data3[0]); //prints 1
        data4[0] = 8;
        System.out.println(data3[0]); //prints 1

        // Call-by-value example (Java is only call-by-value)
        TestTypes tt = new TestTypes();
        double income = 100;
        int percentage = 5;
        tt.incomeRaise(percentage, income); // Only changes the values of income and percentage
        System.out.println("Income: " + income); // So when printed, the references still point to the previous values
        double raisedAmount = tt.raise(percentage, income); // Creates a new references and sets the new values there
        System.out.println("Income after raise method call: " + income); // Calls old reference -> old value
        System.out.println("RaisedAmount after raise method call: " + raisedAmount); // Calls new reference -> new value

        // String Method Exercises
        tt.stringExercises();
    }
    public void incomeRaise(int percentage, double income){
        income += income * (percentage/100.0);
    }
    public double raise(int percentage, double income){
        income += income * (percentage/100.0);
        return income;
    }
    public void stringExercises(){
        System.out.println();
        String test = "Palindrome reader";
        System.out.println("charAt(0): "+test.charAt(0));
        System.out.println("length: "+test.length());
        System.out.println("indexOf('i'): "+test.indexOf('r'));
        System.out.println((int)'r');
        int index = test.indexOf('r')+(test.substring(test.indexOf('r')
                +1)).indexOf('r')+1;
        System.out.println("substring(): "+index);
        System.out.println("toUpperCase(): "+test.toUpperCase());
    }
}
