package OOP.Polymorphism;
import OOP.Circle;
import OOP.Rectangle;
import OOP.Shape;

public class TestPolymorphism {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle(10.0, 10.0);

        for (int i = 0; i < 2; i++) {
            System.out.println(shapes[i].toString()); // Java calls each subclass' individual toString() method through polymorphism.
        }
        // Output
        // I am a Circle. My radius is 0.0 and my color is White
        // I am a Rectangle. My width is 10.0. my height is 10.0 and my color is White
    }
}
