package InsuranceSoftware;

import RefundCalculator.Calculator;
import Validator.Dollar;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONFileContentProcessor {

    private JSONFileCreator file;
    private JSONObject outputJSONFile;
    private ArrayList<FamilyMemberData> allReclamationsList;
    private String[] argsFromMain;

    public JSONFileContentProcessor(String[] argsFromMain) {
        this.argsFromMain = argsFromMain;
    }

    public JSONObject getOutputJSONFile() {
        return outputJSONFile;
    }

    private JSONFileCreator loadJSONObjectFromArg0(String[] argsFromMain) throws Exception {
        file = new JSONFileCreator(argsFromMain[0]);
        return file;
    }

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
            reclamation.accumulate("code", allReclamationsList.get(i).getCode());
            reclamation.accumulate("date", allReclamationsList.get(i).getDate());
            reclamation.accumulate("montant", calculateAmountToRefundConsideringMonthlyMax(allReclamationsList, i));
            reclamationsArray.add(reclamation);
        }

        outputJSONFile.accumulate("reclamations", reclamationsArray);

        outputJSONFile.accumulate("total", Calculator.getSumOfAllReclamations());
    }
    
    public static String calculateAmountToRefundConsideringMonthlyMax(ArrayList<FamilyMemberData> clientReclamationList, int countNumber) throws NumberFormatException { 
        FamilyData.setAndCreateMonthlyMaxDependingOnNumSoin(clientReclamationList.get(countNumber));
        return Dollar.formatAmountToStandardFormat(Calculator.refundCalculator(clientReclamationList.get(countNumber)));
    }
    
    private void setReclamationListInJSONObject(String jsonArrayName) {
        try {
            allReclamationsList = JSONFileCreator.createListOfIndividualReclamationJSONObject(jsonArrayName, file);
        } catch (Exception ex) {
        }
    }

}
