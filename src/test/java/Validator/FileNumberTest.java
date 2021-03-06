/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;
import Validator.FileNumber;
import static org.junit.Assert.*;
import org.junit.Test;

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

