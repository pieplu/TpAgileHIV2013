/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import pack.validation.Validation;
import java.util.ArrayList;
import org.w3c.dom.NodeList;

/**
 *
 * @Mathieu Latour
 */
public class ExecutionValidation {
    
    private static String ErrorMessage = "";

    public static void setErrorMessage(String ErrorMessage) {
        ExecutionValidation.ErrorMessage = ErrorMessage;
    }

    public static String getErrorMessage() {
        return ErrorMessage;
    }

    
    public boolean exexValid(DocumentXml fichierAValider) throws Exception {
        boolean testValid = true;
        
        NodeList formulaire = fichierAValider.getNodesByName("reclamations");
        String clientID = fichierAValider.obtainNodeContent(formulaire.item(0), "client");
        String contratType = fichierAValider.obtainNodeContent(formulaire.item(0), "contrat");
        String mois = fichierAValider.obtainNodeContent(formulaire.item(0), "mois");

        ArrayList<ReclamationObject> listeDesReclamationsDuClient = new <ReclamationObject> ArrayList();

        NodeList reclamationDuXML = fichierAValider.getNodesByName("reclamation");
        for (int i = 0; i < reclamationDuXML.getLength(); i++) {
            listeDesReclamationsDuClient.add(new ReclamationObject(reclamationDuXML, i, fichierAValider));
        }


        boolean documentIsValid = true;
        if (pack.validation.ClientID.isClientNumberValid(clientID)
                && pack.validation.ContractLetter.isContractLetterValid(contratType)) {

            for (int i = 0; i < listeDesReclamationsDuClient.size() && documentIsValid; i++) {
                if (!pack.validation.Date.isDateValid(mois, listeDesReclamationsDuClient.get(i).getDate())
                        || !pack.validation.ServiceNumber.isServiceNumberValid(listeDesReclamationsDuClient.get(i).getSoin())
                        || !pack.validation.Amount.isAmountFormValid(listeDesReclamationsDuClient.get(i).getMontant())) {
                    documentIsValid = false;
                }
            }
        } else {
            documentIsValid = false;
        }
        return documentIsValid;

    }
}
