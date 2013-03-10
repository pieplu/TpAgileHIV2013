/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

/**
 *
 * @author hj991118
 */
public class ContractLetterTest {

    @Test
    public void testContractLetterIsValid() {
        assertTrue(ContractLetter.isContractLetterValid("A"));
        assertTrue(ContractLetter.isContractLetterValid("B"));
        assertTrue(ContractLetter.isContractLetterValid("C"));
        assertTrue(ContractLetter.isContractLetterValid("D"));
    }

    @Test
    public void testContractLetterIsInvalid() {
        assertFalse(ContractLetter.isContractLetterValid("M"));
    }
}
