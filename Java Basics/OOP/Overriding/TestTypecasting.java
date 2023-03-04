package OOP.Overriding;

public class TestTypecasting {
    public static void main(String[] args) {
        A x;
        x = new B();
        System.out.println(x.getClass()); // class OOP.Overriding.B
        System.out.println(x.m(5)); // 20 when B methods override, 10 when B methods overload
    }
}
