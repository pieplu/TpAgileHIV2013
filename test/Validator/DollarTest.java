/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;
import Validator.Dollar;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author fe291196
 */
public class DollarTest {
    
    @Test
    public void isAmountFormValid1() {
        assertTrue(Dollar.isAmountFormValid("200.00$"));
    }
    
    @Test
    public void isAmountFormValid2() {
        assertTrue(Dollar.isAmountFormValid("200,00$"));
    }
    
    @Test
    public void isAmountFormValid3() {
        assertTrue(Dollar.isAmountFormValid("0.00$"));
    }
    
}
