package Validator;

import InsuranceSoftware.JSONArrayObject;
import InsuranceSoftware.ValidationRunner;
import InsuranceSoftware.JSONFileCreator;
import java.util.ArrayList;
import org.w3c.dom.NodeList;

public class JSONFormValidator {

    static final String LIST_OF_JSON_OBJECTS[] = new String[]{"reclamations", "dossier", "mois", "soin", "date", "montant"};
    private static JSONFileCreator tagToVerify;

    public JSONFormValidator(JSONFileCreator tagToVerify) {
        this.tagToVerify = tagToVerify;
    }

    public boolean verifyIfXmlFormIsValid() {
        if (!isEssentialTagValid("reclamations")
                || !areNodeChildrenValid("reclamations", "dossier")
                || !areNodeChildrenValid("reclamations", "mois")
                || !areNodeChildrenValid("reclamations", "reclamation")) {
            return false;
        }
        return areAllChildrenNodePresent();
    }

    private boolean areAllChildrenNodePresent() {
        ArrayList<JSONArrayObject> ListOfAllReclamations = JSONFileCreator.createListOfIndividualReclamationXmlNodeToTestNodeName("reclamation", tagToVerify);
        for (int i = 0; i < ListOfAllReclamations.size(); i++) {
            try {
                ListOfAllReclamations.get(i).getDate().equals("date");
            } catch (NullPointerException e) {
                ValidationRunner.setErrorMessage("Une balise date est manquante.");
                return false;
            }

            try {
                ListOfAllReclamations.get(i).getSoin().equals("soin");
            } catch (NullPointerException e) {
                ValidationRunner.setErrorMessage("Une balise soin est manquante.");
                return false;
            }

            try {
                ListOfAllReclamations.get(i).getMontant().equals("montant");
            } catch (NullPointerException e) {
                ValidationRunner.setErrorMessage("Une balise montant est manquante.");
                return false;
            }


            if (!ListOfAllReclamations.get(i).getDate().equals("date")
                    || !ListOfAllReclamations.get(i).getSoin().equals("soin")
                    || !ListOfAllReclamations.get(i).getMontant().equals("montant")) {
                return false;

            }
        }
        return true;
    }

    public static boolean isEssentialTagValid(String expectedTagName) {
        try {
            tagToVerify.getJSONArrayByName(expectedTagName);
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Le document JSON est corrompu");
            return false;
        }
        return true;

    }

    public boolean areNodeChildrenValid(String parentName, String expectedTagName) {
        NodeList XmlForm = tagToVerify.getJSONArrayByName(parentName);
        try {
            if (tagToVerify.obtainNodeName(XmlForm.item(0), expectedTagName).equals(expectedTagName)) {
                return true;
            }
        } catch (NullPointerException e) {
            ValidationRunner.setErrorMessage("La balise " + expectedTagName + " n'est pas présente dans le document XML");
            return false;
        }
        return false;
    }
}
