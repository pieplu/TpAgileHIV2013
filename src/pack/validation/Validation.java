/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mathieu Latour
 */
public class Validation {

    
    public static boolean isTheStringMadeOfDigitOnly(String onlyDigits) {
        System.out.println(onlyDigits);
        for (int i = 0; i < onlyDigits.length(); i++) {
            if (!(isTheCharacterADigit(onlyDigits.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTheCharacterADigit(char theCharacter) {
        return Character.isDigit(theCharacter);
    }
}

    
    
    
    
   

    
    
    
    
    

    
