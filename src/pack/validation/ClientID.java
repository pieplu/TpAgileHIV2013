/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

/**
 *
 * @author utilisateur
 */
public class ClientID {

    final static int VALID_LENGTH_FOR_CLIENT_ID = 6;

    public static boolean isClientNumberValid(String clientID) {
        return ((isClientNumberLengthValid(clientID)) && (Validation.isTheStringMadeOfDigitOnly(clientID)));
    }

    public static boolean isClientNumberLengthValid(String clientID) {
        return (clientID.length() == VALID_LENGTH_FOR_CLIENT_ID);
    }

    
}
