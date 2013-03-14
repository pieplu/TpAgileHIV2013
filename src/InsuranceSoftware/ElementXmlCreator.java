package InsuranceSoftware;
import java.util.ArrayList;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import RefundCalculator.Calculator;
import Validator.ContractLetter;

public class ElementXmlCreator {
    
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
    
    public static String calculateAmountToReinburseInString(ArrayList<NodeObject> clientReclamationList, int countNumber) throws NumberFormatException {
        String ammountWithoutDollarSign = clientReclamationList.get(countNumber).getMontant().substring(0, clientReclamationList.get(countNumber).getMontant().length() - 1);
        ammountWithoutDollarSign = ammountWithoutDollarSign.replace("," , ".");
        double montantAjuster = Double.parseDouble(ammountWithoutDollarSign);
        int numSoin = Integer.parseInt(clientReclamationList.get(countNumber).getSoin());
        String montant = Calculator.refundCalculator(ContractLetter.getContractLetter(), montantAjuster, numSoin)+"";
        montant = formatAmmountToStandartFormat(montant);
        return montant;
    }
    
    public static String formatAmmountToStandartFormat(String ammountToFormat){
        if (ammountToFormat.charAt(ammountToFormat.length()-2) == '.'){
            ammountToFormat = ammountToFormat + "0$";
        } else {
          ammountToFormat = ammountToFormat +"$";
        }
        return ammountToFormat;
    }
    
}
