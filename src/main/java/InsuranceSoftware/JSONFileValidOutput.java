package InsuranceSoftware;

import java.util.ArrayList;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import RefundCalculator.Calculator;
import Validator.ContractLetter;
import Validator.Dollar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONFileValidOutput {

    private JSONFileCreator file;
    private JSONObject outputJSONFile;
    private ArrayList<JSONArrayObject> allReclamationsList;
    private String[] argsFromMain;

    public JSONFileValidOutput(String[] argsFromMain) {
        this.argsFromMain = argsFromMain;
    }

    public JSONObject getOutputJSONFile() {
        return outputJSONFile;
    }

    private JSONFileCreator loadJSONObjectFromArg0(String[] argsFromMain) throws Exception {
        file = new JSONFileCreator(argsFromMain[0]);
        return file;
    }

    /**
     * Create tags for a valid output file
     */
    public void createJSONObjectInOutputFile() throws Exception {
        loadJSONObjectFromArg0(argsFromMain);
        setReclamationListInJSONObject("reclamations");
        outputJSONFile = new JSONObject();
        outputJSONFile.accumulate("dossier", file.getjsonFile().getString("dossier"));
        outputJSONFile.accumulate("mois", file.getjsonFile().getString("mois"));

        JSONArray reclamationsArray = new JSONArray();

        for (int i = 0; i < allReclamationsList.size();i++) {
            JSONObject reclamation = new JSONObject();
            reclamation.accumulate("soin", allReclamationsList.get(i).getSoin());
            reclamation.accumulate("date", allReclamationsList.get(i).getDate());    
            reclamation.accumulate("montant", calculateAmountToRefundInString(allReclamationsList, i));
            reclamationsArray.add(reclamation);
        }

        outputJSONFile.accumulate("reclamations", reclamationsArray);

        outputJSONFile.accumulate("total", Calculator.getSumOfAllReclamations());
    }
    
    public static String calculateAmountToRefundInString(ArrayList<JSONArrayObject> clientReclamationList, int countNumber) throws NumberFormatException { 
        return Dollar.formatAmountToStandardFormat(Calculator.refundCalculator(clientReclamationList.get(countNumber)));
    }


    /*
     * Affects the list of the reclamations made by the client
     */
    private void setReclamationListInJSONObject(String jsonArrayName) {
        try {
            allReclamationsList = JSONFileCreator.createListOfIndividualReclamationJSONObject(jsonArrayName, file);
        } catch (Exception ex) {
        }
    }

}
