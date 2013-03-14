/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import InsuranceSoftware.ValidationRunner;

/**
 *
 * @author utilisateur
 */
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
             ValidationRunner.setErrorMessage("Une date n'est pas valide.");
             return false;
         }
    }
     
     private static boolean isMonthLengthValid (String month){
         return month.length() == LENGTH_YYYY_MM;
     }
     
      private static boolean isDateLengthValid (String date){
         return date.length() == LENGTH_YYYY_MM_DD;
     }
    
    //FORMAT: YYYY-MM, 
    private static boolean dateFormatYearMonth(String monthFrom) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        dateFormat.setLenient(false);
        boolean bool = true;
        try {
            java.util.Date date = dateFormat.parse(monthFrom);
        } catch (ParseException e) {
            bool = false;
        }
        return bool;
    }
    
    //FORMAT: YYYY-MM-DD
    private static boolean dateFormatYearMonthDay(String dateFrom) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        boolean bool = true;
        try {
            java.util.Date date = dateFormat.parse(dateFrom);
        } catch (ParseException e) {
            bool = false;
        }
        return bool;
    }
    
}
