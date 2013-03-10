/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import pack.validation.Validation;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pack.validation.Validation;

/**
 *
 * @author Mathieu Latour
 */
public class ValidationTest {

    public ValidationTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testTheStringIsMadeOfDigitOnly() {
        assertTrue(Validation.isTheStringMadeOfDigitOnly("1234587651"));
    }

    @Test
    public void testTheStringIsNotMadeOfDigitOnly() {
        assertFalse(Validation.isTheStringMadeOfDigitOnly("a12345"));
    }
}
