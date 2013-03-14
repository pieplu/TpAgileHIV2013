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
            ValidationExecution.setErrorMessage("Un numero de soin est invalide.");
            return false;
        }
    }

    private static boolean arrayServiceList(String serviceNumber) {
        try {
            serviceNumber = formatServiceNumberToExpectedValue(serviceNumber, 300, 399);
            for (int i = 0; i < serviceList.length; i++) {
                if (serviceNumber.equals(serviceList[i])) {
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    private static String formatServiceNumberToExpectedValue(String serviceNumber, int minValue, int maxValue) {
        
        if ((Integer.parseInt(serviceNumber) >= minValue) && (Integer.parseInt(serviceNumber) <= maxValue)) {
            return ""+ minValue;
        } else {
            return serviceNumber;
        }
    }
    
}
    

