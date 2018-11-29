import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhiladelphiaTest {
    @Test
    public void testIsItSunny() {
        assertTrue(Philadelphia.isItSunny());
    }

    @Test
    public void testIsNotSunny() {
        assertFalse(Philadelphia.isItSunny());
    }

    @Test
    public void testIsSunnyEqualsTrue() {
        assertEquals(Philadelphia.isItSunny(), Philadelphia.isItSunny());
    }

    @Test
    public void testThrowException() throws Exception {
        throw new Exception();
    }
}
