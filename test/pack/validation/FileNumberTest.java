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
 * @author utilisateur
 */
public class FileNumberTest {
    
   @Test
    public void testFileNumberIsValid() {
        assertTrue(FileNumber.isFileNumberValid("A123456"));
    }
   
   @Test
    public void testFileNumberOfDigitsIsValid() {
        assertTrue(FileNumber.isFileNumberValid("A123456"));
    }

    @Test
    public void testFileNumberIsInvalidAllChars() {
        assertFalse(FileNumber.isFileNumberValid("Abcdefg"));
    }

    @Test
    public void testFileNumberIsInvalidHas1Char() {
        assertFalse(FileNumber.isFileNumberValid("A12345a"));
    }

    @Test
    public void testFileNumberIsInvalidNumberFormatInvalid() {
        assertFalse(FileNumber.isFileNumberValid("123"));
    }

    public void testFileNumberIsNegative() {
        assertFalse(FileNumber.isFileNumberValid("-12345"));
    }

    @Test(expected = NullPointerException.class)
    public void testFileNumberINull() {
        assertNull(FileNumber.isFileNumberValid(null));
    }


    @Test
    public void testFileNumberOfDigitsIsInvalid() {
        assertFalse(FileNumber.isFileNumberValid("12345"));
    }

    @Test(expected = NullPointerException.class)
    public void testFileNumberOfDigitsIsNull() {
        assertNull(FileNumber.isFileNumberValid(null));
    }
}

