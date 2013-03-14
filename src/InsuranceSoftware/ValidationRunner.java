package InsuranceSoftware;

import java.util.ArrayList;
import org.w3c.dom.NodeList;
import Validator.XmlNodes;

public class ValidationRunner {

    private static String ErrorMessage = "";

    public static void setErrorMessage(String ErrorMessage) {
        ValidationRunner.ErrorMessage = ErrorMessage;
    }

    public static String getErrorMessage() {
        return ErrorMessage;
    }

    public static boolean runValidationProcess(XMLFileCreator fileToValidate) throws Exception {
        XmlNodes testIfAllNodesAreThere = new XmlNodes(fileToValidate);
        if (!testIfAllNodesAreThere.verifyIfXmlFormIsValid()) {
            return false;
        }

        NodeList XmlForm = fileToValidate.getNodesByName("reclamations");
        String FileNumber = fileToValidate.obtainNodeContent(XmlForm.item(0), "dossier");
        String month = fileToValidate.obtainNodeContent(XmlForm.item(0), "mois");


        return validateDocumentContent(FileNumber, fileToValidate, month);
    }

    private static boolean validateDocumentContent(String FileNumber, XMLFileCreator fileToValidate, String month) {
        ArrayList<NodeObject> ListOfAllReclamations = XMLFileCreator.createListOfIndividualReclamationXmlNode("reclamation", fileToValidate);
        if (Validator.FileNumber.isFileNumberValid(FileNumber)) {
            for (int i = 0; i < ListOfAllReclamations.size(); i++) {
                if (!(Validator.Date.isDateValid(month, ListOfAllReclamations.get(i).getDate())
                        && Validator.ServiceNumber.isServiceNumberValid(ListOfAllReclamations.get(i).getSoin())
                        && Validator.Amount.isAmountFormValid(ListOfAllReclamations.get(i).getMontant()))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
