/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Mathieu Latour
 */
public class ValidationTest {

   
    @Test
    public void testTheStringIsMadeOfDigitOnly() {
        assertTrue(StringAnalyzer.isTheStringMadeOfDigitOnly("1234587651"));
    }

    @Test
    public void testTheStringIsNotMadeOfDigitOnly() {
        assertFalse(StringAnalyzer.isTheStringMadeOfDigitOnly("a12345"));
    }
}
