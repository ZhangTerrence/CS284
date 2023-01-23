public class Rectangle {
    // Data field variables
    private double width;
    private double height;
    private static int numberOfRectangles = 0;

    // Object Constructor
    public Rectangle (double x, double y) {
        width = x;
        height = y;
        numberOfRectangles++;
    }

    // The main method is where the execution starts from
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(3.5, 2.6);
        double ar;
        ar = rect.area();
        System.out.println(ar);
    }

    // Instance method
    // Instance methods are for specific objects
    public double area() {
        return this.width * this.height;
    }

    // Class method (defined by static)
    // Class methods are for all objects
    public static void sayHelloWorld() {
        System.out.println("Hello World!");
    }

    // Static method is a type of class method
    // Only one per class and function name is the same as variable
    // They cannot call instance methods
    public static int getNumberOfRectangles() {
        // Gets number of all Rectangle objects
        return numberOfRectangles;
    }
}