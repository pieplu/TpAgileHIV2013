package Validator;

import InsuranceSoftware.ValidationRunner;
import Validator.StringAnalyzer;

public class Dollar {
    
   
    final static int MINIMUM_LENGTH_FOR_AMOUNT = 5;

   
    public static boolean isAmountFormValid(String amount) {
        if( ((isMinimumLengthForAmountValid(amount))
                && (containsDollarSignAtTheEnd(amount))
                && (containsDotForCents(amount))
                && (StringAnalyzer.isTheStringMadeOfDigitOnly(amount.substring(amount.length() - 3, amount.length() - 1)))
                && (StringAnalyzer.isTheStringMadeOfDigitOnly(amount.substring(0, amount.length() - 4))))){
            return true;
        }else{
            ValidationRunner.setErrorMessage("Erreur: Un montant n'est pas valide.");
            return false;
        }
    }
 
    public static boolean isMinimumLengthForAmountValid(String amount) {
        return amount.length() >= MINIMUM_LENGTH_FOR_AMOUNT;
    }

    
    public static boolean containsDollarSignAtTheEnd(String amountInDollars) {
        return amountInDollars.charAt(amountInDollars.length() - 1) == '$';
    }

    
    public static boolean containsDotForCents(String amountInDollars) {
        return amountInDollars.charAt(amountInDollars.length() - 4) == '.' ||
               amountInDollars.charAt(amountInDollars.length() - 4) == ',' ;
    }
    
    public static String removeDotAndCommaFromString(String amountInDollars){
        amountInDollars = amountInDollars.replace(",", "");
        amountInDollars = amountInDollars.replace(".", "");
        
        return amountInDollars;
    }

    public static int returnDollarValueInCents (String amountInDollars){
        int amountAsIntegers = Integer.parseInt(amountInDollars);
        return amountAsIntegers;
    }
    
    public static String formatAmmountToStandartFormat(int ammountToFormat) {
        String cents = "";
        if(ammountToFormat % 100 == 0){
            cents = "0";
        }
        
        if (ammountToFormat < 10) {
            return "0.0" + (ammountToFormat % 100) + "$";
        } else{
            return (ammountToFormat / 100) + "." + ammountToFormat % 100 + cents + "$";
        }
        
    }
    
}
