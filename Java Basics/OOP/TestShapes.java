package OOP;

public class TestShapes {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(1.7, 2.7);
        Circle c1 = new Circle(3.4, "Blue");

        System.out.println(r1.toString());
        System.out.println(c1.toString());
        System.out.println(r1.area());
        System.out.println(c1.area());

        // While interfaces cannot be directly instantiated, classes that implement the interface can be used to use interface type
        // InterfaceShape wrongExample = new InterfaceShape(); Error
        // InterfaceShape wrongExample = new AbstractShape(); Error
        InterfaceShape rightExample = new ImplementShape();
        System.out.println(rightExample.getClass()); // class OOP.ImplementShape
    }
}
