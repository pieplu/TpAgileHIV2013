/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import pack.ExecutionValidation;

/**
 *
 * @author utilisateur
 */
public class FileNumber {

    final static int VALID_LENGTH_FOR_FILE_NUMBER = 7;
  
    public static boolean isFileNumberValid(String FileNumber) {
        if ( ((isFileNumberLengthValid(FileNumber))  && 
                ContractLetter.isContractLetterValid(FileNumber.substring(0,1)) &&
               (Validation.isTheStringMadeOfDigitOnly(FileNumber.substring(1)))) ){
            return true;
        }else{
            ExecutionValidation.setErrorMessage("Erreur: Le numero de dossier est invalide.");
            return false;
        }
    }

    public static boolean isFileNumberLengthValid(String FileNumber) {
        return (FileNumber.length() == VALID_LENGTH_FOR_FILE_NUMBER);
    }

    
}
