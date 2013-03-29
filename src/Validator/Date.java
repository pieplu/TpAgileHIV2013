package Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import InsuranceSoftware.ValidationRunner;

public class Date {
    
    
    final static int LENGTH_YYYY_MM = 7 ;
    final static int LENGTH_YYYY_MM_DD = 10 ;
    
     public static boolean isDateValid (String reclamationMonth, String date){
         if ( ( isMonthLengthValid(reclamationMonth) &&
                isDateLengthValid(date) &&
                dateFormatYearMonth(reclamationMonth) &&
                dateFormatYearMonthDay(date) &&
                reclamationMonth.equals(date.substring(0,7)))){
             return true;
         }else{
             ValidationRunner.setErrorMessage("La date ne correspond pas avec le mois de la réclamation.");
             return false;
         }
    }
     
     private static boolean isMonthLengthValid (String month){
         return month.length() == LENGTH_YYYY_MM;
     }
     
      private static boolean isDateLengthValid (String date){
         return date.length() == LENGTH_YYYY_MM_DD;
     }
    
    /*
     * API JAVA FORMAT: yyyy-MM
     * Parse the String in parameter and verifies this supported by the date of API Java.
     * Note: Leap years are also included.
     * 
     * Throws an exception if it's not supported.
     */
    private static boolean dateFormatYearMonth(String monthFrom) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        dateFormat.setLenient(false);
        boolean isDateValid = true;
        try {
            java.util.Date date = dateFormat.parse(monthFrom);
        } catch (ParseException e) {
            isDateValid = false;
        }
        return isDateValid;
    }
    
    /*
     * API JAVA FORMAT: yyyy-MM-dd
     * Parse the String in parameter and verifies this supported by the date of API Java.
     * Note: Leap years are also included.
     * 
     * Throws an exception if it's not supported.
     */
    private static boolean dateFormatYearMonthDay(String dateFrom) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        boolean isDateValid = true;
        try {
            java.util.Date date = dateFormat.parse(dateFrom);
        } catch (ParseException e) {
            isDateValid = false;
        }
        return isDateValid;
    }
    
}
