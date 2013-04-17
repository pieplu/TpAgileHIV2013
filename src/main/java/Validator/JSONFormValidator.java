package Validator;

import InsuranceSoftware.FamilyMemberData;
import InsuranceSoftware.ValidationRunner;
import InsuranceSoftware.JSONFileCreator;
import java.util.ArrayList;
import net.sf.json.JSONException;

public class JSONFormValidator {

    private static JSONFileCreator tagToVerify;

    public JSONFormValidator(JSONFileCreator tagToVerify) {
        this.tagToVerify = tagToVerify;
    }

    public boolean verifyIfJSONFormIsValid() {
        if (!isJSONFileValid("dossier")
                || !areJSONObjectValid("dossier")
                || !areJSONObjectValid("mois")
                || !areJSONObjectValid("reclamations")) {
            return false;
        }
        return true;
    }

    public boolean areJSONObjectValid(String expectedTagName) {
        boolean isValid;
        try {
            if (tagToVerify.getjsonFile().has(expectedTagName)) {
                isValid = true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("La balise " + expectedTagName + " n'est pas présente dans le document JSON");
            isValid = false;
        }
        return isValid;
    }

    public boolean isJSONFileValid(String expectedTagName) {
        boolean isValid;
        try {
            isValid = tagToVerify.getjsonFile().has(expectedTagName);
        } catch (NullPointerException e) {
            ValidationRunner.setErrorMessage("Le fichier JSON est invalide");
            isValid = false;
        }
        return isValid;
    }
}
