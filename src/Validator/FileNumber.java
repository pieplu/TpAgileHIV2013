package Validator;

import InsuranceSoftware.ValidationRunner;

public class FileNumber {

    final static int VALID_LENGTH_FOR_FILE_NUMBER = 7;
  
    public static boolean isFileNumberValid(String FileNumber) {
        if ( ((isFileNumberLengthValid(FileNumber))  && 
                ContractLetter.isContractLetterValid(FileNumber.substring(0,1)) &&
               (StringAnalyzer.isTheStringMadeOfDigitOnly(FileNumber.substring(1)))) ){
            return true;
        }else{
            ValidationRunner.setErrorMessage("Erreur: Le numero de dossier est invalide.");
            return false;
        }
    }

    private static boolean isFileNumberLengthValid(String FileNumber) {
        return (FileNumber.length() == VALID_LENGTH_FOR_FILE_NUMBER);
    }

    
}
