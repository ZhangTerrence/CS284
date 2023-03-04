package OOP.Overriding;

public class TestOverride {
    public static void main(String[] args) {
        SuperOverride sup = new SuperOverride();
        SubOverride sub = new SubOverride();

        System.out.println(sup.toString()); // Superclass!
        System.out.println(sub.toString()); // Subclass!
    }
}
