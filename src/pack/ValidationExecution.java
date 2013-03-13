/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import pack.validation.Validation;
import java.util.ArrayList;
import org.w3c.dom.NodeList;
import pack.validation.IsAXmlNodeMissing;

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
        NodeList XmlForm;
        String FileNumber;
        String month;

        if (IsAXmlNodeMissing.isTagValid(fileToValidate, "reclamations")) {
            XmlForm = fileToValidate.getNodesByName("reclamations");
        } else {
            return false;
        }

        if (IsAXmlNodeMissing.isTagValid(fileToValidate, "dossier")) {
            FileNumber = fileToValidate.obtainNodeContent(XmlForm.item(0), "dossier");
        } else {
            return false;
        }

        if (IsAXmlNodeMissing.isTagValid(fileToValidate, "mois")) {
            month = fileToValidate.obtainNodeContent(XmlForm.item(0), "mois");
        } else {
            return false;
        }


        ArrayList<IndividualReclamationXmlNode> ListOfAllReclamations = DocumentXml.createListOfIndividualReclamationXmlNode("reclamation", fileToValidate);

        ArrayList<IndividualReclamationXmlNode> listeDesReclamationsDuClient = DocumentXml.createListOfIndividualReclamationXmlNode("reclamation",fileToValidate);


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
