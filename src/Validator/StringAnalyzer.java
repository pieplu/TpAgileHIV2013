package Validator;

public class StringAnalyzer {
 
    public static boolean isTheStringMadeOfDigitOnly(String onlyDigits) {
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

    
    
    
    
   

    
    
    
    
    

    
