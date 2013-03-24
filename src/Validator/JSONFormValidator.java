package Validator;

import InsuranceSoftware.JSONArrayObject;
import InsuranceSoftware.ValidationRunner;
import InsuranceSoftware.JSONFileCreator;
import java.util.ArrayList;

public class JSONFormValidator {

    static final String LIST_OF_JSON_OBJECTS[] = new String[]{"reclamations", "dossier", "mois", "soin", "date", "montant"};
    private static JSONFileCreator tagToVerify;

    public JSONFormValidator(JSONFileCreator tagToVerify) {
        this.tagToVerify = tagToVerify;
    }

    public boolean verifyIfJSONFormIsValid() {
        if (!areJSONObjectValid("dossier")
                || !areJSONObjectValid("mois")
                || !areJSONObjectValid("reclamations")) {
            return false;
        }
        return areAllJSONArrayObjectPresent();
    }

    private boolean areAllJSONArrayObjectPresent() {
        ArrayList<JSONArrayObject> ListOfAllReclamations = JSONFileCreator.createListOfIndividualReclamationJSONObject("reclamations", tagToVerify);


        for (int i = 0; i < ListOfAllReclamations.size(); i++) {
            try {
                tagToVerify.getjsonFile().getJSONArray("reclamations").getJSONObject(i).has("date");
            } catch (Exception e) {
                ValidationRunner.setErrorMessage("Une balise date est manquante.");
                return false;
            }

            try {
                tagToVerify.getjsonFile().getJSONArray("reclamations").getJSONObject(i).has("soin");
            } catch (Exception e) {
                ValidationRunner.setErrorMessage("Une balise soin est manquante.");
                return false;
            }

            try {
                tagToVerify.getjsonFile().getJSONArray("reclamations").getJSONObject(i).has("montant");
            } catch (Exception e) {
                ValidationRunner.setErrorMessage("Une balise montant est manquante.");
                return false;
            }

        }
        return true;
    }

    public boolean areJSONObjectValid(String expectedTagName) {
        boolean isValid;
        try {
            isValid = tagToVerify.getjsonFile().has(expectedTagName);
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("La balise " + expectedTagName + " n'est pas présente dans le document JSON");
            isValid = false;
        }
        return isValid;
    }
}
