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
 * @author hj991118
 */
public class AmountTest {

    

    @Test
    public void containsNoDotForCents() {
        assertFalse(Dollar.containsDotForCents("1025$"));
    }

    @Test
    public void amountFormatIsValid() {
        assertTrue(Dollar.isAmountFormValid("1000.25$"));
    }

    @Test
    public void amountFormatIsInvalidMissingDot() {
        assertFalse(Dollar.isAmountFormValid("1025$"));
    }
    
    @Test
    public void amountFormatWithComma() {
        assertTrue(Dollar.isAmountFormValid("1025,01$"));
    }

    

    @Test
    public void amountFormatIsInvalidLengthIsTooSmall() {
        assertFalse(Dollar.isAmountFormValid(".00$"));
    }

    @Test
    public void amountFormatIsInvalidMissingDollarSign() {
        assertFalse(Dollar.isAmountFormValid("1025.00"));
    }

    @Test
    public void amountFormatIsInvalidMissingOneDigitForCents() {
        assertFalse(Dollar.isAmountFormValid("1025.0$"));
    }

    @Test
    public void amountFormatIsInvalidOneDigitIsAChar() {
        assertFalse(Dollar.isAmountFormValid("10a5.0$"));
    }
}
