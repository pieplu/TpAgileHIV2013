package Validator;

import java.util.ArrayList;

/**
 *
 * @author Mathieu Latour
 */
public class Code {

    final static String[] ArrayOfValidCodeLetters = {"A", "C", "E", "H"};
    final static int MAXIMUM_LENGTH_FOR_CODE_A_AND_CODE_C = 1;
    final static int MINIMUM_LENGTH_FOR_CODE_E_AND_CODE_H = 1;
    public static ArrayList<String> listInputCodes = new ArrayList<String>();

    public static boolean areAllCodesValid() {
        boolean isValid = true;
        for (int i = 0; i < listInputCodes.size() && isValid; i++) {
            if (!isCodeValid(listInputCodes.get(i))) {
                isValid = false;
            }
        }
        return isValid;
    }

    public static boolean isCodeValid(String code) {
        int index = findCodeLetterIndex(code);
        if (index == 0 || index == 1) {
            return code.length() == MAXIMUM_LENGTH_FOR_CODE_A_AND_CODE_C; //is either A or C 
        } else if (index == 2) {
            return code.length() > MINIMUM_LENGTH_FOR_CODE_E_AND_CODE_H && isCodeELinear();
        } else if (index == 3) {
            return code.length() > MINIMUM_LENGTH_FOR_CODE_E_AND_CODE_H && isCodeHLinear();
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

    private static boolean isCodeELinear() {
        int highestNumber;
        try {
            highestNumber = findHighestNumberCodeE();
            for (int codeIndex = highestNumber; codeIndex > 0; codeIndex--) {
                if (!listInputCodes.contains("E" + codeIndex)) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private static boolean isCodeHLinear() {
        int highestNumber;
        try {
            highestNumber = findHighestNumberCodeH();
            for (int codeIndex = highestNumber; codeIndex > 0; codeIndex--) {
                if (!listInputCodes.contains("H" + codeIndex)) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    private static int findHighestNumberCodeE() throws NumberFormatException {
        int highestNumber = 0;
            for (int i = 0; i < listInputCodes.size(); i++) {
                if (listInputCodes.get(i).charAt(0) == 'E' && Integer.parseInt(listInputCodes.get(i).substring(1)) > highestNumber) {
                    highestNumber = Integer.parseInt(listInputCodes.get(i).substring(1, listInputCodes.get(i).length()));
                }
            }
        return highestNumber;
    }
    
     private static int findHighestNumberCodeH() throws NumberFormatException {
        int highestNumber = 0;
            for (int i = 0; i < listInputCodes.size(); i++) {
                if (listInputCodes.get(i).charAt(0) == 'H' && Integer.parseInt(listInputCodes.get(i).substring(1)) > highestNumber ) {
                    highestNumber = Integer.parseInt(listInputCodes.get(i).substring(1, listInputCodes.get(i).length()));
                }
            }
        return highestNumber;
    }
}
