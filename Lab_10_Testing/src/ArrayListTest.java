import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    List<Integer> testArray;

    /**
     * This method is invoked before each test is run to set up the test array
     * with a known set of values.
     */
    @BeforeEach                        //@Before in jUnit 4
    // Informs JUnit that this method should be run before each test
    public void setUp() {
        testArray =new ArrayList<Integer>(Arrays.asList(3, 1, 4, 1, 5));
    }

    /**
     * This method is invoked after each test is run to perform tear down
     * activities (not needed in this test fixture).
     */
    @AfterEach                        //@After in jUnit 4
    // Informs JUnit that this method should be run after each test
    public void tearDown() {
        // No tear down needed for this test
    }

    /**
     * Adds a value to the array and verifies the add was successful.
     */
    @Test
    public void testAdd() {
        testArray.add(9);

        List<Integer> expected =
                new ArrayList<Integer>(Arrays.asList(3, 1, 4, 1, 5, 9));

        assertEquals(testArray, expected);
    }

    /**
     * Removes a value from the array and verifies the remove was successful.
     */
    @Test
    public void testRemoveObject() {
        testArray.remove(new Integer(5));

        List<Integer> expected =
                new ArrayList<Integer>(Arrays.asList(3, 1, 4, 1));

        assertEquals(testArray, expected);
    }

    /**
     * Tests the indexOf method and verifies the expected return value.
     */
    @Test
    public void testIndexOf() {
        assertEquals(testArray.indexOf(4), 2);
    }

    @Test
    public void testArrayEmpty() {
        testArray.clear();
        assertTrue(testArray.isEmpty());
    }

    @Test
    public void testArrayContains() {
        assertTrue(testArray.contains(4));
    }

    @Test
    public void testArrayNotContains() {
        assertFalse(testArray.contains(2));
    }

    @Test
    public void testArrayGet() {
        assertEquals(3, (int)testArray.get(0));
    }
}
