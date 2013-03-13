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
public class ValidationExecution {

    private static String ErrorMessage = "";

    public static void setErrorMessage(String ErrorMessage) {
        ValidationExecution.ErrorMessage = ErrorMessage;
    }

    public static String getErrorMessage() {
        return ErrorMessage;
    }
    
    public static boolean exexValid(DocumentXml fichierAValider) throws Exception {
        boolean testValid = true;
        
        NodeList formulaire = fichierAValider.getNodesByName("reclamations");
        String clientID = fichierAValider.obtainNodeContent(formulaire.item(0), "dossier");
        String mois = fichierAValider.obtainNodeContent(formulaire.item(0), "mois");

        ArrayList<IndividualReclamationXmlNode> listeDesReclamationsDuClient = DocumentXml.createListOfIndividualReclamationXmlNode("reclamation",fichierAValider);

        boolean documentIsValid = true;
        
        if (pack.validation.FileNumber.isFileNumberValid(clientID)) {
            
            for (int i = 0; i < listeDesReclamationsDuClient.size() && documentIsValid; i++) {
                
                documentIsValid = pack.validation.Date.isDateValid(mois, listeDesReclamationsDuClient.get(i).getDate()) &&
                                  pack.validation.ServiceNumber.isServiceNumberValid(listeDesReclamationsDuClient.get(i).getSoin()) && 
                                  pack.validation.Amount.isAmountFormValid(listeDesReclamationsDuClient.get(i).getMontant());
            }
        } else {
            documentIsValid = false;
        }
        return documentIsValid;
    }
}
