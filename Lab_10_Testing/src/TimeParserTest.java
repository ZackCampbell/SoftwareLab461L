import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class TimeParserTest {

    @Test
    public void testFullStatementCoverage() {
        assertEquals(43200, TimeParser.parseTimeToSeconds("0:00:00 pm"));
        assertEquals(0, TimeParser.parseTimeToSeconds("0:00:00 am"));
    }

    @Test
    public void testFullBranchCoverage() {
        assertEquals(82800, TimeParser.parseTimeToSeconds("11:00:00 pm"));
        assertEquals(0, TimeParser.parseTimeToSeconds("0:00:00 cm"));
    }

    @Test
    public void testFirstException() {
        assertThrows(NumberFormatException.class, () -> TimeParser.parseTimeToSeconds("0 pm"));          // Test first exception that there isn't a colon
    }

    @Test
    public void testSecondException() {
        assertThrows(NumberFormatException.class, () -> TimeParser.parseTimeToSeconds("0:00 pm"));          // Test the second exception that there isn't a second colon
    }

    @Test
    public void testThirdException() {
        assertThrows(IllegalArgumentException.class, () -> TimeParser.parseTimeToSeconds("0:00:60 am"));   // Test the third exception that there isn't a valid time
    }


}