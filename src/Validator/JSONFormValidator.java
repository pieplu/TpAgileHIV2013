package Validator;

import InsuranceSoftware.JSONArrayObject;
import InsuranceSoftware.ValidationRunner;
import InsuranceSoftware.JSONFileCreator;
import java.util.ArrayList;
import net.sf.json.JSONException;

public class JSONFormValidator {

    static final String LIST_OF_JSON_OBJECTS[] = new String[]{"reclamations", "dossier", "mois", "soin", "date", "montant"};
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
            if(tagToVerify.getjsonFile().has(expectedTagName)){
                isValid = true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("La balise " + expectedTagName + " n'est pas présente dans le document JSON");
            isValid = false;
        }
        return isValid;
    }
    
    public boolean isJSONFileValid(String expectedTagName){
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
