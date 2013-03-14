/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import pack.ValidationExecution;

/**
 *
 * @author utilisateur
 */
public class Amount {
    
   
    final static int MINIMUM_LENGTH_FOR_AMOUNT = 5;

   
    public static boolean isAmountFormValid(String amount) {
        if( ((isMinimumLengthForAmountValid(amount))
                && (containsDollarSignAtTheEnd(amount))
                && (containsDotForCents(amount))
                && (StringAnalyzer.isTheStringMadeOfDigitOnly(amount.substring(amount.length() - 3, amount.length() - 1)))
                && (StringAnalyzer.isTheStringMadeOfDigitOnly(amount.substring(0, amount.length() - 4))))){
            return true;
        }else{
            ValidationExecution.setErrorMessage("Erreur: Un montant n'est pas valide.");
            return false;
        }
    }
 
    private static boolean isMinimumLengthForAmountValid(String amount) {
        return amount.length() >= MINIMUM_LENGTH_FOR_AMOUNT;
    }

    
    private static boolean containsDollarSignAtTheEnd(String amountInDollars) {
        return amountInDollars.charAt(amountInDollars.length() - 1) == '$';
    }

    
    public static boolean containsDotForCents(String amountInDollars) {
        return amountInDollars.charAt(amountInDollars.length() - 4) == '.' ||
               amountInDollars.charAt(amountInDollars.length() - 4) == ',' ;
    }

    
}
