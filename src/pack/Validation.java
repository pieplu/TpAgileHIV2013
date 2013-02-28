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
    final static int VALID_NUMBER_OF_DIGITS_FOR_CLIENT_ID = 6;
    final static int VALID_NUMBER_OF_DIGITS_FOR_ACTUAL_MONTH = 7;
    final static int VALID_NUMBER_OF_DIGITS_FOR_DATE = 10;
    static String serviceList[] = new String[]{"0", "100", "200", "300",
        "400", "500", "600", "700"};


    /**
     * Determines if a client identification number is valid in form. 
     * To be valid,an ID must be made of exactly of VALID_NUMBER_OF_DIGITS_FOR_CLIENT_ID.
     * 
     * @param clientID The client's identification number (ID)
     * @return true if the ID is valid in form, false otherwise
     */
    public static boolean isClientNumberValid(String clientID) {
      return ( (isClientNumberOfDigitsValid(clientID)) && (isTheStringMadeOfDigitOnly(clientID)) );
    }
    /**
     * 
     * @param clientID The client's identification number (ID)
     * @return true if the ID matches the VALID_NUMBER_OF_DIGITS_FOR_CLIENT_ID,
     *        false otherwise
     */
    public static boolean isClientNumberOfDigitsValid (String clientID){
        return (clientID.length() == VALID_NUMBER_OF_DIGITS_FOR_CLIENT_ID);
    }
    
    /**
     * 
     * @param string A string
     * @return true if all the characters of the string are digits,false otherwise.
     */
    public static boolean isTheStringMadeOfDigitOnly(String string) {
      for (int i = 0; i < string.length(); i++) {
            if ( !(Character.isDigit(string.charAt(i)) )  ) {
                return false;
            }
        }
      return true;
    }

    
    public static boolean isContractLetterValid(String contractLetter) {
        //\u0000 est la valeur d'un char non initialiser
        if (contractLetter == null) {
            //System.out.println("Ce client n'a pas de type de contrat");
            return false;
        }


        if ((contractLetter.equals("A")) || (contractLetter.equals("B"))
                || (contractLetter.equals("C")) || (contractLetter.equals("D"))) {

            return true;

        } else {
            //Ou mieux encore, mettre la methode qui creer un XML pour les cas defect.
            //Si c'est le cas, la methode retourne void
            return false;
        }
    }

    public static boolean isAmountFormValid(String amount) {
        if (amount.charAt((amount.length() - 1)) == '$') {

            if (Character.isDigit(amount.charAt((amount.length() - 2)))) {

                if ((Character.isDigit(amount.charAt((amount.length() - 3))))) {

                    if (amount.charAt((amount.length() - 4)) == '.') {

                        for (int i = 0; i < (amount.length() - 4); i++) {
                            if (Character.isDigit(amount.charAt(i))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        //System.out.println("Le montant est vraiment pas valide");
        return false;

    }

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

    public static int transformTwoCharInInt(int pos1, int pos2, String date) {
        String nb = "" + date.charAt(pos1) + date.charAt(pos2);
        int dateInt = Integer.parseInt(nb);
        return dateInt;
    }

    public static boolean isTheCharADigit(char a){
        
        return true;
    }
    
    
    public static boolean isDateFormValid(String date) {

        if (date.length() == VALID_NUMBER_OF_DIGITS_FOR_DATE) {
            if ((date.charAt(4) == '-') && (date.charAt(7) == '-')) {
                for (int i = 0; i <= 3; i++) {
                    if (!isTheCharADigit(date.charAt(i))) {
                        return false;
                    }
                }

                for (int i = 5; i <= 6; i++) {
                    if (!isTheCharADigit(date.charAt(i))) {
                        return false;
                    }
                    if ((date.charAt(5) != '0') && (date.charAt(5) != '1')) {

                        //     System.out.println("Not supposed to be here");
                        return false;
                    }

                }
                for (int i = 8; i <= 9; i++) {
                    if (!isTheCharADigit(date.charAt(i))) {
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

        if (month.length() == VALID_NUMBER_OF_DIGITS_FOR_ACTUAL_MONTH) {
            if ((month.charAt(4) == '-')) {

                for (int i = 0; i <= 3; i++) {

                    if (!isTheCharADigit(month.charAt(i))) {

                        return false;
                    }
                }

                for (int i = 5; i < month.length(); i++) {

                    if (!isTheCharADigit(month.charAt(i))) {

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
