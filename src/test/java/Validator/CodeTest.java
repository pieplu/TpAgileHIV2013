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
        Code.listInputCodes.add("A");
        assertTrue(Code.areAllCodesValid());
    }
    
    @Test
    public void testCodeLetterIsValidC() {
        Code.listInputCodes.add("C");
        assertTrue(Code.areAllCodesValid());
    }
    
    
    @Test
    public void testCodeLetterIsValidE() {
        Code.listInputCodes.add("E1");
        assertTrue(Code.areAllCodesValid());
    }
    
    
    @Test
    public void testCodeLetterIsValidH() {
        Code.listInputCodes.add("H1");
        assertTrue(Code.areAllCodesValid());
    }

    @Test
    public void testCodeLetterIsInvalid() {
        Code.listInputCodes.add("1");
        assertFalse(Code.areAllCodesValid());
        Code.listInputCodes.remove("1");
    }
    
    @Test
    public void testCodeLetterIsInvalid2() {
        Code.listInputCodes.add("a");
        assertFalse(Code.areAllCodesValid());
        Code.listInputCodes.remove("a");
    }
    
    @Test
    public void testCodeLetterIsInvalid3() {
        Code.listInputCodes.add("AA");
        assertFalse(Code.areAllCodesValid());
        Code.listInputCodes.remove("AA");
    }
    
    @Test
    public void testCodeLetterIsInvalid4() {
        Code.listInputCodes.add("HA");
        assertFalse(Code.areAllCodesValid());
         Code.listInputCodes.remove("HA");
    }
    
     @Test
    public void testCodeLetterIsInvalid5() {
        Code.listInputCodes.add("EP");
        assertFalse(Code.areAllCodesValid());
        Code.listInputCodes.remove("EP");
    }
     
    @Test
    public void testCodeLetterIsInvalid6() {
        Code.listInputCodes.add("H3");
        assertFalse(Code.areAllCodesValid());
        Code.listInputCodes.remove("H3");
    }
      
    @Test
    public void testCodeLetterIsInvalid7() {
        Code.listInputCodes.add("h1");
        assertFalse(Code.areAllCodesValid());
        Code.listInputCodes.remove("h1");
    }
    
    @Test
    public void testCodeLetterIsInvalid10() {
        Code.listInputCodes.add("e13");
        assertFalse(Code.areAllCodesValid());
        Code.listInputCodes.remove("e13");
    }
    
    @Test
    public void testCodeLetterIsEmpty() {
         Code.listInputCodes.add("");
        assertFalse(Code.areAllCodesValid());
         Code.listInputCodes.remove("");
    }
    
    @Test
    public void testfindCodeLetterIndex(){
       assertEquals(Code.findCodeLetterIndex(null), -1);
    }
    
}
