/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

import Validator.ContractLetter;

/**
 *
 * @author hj991118
 */
public class ContractLetterTest {

    @Test
    public void testContractLetterIsValidA() {
        assertTrue(ContractLetter.isContractLetterValid("A"));
    }
    
    @Test
    public void testContractLetterIsValidB() {
        assertTrue(ContractLetter.isContractLetterValid("B"));
    }
    
    @Test
    public void testContractLetterIsValidC() {
        assertTrue(ContractLetter.isContractLetterValid("C"));
    }
    
    @Test
    public void testContractLetterIsValidD() {
        assertTrue(ContractLetter.isContractLetterValid("D"));
    }
    
    @Test
    public void testContractLetterIsValidE() {
        assertTrue(ContractLetter.isContractLetterValid("E"));
    }
    
    @Test
    public void testContractLetterIsInvalid() {
        assertFalse(ContractLetter.isContractLetterValid("M"));
    }
}
