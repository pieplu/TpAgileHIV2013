/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

/**
 *
 * @author utilisateur
 */
public class Amount {
    
    final static int MINIMUM_LENGTH_FOR_AMOUNT = 5;

   
    public static boolean isAmountFormValid(String amount) {
        return ((isMinimumLengthForAmountValid(amount))
                && (containsDollarSignAtTheEnd(amount))
                && (containsDotForCents(amount))
                && (Validation.isTheStringMadeOfDigitOnly(amount.substring(amount.length() - 3, amount.length() - 1)))
                && (Validation.isTheStringMadeOfDigitOnly(amount.substring(0, amount.length() - 4))));
    }

    
    public static boolean isMinimumLengthForAmountValid(String amount) {
        return amount.length() >= MINIMUM_LENGTH_FOR_AMOUNT;
    }

    
    public static boolean containsDollarSignAtTheEnd(String amountInDollars) {
        return amountInDollars.charAt(amountInDollars.length() - 1) == '$';
    }

    
    public static boolean containsDotForCents(String amountInDollars) {
        return amountInDollars.charAt(amountInDollars.length() - 4) == '.';
    }

    
}
