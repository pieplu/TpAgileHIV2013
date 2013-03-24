package InsuranceSoftware;

import java.util.ArrayList;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import RefundCalculator.Calculator;
import Validator.ContractLetter;
import Validator.Dollar;

public class ElementXmlCreator {

    public static Element createElementXmlRoot(Document documentXml, String elementName) throws DOMException {
        Element createdElement = documentXml.createElement(elementName);
        documentXml.appendChild(createdElement);
        return createdElement;
    }

    public static Element createElementXmlChild(Document documentXml, String elementName, Element parentName) throws DOMException {
        Element createdElement = documentXml.createElement(elementName);
        parentName.appendChild(createdElement);
        return createdElement;
    }

    public static String calculateAmountToRefundInString(ArrayList<NodeObject> clientReclamationList, int countNumber) throws NumberFormatException {
        String amountWithoutDollarSign = clientReclamationList.get(countNumber).getMontant().substring(0, clientReclamationList.get(countNumber).getMontant().length() - 1);

        amountWithoutDollarSign = Dollar.removeDotAndCommaFromString(amountWithoutDollarSign);
        int amountAsIntegers = Dollar.returnDollarValueInCents(amountWithoutDollarSign);
        System.out.println(amountAsIntegers);
        int numSoin = Integer.parseInt(clientReclamationList.get(countNumber).getSoin());
        int montant = Calculator.refundCalculator(ContractLetter.getContractLetter(), amountAsIntegers, numSoin);
        
        return Dollar.formatAmmountToStandartFormat(montant);
    }

}
