/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import pack.validation.Validation;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mathieu Latour
 */
public class ValidationTest {
    
    public ValidationTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testClientNumberIsValid() {
        assertTrue (ClientID.isClientNumberValid("123456"));
    }
    
    @Test
    public void testClientNumberIsInvalidAllChars() {
        assertFalse (ClientID.isClientNumberValid("abcdef"));
    }
    
    @Test
    public void testClientNumberIsInvalidHas1Char() {
        assertFalse (ClientID.isClientNumberValid("12345a"));
    }
    
    @Test
    public void testClientNumberIsInvalidNumberFormatInvalid() {
        assertFalse (ClientID.isClientNumberValid("123"));
    }
    
    public void testClientNumberIsNegative() {
        assertFalse (ClientID.isClientNumberValid("-12345"));
    }
    
    @Test (expected=NullPointerException.class)
    public void testClientNumberINull() {
        assertNull(ClientID.isClientNumberValid(null));
    }

    @Test
    public void testClientNumberOfDigitsIsValid() {
        assertTrue(ClientID.isClientNumberValid("123456"));
    }
    
    @Test
    public void testClientNumberOfDigitsIsInvalid() {
        assertFalse(ClientID.isClientNumberValid("12345"));
    }
    
    @Test (expected=NullPointerException.class)
    public void testClientNumberOfDigitsIsNull() {
        assertNull(ClientID.isClientNumberValid(null));
    }
   
    @Test
    public void testTheStringIsMadeOfDigitOnly() {
        assertTrue (ClientID.isTheStringMadeOfDigitOnly("1234587651"));
    }
    
    @Test
    public void testTheStringIsNotMadeOfDigitOnly() {
        assertFalse (ClientID.isTheStringMadeOfDigitOnly("a12345"));
    }
    
    
    
    
    
    
    @Test
    public void testContractLetterIsValid(){
        assertTrue (Validation.isContractLetterValid("A"));
        assertTrue (Validation.isContractLetterValid("B"));
        assertTrue (Validation.isContractLetterValid("C"));
        assertTrue (Validation.isContractLetterValid("D"));
    }
    
    @Test
    public void testContractLetterIsInvalid(){
        assertFalse (Validation.isContractLetterValid("M"));
    }
    
    
    
    
    
    
    
    @Test
    public void containsDollarSignAtTheEnd(){
        assertTrue (Validation.containsDollarSignAtTheEnd("0.0000000000000$"));
    }
    
    @Test
    public void containsNoDollarSignAtTheEnd(){
        assertFalse (Validation.containsDollarSignAtTheEnd("0.0000000000000"));
    }
    
    
    @Test
    public void containsDotForCents(){
        assertTrue (Validation.containsDollarSignAtTheEnd("1.25$"));
    }
    
    @Test
    public void containsNoDotForCents(){
        assertFalse (Validation.containsDotForCents("1025$"));
    }
    
    
    @Test
    public void amountFormIsValid(){
        assertTrue (Validation.isAmountFormValid("1000.25$"));
    }

    
    @Test
    public void amountFormIsInvalidMissingDot(){
        assertFalse (Validation.isAmountFormValid("1025$"));
    }
    
    @Test 
    public void amountMinimumLengthForAmountValid(){
        assertTrue (Validation.isMinimumLengthForAmountValid("1000.25$"));
    }
    
    @Test 
    public void amountFormIsInvalidLengthIsTooSmall(){
        assertFalse (Validation.isAmountFormValid(".00$"));
    }
    
    @Test
    public void amountFormIsInvalidMissingDollarSign(){
        assertFalse (Validation.isAmountFormValid("1025.00"));
    }
    
    @Test
    public void amountFormIsInvalidMissingOneDigitForCents(){
        assertFalse (Validation.isAmountFormValid("1025.0$"));
    }
    
    
    
    @Test
    public void amountFormIsInvalidOneDigitIsAChar(){
        assertFalse (Validation.isAmountFormValid("10a5.0$"));
    }
    
    
    
    
    @Test
    public void dateFormatValid (){
        assertTrue (Validation.isDateFormValid("2013-01"));
    }
    
    @Test
    public void dateFormatInvalid (){
        assertFalse (Validation.isDateFormValid("2013-01-"));
    }
    
    
    @Test
    public void dateLengthValid (){
        assertTrue (Validation.isDateLengthValid("2013-01"));
    }
    
    @Test
    public void dateLengthInvalid (){
        assertFalse (Validation.isDateLengthValid("20131-01"));
    }
    
   
    @Test
    public void dateWithoutDashesValid (){
        assertTrue (Validation.isDateWithDashes("2013-01"));
    }
    
    @Test
    public void dateWithoutDashesInvalid (){
        assertFalse (Validation.isDateWithDashes("2013.01"));
    }
    
    
    
    @Test
    public void isDateWithDigitsOnlyValid () {
        assertTrue (Validation.isDateWithDigitsOnly("2013-01", 0,3));
    }
    
    @Test
    public void isDateWithDigitsOnlyInvalid1 () {
        assertFalse (Validation.isDateWithDigitsOnly("2a13-01", 0,3));
    }
    
    @Test
    public void isDateWithDigitsOnlyInvalid2 () {
        assertFalse (Validation.isDateWithDigitsOnly("2013-a1", 5,6));
    }
    
    
    @Test
    public void dateMonthDigitNotGreaterThanTenValid (){
        assertTrue (Validation.isDateMonthDigitNotGreaterThanTen("2013-12"));
    }
    
    @Test
    public void dateMonthDigitNotGreaterThanTenInvalid (){
        assertFalse (Validation.isDateMonthDigitNotGreaterThanTen("2013-22"));
    }
    
    @Test
    public void reclamationMonthCorrespondsToActualMonth (){
    assertTrue (Validation.isReclamationMonthEqualActualMonth("2012-11","2012-11"));
    }
    
    @Test
    public void reclamationMonthDoesNotCorrespondToActualMonth (){
    assertFalse (Validation.isReclamationMonthEqualActualMonth("2012-12","2012-11"));
    }
    
    @Test
    public void serviceNumberIsValid (){
    assertTrue (Validation.isServiceNumberValid("100"));
    }
    
    @Test
    public void serviceNumberIsValid2 (){
    assertTrue (Validation.isServiceNumberValid("350"));
    }
    
     @Test
    public void serviceNumberIsInvalid (){
    assertFalse (Validation.isServiceNumberValid("1"));
    }
    
}
    
    
