/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;
import java.util.ArrayList;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import pack.contrat.Contract;
import pack.validation.ContractLetter;

/**
 *
 * @author fe291196
 */
public class ElementXml {
    
    public static Element creationElementXmlRoot(Document documentXml, String elementName) throws DOMException {
        Element createdElement = documentXml.createElement(elementName);
        documentXml.appendChild(createdElement);
        return createdElement;
    }
    
    public static Element creationElementXmlChild(Document documentXml, String elementName ,Element parentName) throws DOMException {
        Element createdElement = documentXml.createElement(elementName);
        parentName.appendChild(createdElement);
        return createdElement;
    }
    
    public static String calculateAmountToReinburseInString(ArrayList<ReclamationObject> listeDesReclamationsDuClient, int countNumber) throws NumberFormatException {
        String ammountWithoutDollarSign = listeDesReclamationsDuClient.get(countNumber).getMontant().substring(0, listeDesReclamationsDuClient.get(countNumber).getMontant().length() - 1);
        ammountWithoutDollarSign.replace("," , ".");
        double montantAjuster = Double.parseDouble(ammountWithoutDollarSign);
        int numSoin = Integer.parseInt(listeDesReclamationsDuClient.get(countNumber).getSoin());
        String montant = Contract.reimburseCalculationByContractTypeAmmountInXmlElementRemboursementNumSoin(ContractLetter.getContractLetter(), montantAjuster, numSoin)+"";
        if (montant.charAt(montant.length()-2) == '.'){
            montant = montant + "0$";
        } else {
            montant = montant +"$";
        }
        return montant;
    }
    
}
