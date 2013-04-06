package InsuranceSoftware;

import Validator.JSONFormValidator;
import java.util.ArrayList;

public class ValidationRunner {

    private static String ErrorMessage = "";

    public static void setErrorMessage(String ErrorMessage) {
        ValidationRunner.ErrorMessage = ErrorMessage;
    }

    public static String getErrorMessage() {
        return ErrorMessage;
    }

    public static boolean runValidationProcess(JSONFileCreator fileToValidate) throws Exception {
        JSONFormValidator testIfAllJSONObjectsArePresent = new JSONFormValidator(fileToValidate);
        if (!testIfAllJSONObjectsArePresent.verifyIfJSONFormIsValid()) {
            return false;
        }

        String fileNumber = fileToValidate.getjsonFile().getString("dossier");
        String month = fileToValidate.getjsonFile().getString("mois");


        return validateFileContent(fileNumber, fileToValidate, month);
    }

    private static boolean validateFileContent(String FileNumber, JSONFileCreator fileToValidate, String month) {
        ArrayList<JSONArrayObject> ListOfAllReclamations = null;
        try{
         ListOfAllReclamations = JSONFileCreator.createListOfIndividualReclamationJSONObject("reclamations", fileToValidate);
        } catch (Exception e){
            return false;
        }
        if (Validator.FileNumber.isFileNumberValid(FileNumber)) {
            
            for (int i = 0; i < ListOfAllReclamations.size(); i++) {
                if (!(Validator.Date.isDateValid(month, ListOfAllReclamations.get(i).getDate())
                        && Validator.ServiceNumber.isServiceNumberValid(ListOfAllReclamations.get(i).getSoin())
                        && Validator.Dollar.isAmountFormValid(ListOfAllReclamations.get(i).getMontant())
                        && Validator.Code.isCodeValid(ListOfAllReclamations.get(i).getCode()))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
