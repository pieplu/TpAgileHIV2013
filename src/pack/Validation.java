/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mathieu Latour
 */
public class Validation {

    //DEVRONT ETRE STATIC SI DANS UNE AUTRE CLASSE QUE MAIN
    final static int VALID_LENGTH_FOR_CLIENT_ID = 6;
    final static int VALID_LENGTH_FOR_ACTUAL_MONTH = 7;
    final static int VALID_LENGTH_FOR_DATE = 7;
    final static int MINIMUM_LENGTH_FOR_AMOUNT = 5;
    final static String[] ArrayOfValidContractLetters = {"A", "B", "C", "D"};
    static String serviceList[] = new String[]{"0", "100", "200", "300",
        "400", "500", "600", "700"};

    public static boolean isTheCharacterADigit(char theCharacter) {
        return Character.isDigit(theCharacter);
    }

    /**
     *
     * @param string A string
     * @return true if all the characters of the string are digits,false
     * otherwise.
     */
    public static boolean isTheStringMadeOfDigitOnly(String onlyDigits) {
        System.out.println(onlyDigits);
        for (int i = 0; i < onlyDigits.length(); i++) {
            if (!(isTheCharacterADigit(onlyDigits.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if a client's identification number is valid in form. To be
     * valid,an ID must be made of exactly of
     * VALID_NUMBER_OF_DIGITS_FOR_CLIENT_ID.
     *
     * @param clientID The client's identification number (ID)
     * @return true if the ID is valid in form, false otherwise
     */
    public static boolean isClientNumberValid(String clientID) {
        return ((isClientNumberLengthValid(clientID)) && (isTheStringMadeOfDigitOnly(clientID)));
    }

    /**
     *
     * @param clientID The client's identification number (ID)
     * @return true if the ID matches the VALID_NUMBER_OF_DIGITS_FOR_CLIENT_ID,
     * false otherwise
     */
    public static boolean isClientNumberLengthValid(String clientID) {
        return (clientID.length() == VALID_LENGTH_FOR_CLIENT_ID);
    }

    /**
     * Determines if a client's type of insurance is valid in form. To be valid,
     * the contract letter must be within the array of possible letters (see
     * constant ArrayOfValidContractLetters) IMPORTANT: DOIT FAIRE DES TESTS
     *
     * @param contractLetter The client's type of insurance represented by a
     * letter
     * @return true if the contract letter is valid in form, false otherwise
     */
    public static boolean isContractLetterValid(String contractLetter) {
        for (int i = 0; i < ArrayOfValidContractLetters.length; i++) {
            if (contractLetter.equals(ArrayOfValidContractLetters[i])) {
                return true;
            }
        }
        return false;
    }
    // XXXXXXX .XX$

    /**
     *
     * @param costForTheService The price the client paid for a service
     * @return true if the form follows those standards : - String must have a
     * minimum length of 5 - Ends with a $. - Has two digits for the cents
     * followed by a dot (.XX$). - Every part of the String is a digit except
     * for the dot.
     *
     * false otherwise
     */
    public static boolean isAmountFormValid(String amount) {
        return ((isMinimumLengthForAmountValid(amount))
                && (containsDollarSignAtTheEnd(amount))
                && (containsDotForCents(amount))
                && (isTheStringMadeOfDigitOnly(amount.substring(amount.length() - 3, amount.length() - 1)))
                && (isTheStringMadeOfDigitOnly(amount.substring(0, amount.length() - 4))));
    }

    /**
     * Determines if the amount in parameters has a length of at least
     * MINIMUM_LENGTH_FOR_AMOUNT
     *
     * @param amount that must verified
     * @return true the amount in parameters has a length of at least
     * MINIMUM_LENGTH_FOR_AMOUNT, false otherwise
     *
     */
    public static boolean isMinimumLengthForAmountValid(String amount) {
        return amount.length() >= MINIMUM_LENGTH_FOR_AMOUNT;
    }

    /**
     * Determines if the String in parameters ends with a dollar sign ($)
     *
     * @param amountInDollars is the String that must verified
     * @return true it it ends with the dollar sign ($), false otherwise
     *
     */
    public static boolean containsDollarSignAtTheEnd(String amountInDollars) {
        return amountInDollars.charAt(amountInDollars.length() - 1) == '$';
    }

    // Doit vérifier si y'a au moins 4 caracts.
    public static boolean containsDotForCents(String amountInDollars) {
        return amountInDollars.charAt(amountInDollars.length() - 4) == '.';
    }

    //DEMANDER A ALEXIS
    public static boolean monthValide(String monthFrom) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        dateFormat.setLenient(false);
        Date date = null;
        boolean bool = true;
        try {
            date = dateFormat.parse(monthFrom);
        } catch (ParseException e) {
            //System.out.println("renvoie de fichier mois invalide");
            bool = false;
        }
        return bool;
    }

    //DEMANDER A ALEXIS
    public static int transformTwoCharInInt(int pos1, int pos2, String date) {
        String nb = "" + date.charAt(pos1) + date.charAt(pos2);
        int dateInt = Integer.parseInt(nb);
        return dateInt;
    }

    public static boolean isDateFormValid(String date) {
        return (isDateLengthValid(date)
                && isDateWithDigitsOnly(date, 0, 3)
                && isDateWithDigitsOnly(date, 5, 6)
                && isDateWithDashes(date)
                && isDateMonthDigitNotGreaterThanTen(date));
    }

    public static boolean isDateLengthValid(String date) {
        return date.length() == VALID_LENGTH_FOR_DATE;
    }

    //FORMAT: XXXX-XX, where X must be within 0 or 9 only
    public static boolean isDateWithDigitsOnly(String date, int indexStart, int indexEnd) {
        boolean isValid = true;
        for (int i = indexStart; i <= indexEnd; i++) {
            if (!isTheCharacterADigit(date.charAt(i))) {
                isValid = false;
            }
        }
        return isValid;
    }

    public static boolean isDateWithDashes(String date) {
        return (date.charAt(4) == '-');
    }

    public static boolean isDateMonthDigitNotGreaterThanTen(String date) {
        return date.charAt(5) == '0' || date.charAt(5) == '1';
    }

    //DEMANDER A ALEXIS
    public static boolean dateValide(String dateFrom) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date date = null;
        boolean bool = true;
        try {
            date = dateFormat.parse(dateFrom);
        } catch (ParseException e) {
            //System.out.println("renvoie de fichier date invalide");
            bool = false;
        }
        return bool;
    }

    public static boolean isReclamationMonthEqualActualMonth(String reclamationMonth, String actualMonth) {
        return reclamationMonth.equals(actualMonth);
    }
    
    
    
    
    

    public static boolean isServiceNumberValid(String serviceNumber) {
        return (arrayServiceList(serviceNumber));
    }

    public static boolean arrayServiceList(String serviceNumber) {
        serviceNumber = formatServiceNumberToExpectedValue(serviceNumber, 300, 399);
        
        boolean isValid =false;
        for (int i = 0; i < serviceList.length; i++) {
            if (serviceNumber.equals(serviceList[i])) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static String formatServiceNumberToExpectedValue(String serviceNumber, int minValue, int maxValue) {
        if ((Integer.parseInt(serviceNumber) >= minValue) && (Integer.parseInt(serviceNumber) <= maxValue)) {
            return ""+ minValue;
        } else {
            return serviceNumber;
        }
    }
}
