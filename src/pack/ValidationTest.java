/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
    public void testClientNumberIsValid() {
        assertTrue (Validation.isClientNumberValid("123456"));
    }
    
    @Test
    public void testClientNumberIsInvalidAllChars() {
        assertFalse (Validation.isClientNumberValid("abcdef"));
    }
    
    @Test
    public void testClientNumberIsInvalidHas1Char() {
        assertFalse (Validation.isClientNumberValid("12345a"));
    }
    
    @Test
    public void testClientNumberIsInvalidNumberFormatInvalid() {
        assertFalse (Validation.isClientNumberValid("123"));
    }
    
    public void testClientNumberIsNegative() {
        assertFalse (Validation.isClientNumberValid("-12345"));
    }
    
    @Test (expected=NullPointerException.class)
    public void testClientNumberINull() {
        assertNull(Validation.isClientNumberValid(null));
    }

    @Test
    public void testClientNumberOfDigitsIsValid() {
        assertTrue(Validation.isClientNumberValid("123456"));
    }
    
    @Test
    public void testClientNumberOfDigitsIsInvalid() {
        assertFalse(Validation.isClientNumberValid("12345"));
    }
    
    @Test (expected=NullPointerException.class)
    public void testClientNumberOfDigitsIsNull() {
        assertNull(Validation.isClientNumberValid(null));
    }
   
    @Test
    public void testTheStringIsMadeOfDigitOnly() {
        assertTrue (Validation.isTheStringMadeOfDigitOnly("1234587651"));
    }
    
    @Test
    public void testTheStringIsNotMadeOfDigitOnly() {
        assertFalse (Validation.isTheStringMadeOfDigitOnly("a12345"));
    }
    
}
