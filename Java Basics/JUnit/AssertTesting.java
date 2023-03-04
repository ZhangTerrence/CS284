package JUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertTesting {
    @Test
    public void testFunction() {
        // Assertion tests
        int i = 0;
        assertEquals(0, i);
        assertEquals(1, i);
    }
}
