/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;
import pack.validation.Amount;
import pack.validation.Validation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hj991118
 */
public class ClientIDTest {

    @Test
    public void testClientNumberIsValid() {
        assertTrue(ClientID.isClientNumberValid("123456"));
    }

    @Test
    public void testClientNumberIsInvalidAllChars() {
        assertFalse(ClientID.isClientNumberValid("abcdef"));
    }

    @Test
    public void testClientNumberIsInvalidHas1Char() {
        assertFalse(ClientID.isClientNumberValid("12345a"));
    }

    @Test
    public void testClientNumberIsInvalidNumberFormatInvalid() {
        assertFalse(ClientID.isClientNumberValid("123"));
    }

    public void testClientNumberIsNegative() {
        assertFalse(ClientID.isClientNumberValid("-12345"));
    }

    @Test(expected = NullPointerException.class)
    public void testClientNumberINull() {
        assertNull(ClientID.isClientNumberValid(null));
    }

    @Test
    public void testClientNumberOfDigitsIsValid() {
        assertTrue(ClientID.isClientNumberValid("123456"));
    }

    @Test
    public void testClientNumberOfDigitsIsInvalid() {
        assertFalse(ClientID.isClientNumberValid("12345"));
    }

    @Test(expected = NullPointerException.class)
    public void testClientNumberOfDigitsIsNull() {
        assertNull(ClientID.isClientNumberValid(null));
    }
}
