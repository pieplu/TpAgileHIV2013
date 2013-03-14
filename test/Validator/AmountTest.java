/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;
import Validator.Amount;
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
        assertFalse(Amount.containsDotForCents("1025$"));
    }

    @Test
    public void amountFormatIsValid() {
        assertTrue(Amount.isAmountFormValid("1000.25$"));
    }

    @Test
    public void amountFormatIsInvalidMissingDot() {
        assertFalse(Amount.isAmountFormValid("1025$"));
    }
    
    @Test
    public void amountFormatWithComma() {
        assertTrue(Amount.isAmountFormValid("1025,01$"));
    }

    

    @Test
    public void amountFormatIsInvalidLengthIsTooSmall() {
        assertFalse(Amount.isAmountFormValid(".00$"));
    }

    @Test
    public void amountFormatIsInvalidMissingDollarSign() {
        assertFalse(Amount.isAmountFormValid("1025.00"));
    }

    @Test
    public void amountFormatIsInvalidMissingOneDigitForCents() {
        assertFalse(Amount.isAmountFormValid("1025.0$"));
    }

    @Test
    public void amountFormatIsInvalidOneDigitIsAChar() {
        assertFalse(Amount.isAmountFormValid("10a5.0$"));
    }
}
