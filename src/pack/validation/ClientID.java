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
public class ClientID {

    final static int VALID_LENGTH_FOR_CLIENT_ID = 6;

    public static boolean isClientNumberValid(String clientID) {
        if ( ((isClientNumberLengthValid(clientID)) && (Validation.isTheStringMadeOfDigitOnly(clientID))) ){
            return true;
        }else{
            ExecutionValidation.setErrorMessage("Erreur: Le numero de client est invalide.");
            return false;
        }
    }

    public static boolean isClientNumberLengthValid(String clientID) {
        return (clientID.length() == VALID_LENGTH_FOR_CLIENT_ID);
    }

    
}
