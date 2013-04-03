package Validator;

/**
 *
 * @author Mathieu Latour
 */
public class Code {

    final static String[] ArrayOfValidCodeLetters = {"A", "C", "E", "H"};
    final static int MAXIMUM_LENGTH_FOR_CODE_A_AND_CODE_C = 1;
    final static int MINIMUM_LENGTH_FOR_CODE_E_AND_CODE_H = 1;

    public static boolean isCodeValid(String code) {
        
            int index = findCodeLetterIndex(code);
            if (index == 0 || index == 1) {
                return code.length() == MAXIMUM_LENGTH_FOR_CODE_A_AND_CODE_C; //is either A or C 
            } else if (index == 2 || index == 3) {
                return code.length() >= MINIMUM_LENGTH_FOR_CODE_E_AND_CODE_H && StringAnalyzer.isTheStringMadeOfDigitOnly(code.substring(1, code.length())); //is either E or H
            } else {
                return false;
            }
        
    }

    private static int findCodeLetterIndex(String code) {
        try {   
        for (int i = 0; i < ArrayOfValidCodeLetters.length; i++) {
            if (code.substring(0, 1).equals(ArrayOfValidCodeLetters[i])) {
                return i;
            }
        }
        return -1;
        } catch (Exception e) {
            return -1;
        }
    }
}
