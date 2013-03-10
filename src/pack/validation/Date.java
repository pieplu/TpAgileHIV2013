/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import pack.ExecutionValidation;

/**
 *
 * @author utilisateur
 */
public class Date {
    
     public static boolean isDateValid (String reclamationMonth, String date){
         if ( (dateFormatYearMonth(reclamationMonth) &&
                dateFormatYearMonthDay(date) &&
                reclamationMonth.equals(date.substring(0,7)))){
             return true;
         }else{
             ExecutionValidation.setErrorMessage("Une date n'est pas valide.");
             return false;
         }
    }
    
    //FORMAT: YYYY-MM, 
    public static boolean dateFormatYearMonth(String monthFrom) {
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
    public static boolean dateFormatYearMonthDay(String dateFrom) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        java.util.Date date = null;
        boolean bool = true;
        try {
            date = dateFormat.parse(dateFrom);
        } catch (ParseException e) {
            bool = false;
        }
        return bool;
    }
    
}
