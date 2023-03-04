package OOP;

// Another subclass of Shape
public class Rectangle extends Shape {
    private double width;
    private double height;
    private static int totalNumberOfRectangles = 0;

    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }
    public Rectangle(double width, double height) {
        super("White");
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double area() {
        return this.width * this.height;
    }
    public String toString() {
        return "I am a Rectangle. My width is "+ this.width + ". my height is " + this.height + " and my color is "+ this.getColor();
    }
}
