package Validator;

import Validator.StringAnalyzer;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringAnalyzerTest {

   
    @Test
    public void testTheStringIsMadeOfDigitOnly() {
        assertTrue(StringAnalyzer.isTheStringMadeOfDigitOnly("1234587651"));
    }

    @Test
    public void testTheStringIsNotMadeOfDigitOnly() {
        assertFalse(StringAnalyzer.isTheStringMadeOfDigitOnly("a12345"));
    }
}
