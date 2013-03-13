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
public class ServiceNumber {
    
    
    static String serviceList[] = new String[]{"0", "100", "150", "175", "200", "300",
        "400", "500", "600", "700"};
    
    public static boolean isServiceNumberValid(String serviceNumber) {
        if ( (arrayServiceList(serviceNumber)) ) {
            return true;
        }else{
            ValidationExecution.setErrorMessage("Erreur: Un numero de service est invalide.");
            return false;
        }
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
    

