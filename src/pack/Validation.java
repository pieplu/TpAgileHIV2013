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
    final static int VALID_LENGTH_FOR_DATE = 10;
    final static int MINIMUM_LENGTH_FOR_AMOUNT = 5;
    final static String[] ArrayOfValidContractLetters = {"A", "B", "C", "D"};
    static String serviceList[] = new String[]{"0", "100", "200", "300",
        "400", "500", "600", "700"};


    public static boolean isTheCharacterADigit(char theCharacter){
        return isTheCharacterADigit(theCharacter);
    }
    
    /**
     * Determines if a client's identification number is valid in form. 
     * To be valid,an ID must be made of exactly of VALID_NUMBER_OF_DIGITS_FOR_CLIENT_ID.
     * 
     * @param clientID The client's identification number (ID)
     * @return true if the ID is valid in form, false otherwise
     */
    public static boolean isClientNumberValid(String clientID) {
      return ( (isClientNumberLengthValid(clientID)) && (isTheStringMadeOfDigitOnly(clientID)) );
    }
    /**
     * 
     * @param clientID The client's identification number (ID)
     * @return true if the ID matches the VALID_NUMBER_OF_DIGITS_FOR_CLIENT_ID,
     *        false otherwise
     */
    public static boolean isClientNumberLengthValid (String clientID){
        return (clientID.length() == VALID_LENGTH_FOR_CLIENT_ID);
    }
    
    /**
     * 
     * @param string A string
     * @return true if all the characters of the string are digits,false otherwise.
     */
    public static boolean isTheStringMadeOfDigitOnly(String string) {
      for (int i = 0; i < string.length(); i++) {
            if ( !(isTheCharacterADigit(string.charAt(i)) )  ) {
                return false;
            }
        }
      return true;
    }
    
    
    
    
    

    /**
     * Determines if a client's type of insurance is valid in form. 
     * To be valid, the contract letter must be within the array of
     * possible letters (see constant ArrayOfValidContractLetters)
     * IMPORTANT: DOIT FAIRE DES TESTS
     * @param contractLetter The client's type of insurance represented by a letter 
     * @return true if the contract letter is valid in form, false otherwise
     */
    public static boolean isContractLetterValid(String contractLetter) {
        for (int i = 0; i < ArrayOfValidContractLetters.length; i++){
            if (contractLetter.equals(ArrayOfValidContractLetters[i])){
                return true;
            }   
        }
        return false;
    }
    
    /**
     * 
     * @param costForTheService The price the client paid for a service  
     * @return true if the form follows those standards :
     * - String must have a minimum length of 5
     * - Ends with a $.
     * - Has two digits for the cents followed by a dot (.XX$).
     * - Every part of the String is a digit except for the dot.
     * 
     *        false otherwise
     */
    public static boolean isAmountFormValid(String costForTheService) {
            return( (isMinimumLengthForAmountValid (costForTheService)) &&
                    (containsDollarSignAtTheEnd(costForTheService)) && 
                    (containsDotForCents(costForTheService)) &&
                    (isTheStringMadeOfDigitOnly(costForTheService.substring(costForTheService.length()-2,costForTheService.length()-3))) &&
                    (isTheStringMadeOfDigitOnly(costForTheService.substring(0,costForTheService.length()-5)))   
                   ); 
    }
    /**
     * Determines if the amount in parameters has a length of at least MINIMUM_LENGTH_FOR_AMOUNT
     * 
     * @param amount that must verified
     * @return true the amount in parameters has a length of at least MINIMUM_LENGTH_FOR_AMOUNT, false otherwise
     * 
     */
    public static boolean isMinimumLengthForAmountValid (String amount){
        return amount.length() >= MINIMUM_LENGTH_FOR_AMOUNT;
    }
    /**
     * Determines if the String in parameters ends with a dollar sign ($)
     * 
     * @param amountInDollars is the String that must verified
     * @return true it it ends with the dollar sign ($), false otherwise
     * 
     */
    public static boolean containsDollarSignAtTheEnd (String amountInDollars){
        return amountInDollars.charAt(amountInDollars.length()-1) == '$';
    }
    
    // Doit vérifier si y'a au moins 4 caracts.
    public static boolean containsDotForCents (String amountInDollars){      
        return amountInDollars.charAt(amountInDollars.length()-4) == '.';
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
       return (isDateLengthValid(date)&&
               
               )
    }
    
    public static boolean isDateLengthValid (String date){
        return date.length() == VALID_LENGTH_FOR_DATE;
     }
    
    public static boolean isDateWithDashes(String date){
        
    }
            if ((date.charAt(4) == '-') && (date.charAt(7) == '-')) {
                for (int i = 0; i <= 3; i++) {
                    if (!isTheCharacterADigit(date.charAt(i))) {
                        return false;
                    }
                }

                for (int i = 5; i <= 6; i++) {
                    if (!isTheCharacterADigit(date.charAt(i))) {
                        return false;
                    }
                    if ((date.charAt(5) != '0') && (date.charAt(5) != '1')) {

                        //     System.out.println("Not supposed to be here");
                        return false;
                    }

                }
                for (int i = 8; i <= 9; i++) {
                    if (!isTheCharacterADigit(date.charAt(i))) {
                        return false;
                    }
                    if (transformTwoCharInInt(8, 9, date) > 31) {
                        return false;
                    }

                }
            }
        } else {
            return false;
        }
        return true;
    }

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

    public static boolean isActualMonthFormValid(String month) {

        if (month.length() == VALID_LENGTH_FOR_ACTUAL_MONTH) {
            if ((month.charAt(4) == '-')) {

                for (int i = 0; i <= 3; i++) {

                    if (!isTheCharacterADigit(month.charAt(i))) {

                        return false;
                    }
                }

                for (int i = 5; i < month.length(); i++) {

                    if (!isTheCharacterADigit(month.charAt(i))) {

                        return false;
                    }
                }

                if ((month.charAt(5) != '0') && (month.charAt(5) != '1')) {

                    return false;
                }
            }

            return true;
        } else {
            return false;
        }

    }

    public static boolean isDateValid(String reclamationMonth, String actualMonth) {
        if (reclamationMonth == null) {
            //System.out.println("Erreur: Ce client ne contient pas de date de reclamation");
            return false;
        }


        //System.out.println(reclamationMonth.substring(0, 7) + "   " + actualMonth);
        if ((Validation.isDateFormValid(reclamationMonth)) && (reclamationMonth.substring(0, 7).equals(actualMonth))) {
            // System.out.println("J'ai passé le test");
            return true;


        } else {
            //Ou mieux encore, mettre la methode qui creer un XML pour les cas defect.
            //Si c'est le cas, la methode retourne void
            return false;

        }
    }

    public static boolean isServiceNumberValid(String serviceNumber) {
        if (arrayServiceList(serviceNumber)) {

            return true;
        } else {
            //Ou mieux encore, mettre la methode qui creer un XML pour les cas defect.
            //Si c'est le cas, la methode retourne void
            return false;
        }

    }

    public static boolean arrayServiceList(String serviceNumber) {
        boolean test = false;
        if ((Integer.parseInt(serviceNumber) > 300) && (Integer.parseInt(serviceNumber) < 400)) {
            serviceNumber = "300";
        }

        for (int i = 0; i < serviceList.length; i++) {
            if (serviceNumber.equals(serviceList[i])) {
                test = true;
            }
        }
        return test;
    }
    
    
}
