import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDecodeTests {
    @Test
    public void testStringFormat() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("gsu"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("#!"));
    }
    @Test
    public void testEmpty(){
        assertThrows(NumberFormatException.class, ()-> Integer.decode(""));
    }
    @Test
    public void testPositiveDecimalNumber(){
        assertEquals(15, Integer.decode("15"));
        assertEquals(15, Integer.decode("+15"));
    }
    @Test
    public void testNegativeDecimalNumber(){
        assertEquals(-15, Integer.decode("-15"));
    }
    @Test
    public void testPositiveHexDigits(){
        assertEquals(14, Integer.decode("0xE"));
        assertEquals(14, Integer.decode("+0xE"));
        assertEquals(14, Integer.decode("0XE"));
        assertEquals(14, Integer.decode("+0XE"));
    }
    @Test
    public void testNegativeHexDigits(){
        assertEquals(-14, Integer.decode("-0xE"));
        assertEquals(-14, Integer.decode("-0XE"));
    }

    @Test
    public void testPositiveOctalDigits(){
        assertEquals(84, Integer.decode("0124"));
        assertEquals(84, Integer.decode("+0124"));
    }
    @Test
    public void testNegativeOctalDigits(){
        assertEquals(-84, Integer.decode("-0124"));
    }

    @Test
    public void testTwoOperations(){
        assertEquals(Integer.decode("0xE"), Integer.decode("14"));
        assertNotEquals(Integer.decode("013"), Integer.decode("13"));
    }
    @Test
    public void testNegativeHashtagHexDigits(){
        assertEquals(-13, Integer.decode("-#D"));
    }
    @Test
    public void testPositiveHashtagHexDigits(){
        assertEquals(13, Integer.decode("#D"));
    }
    @Test
    public void testConstant() {
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode(Integer.toString(Integer.MIN_VALUE)));
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode(Integer.toString(Integer.MAX_VALUE)));
    }
    @Test
    public void testPlusAndMinus(){
        assertThrows(NumberFormatException.class,() -> Integer.decode("++13"));
        assertThrows(NumberFormatException.class,() -> Integer.decode("--13"));
    }
}
