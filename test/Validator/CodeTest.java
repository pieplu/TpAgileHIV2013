/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mathieu Latour
 */
public class CodeTest {
    
      
    @Test
    public void testCodeLetterIsValidA() {
        assertTrue(Code.isCodeValid("A"));
    }
    
    @Test
    public void testCodeLetterIsValidC() {
        assertTrue(Code.isCodeValid("C"));
    }
    
    @Test
    public void testCodeLetterIsValidE() {
        assertTrue(Code.isCodeValid("E1"));
    }
    
    @Test
    public void testCodeLetterIsValidH() {
        assertTrue(Code.isCodeValid("H2"));
    }
    
    @Test
    public void testCodeLetterIsInvalid() {
        assertFalse(Code.isCodeValid("1"));
    }
    
    @Test
    public void testCodeLetterIsInvalid2() {
        assertFalse(Code.isCodeValid("a"));
    }
    
    @Test
    public void testCodeLetterIsInvalid3() {
        assertFalse(Code.isCodeValid("AA"));
    }
    
    @Test
    public void testCodeLetterIsInvalid4() {
        assertFalse(Code.isCodeValid("HA"));
    }
    
     @Test
    public void testCodeLetterIsInvalid5() {
        assertFalse(Code.isCodeValid("EP"));
    }
    
    @Test
    public void testCodeLetterIsEmpty() {
        assertFalse(Code.isCodeValid(""));
    }
    
}
