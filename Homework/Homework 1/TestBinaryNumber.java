import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinaryNumber {
    @Test
    public void test() {
        BinaryNumber bn1 = new BinaryNumber("1011");
        System.out.println(bn1.getLength());
    }
}
