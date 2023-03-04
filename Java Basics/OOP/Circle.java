package OOP;

// Subclass of Shape
public class Circle extends Shape{
    private double radius;
    private static final double PI = 3.14; // Static methods are shared across all object instances of the class

    public Circle() {
        super("White"); // Super constructor has to be called first
        this.radius = 0;
    }
    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return this.PI * this.radius * this.radius;
    }
    public String toString() {
        return "I am a Circle. My radius is " + this.radius + " and my color is "+ this.getColor();
    }
}
