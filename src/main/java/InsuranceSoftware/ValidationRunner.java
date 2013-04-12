package InsuranceSoftware;

import Validator.JSONFormValidator;
import java.util.ArrayList;

public class ValidationRunner {

    private static String ErrorMessage = "";
    public static ArrayList<JSONArrayObject> listOfAllReclamations;
    private static JSONFileCreator fileToValidate;
    private static String month;
    private static String fileNumber;

    public static void setErrorMessage(String ErrorMessage) {
        ValidationRunner.ErrorMessage = ErrorMessage;
    }

    public static String getErrorMessage() {
        return ErrorMessage;
    }

    public static boolean runValidationProcess(JSONFileCreator file) throws Exception {
        fileToValidate = file;
        JSONFormValidator testIfAllJSONObjectsArePresent = new JSONFormValidator(fileToValidate);
        if (!testIfAllJSONObjectsArePresent.verifyIfJSONFormIsValid()) {
            return false;
        }

        fileNumber = fileToValidate.getjsonFile().getString("dossier");
        month = fileToValidate.getjsonFile().getString("mois");


        return validateFileContent();
    }

    private static boolean validateFileContent() {
        boolean testValidFileFormat = true;
        
        if(!isFileToValidateInValidFormat()){
            testValidFileFormat = false;
        }
        if (!Validator.FileNumber.isFileNumberValid(fileNumber)) {
            testValidFileFormat = false;
        }
        if (!areAllJSONArrayObjectValid()) {
            testValidFileFormat = false;
        }
        
        return testValidFileFormat;
    }

    private static boolean isFileToValidateInValidFormat() {
        try {
            listOfAllReclamations = JSONFileCreator.createListOfIndividualReclamationJSONObject("reclamations", fileToValidate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    
    
    private static boolean areAllJSONArrayObjectValid(){
        boolean testAJSONArrayObject = true;
        if (!areAllDatesValid()){
            ValidationRunner.setErrorMessage("Erreur: Une date n'est pas valide.");
            testAJSONArrayObject = false;
        }
        if (!areAllSoinsValid()){
           ValidationRunner.setErrorMessage("Erreur: Un soin n'est pas valide.");
            testAJSONArrayObject = false;
        }
        if (!areAllMontantsValid()){
            ValidationRunner.setErrorMessage("Erreur: Un montant n'est pas valide.");
            testAJSONArrayObject = false;
        }
        if (!areAllCodesValid()){
            ValidationRunner.setErrorMessage("Erreur: Un code n'est pas valide."); 
            testAJSONArrayObject = false;
        }
        
        return testAJSONArrayObject;
    }
    
    private static boolean areAllDatesValid(){
        for (int i = 0; i < listOfAllReclamations.size(); i++) {
                if (!isADateValid(i)) return false;
        }
        return true;
    }

    private static boolean isADateValid(int compteur) {
        if (Validator.Date.isDateValid(month, listOfAllReclamations.get(compteur).getDate())) {
            return true;
        }
        return false;
    }
    
    private static boolean areAllSoinsValid(){
        for (int i = 0; i < listOfAllReclamations.size(); i++) {
            
                if (!isASoinValid(i)) {
                    return false;
                }
        }
        return true;
    }

    private static boolean isASoinValid(int compteur) {
        if (Validator.ServiceNumber.isServiceNumberValid(listOfAllReclamations.get(compteur).getSoin())) {
            return true;
        }
        return false;
    }
    
    private static boolean areAllMontantsValid(){
        for (int i = 0; i < listOfAllReclamations.size(); i++) {
                if (!isAMontantValid(i)) {
                    return false;
                }
        }
        return true;
    }

    private static boolean isAMontantValid(int compteur) {
        if (Validator.Dollar.isAmountFormValid(listOfAllReclamations.get(compteur).getMontant())) {
            return true;
        }
        return false;
    }
    
    private static boolean areAllCodesValid(){
        for (int i = 0; i < listOfAllReclamations.size(); i++) {
            
                if (!isACodeValid(i)) {
                    return false;
                }
        }
        return true;
    }

    private static boolean isACodeValid(int compteur) {
        if (Validator.Code.isCodeValid(listOfAllReclamations.get(compteur).getCode())) {
            return true;
        }
        return false;
    }
    
}
