/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;
import org.w3c.dom.NodeList;
import pack.validation.XmlNodes;

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

    public static boolean exexValid(DocumentXml fileToValidate) throws Exception {
        boolean testValid = true;
        XmlNodes testIfAllNodesAreThere = new XmlNodes(fileToValidate);
        if(!testIfAllNodesAreThere.verifyIfXmlFormIsValid()){
            return false;
        }

        NodeList XmlForm = fileToValidate.getNodesByName("reclamations");
        String FileNumber = fileToValidate.obtainNodeContent(XmlForm.item(0), "dossier");
        String month = fileToValidate.obtainNodeContent(XmlForm.item(0), "mois");



        ArrayList<IndividualReclamationXmlNode> ListOfAllReclamations = DocumentXml.createListOfIndividualReclamationXmlNode("reclamation", fileToValidate);


        boolean documentIsValid = true;

        if (pack.validation.FileNumber.isFileNumberValid(FileNumber)) {

            for (int i = 0; i < ListOfAllReclamations.size() && documentIsValid; i++) {

                documentIsValid = pack.validation.Date.isDateValid(month, ListOfAllReclamations.get(i).getDate())
                        && pack.validation.ServiceNumber.isServiceNumberValid(ListOfAllReclamations.get(i).getSoin())
                        && pack.validation.Amount.isAmountFormValid(ListOfAllReclamations.get(i).getMontant());
            }
        } else {
            documentIsValid = false;
        }
        return documentIsValid;
    }
}
