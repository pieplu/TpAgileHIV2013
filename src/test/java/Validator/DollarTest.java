/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;
import Validator.Dollar;
import static org.junit.Assert.*;
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
    
    @Test
    public void isAmountFormValidWithNoDollarSign() {
        assertFalse(Dollar.isAmountFormValid("0.00"));
    }
    
    @Test
    public void isAmountFormValidWithNoDotOrComma() {
        assertFalse(Dollar.isAmountFormValid("000$"));
    }
    
    @Test
    public void isAmountFormValidWithOnlyOneDigitForCents() {
        assertFalse(Dollar.isAmountFormValid("00.0$"));
    }
    
    @Test
    public void isAmountFormValidWithNoDollarAndOnlyCents() {
        assertFalse(Dollar.isAmountFormValid(".00$"));
    }
    
    @Test
    public void isMinimumLengthForAmountValidWithMinimumLength() {
        assertTrue(Dollar.isMinimumLengthForAmountValid("0.00$"));
    }
    
    @Test
    public void isMinimumLengthForAmountValidWithLongerThanMinimumLength() {
        assertTrue(Dollar.isMinimumLengthForAmountValid("10.00$"));
    }
    
    @Test
    public void isMinimumLengthForAmountValidWithShorterThanMinimumLength() {
        assertFalse(Dollar.isMinimumLengthForAmountValid(".00$"));
    }
    
    @Test
    public void containsDollarSignAtTheEndWithDollarSignAtTheEnd() {
        assertTrue(Dollar.containsDollarSignAtTheEnd("0.00$"));
    }
    
    @Test
    public void containsDollarSignAtTheEndWithoutDollarSignAtTheEnd() {
        assertFalse(Dollar.containsDollarSignAtTheEnd("00.00"));
    }
    
    @Test
    public void containsDotForCentsWithDot() {
        assertTrue(Dollar.containsDotForCents("10.00$"));
    }
    
    @Test
    public void containsDotForCentsWithoutDotOrComma() {
        assertFalse(Dollar.containsDotForCents("1000$"));
    }
    
    @Test
    public void containsDotForCentsWithComma() {
        assertTrue(Dollar.containsDotForCents("10,00$"));
    }
    
    @Test
    public void removeDotAndCommaFromStringThatRemovesComma() {
        assertEquals(Dollar.removeDotAndCommaFromString("10,00$"),"1000$");
    }
    
    @Test
    public void removeDotAndCommaFromStringThatRemovesDot() {
        assertEquals(Dollar.removeDotAndCommaFromString("10.00$"),"1000$");
    }
    
    @Test
    public void returnDollarValueInCents() {
        assertEquals(Dollar.returnDollarValueInCents("1000"),1000);
    }
    
    @Test
    public void formatAmountToStandardFormatWithNine() {
        assertEquals(Dollar.formatAmountToStandardFormat(9),"0.09$");
    }
    
    @Test
    public void formatAmountToStandardFormatWithTen() {
        assertEquals(Dollar.formatAmountToStandardFormat(10),"0.10$");
    }
    
    @Test
    public void formatAmountToStandardFormatWithHundred() {
        assertEquals(Dollar.formatAmountToStandardFormat(100),"1.00$");
    }
    
    @Test
    public void formatAmountToStandardFormatWithThousand() {
        assertEquals(Dollar.formatAmountToStandardFormat(1000),"10.00$");
    }
    
    @Test
    public void formatAmountToStandardFormatWithThousandAndTwelve() {
        assertEquals(Dollar.formatAmountToStandardFormat(1012),"10.12$");
    }
    
}
