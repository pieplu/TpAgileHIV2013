package InsuranceSoftware;

import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class JSONFileCreator {

    private JSONObject jsonFile;

    public JSONObject getjsonFile() {
        return jsonFile;
    }
    
    public JSONFileCreator(JSONObject fileForTest) throws Exception {
        jsonFile = fileForTest;
    }

    public JSONFileCreator(String accessPath) throws Exception {
        String json = FileReader.loadFileIntoString(accessPath);
        try {
            jsonFile = JSONObject.fromObject(json);
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Le fichier JSON est corrompu.");
        }
    }

    public JSONArray getJSONArrayByName(String jsonArrayName) {
        return jsonFile.getJSONArray(jsonArrayName);
    }

    public String obtainJSONStringContent(String contentName) {
        return jsonFile.getString(contentName);
    }

    /*
     * Create the result XML file(with indent). 
     */
    public static void saveJSONFile(String xmlFileName, JSONObject jsonFileToSave) throws Exception {

        try {
            FileWriter file = new FileWriter(xmlFileName);
            file.write(jsonFileToSave.toString(4));
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createErrorFile(String argument1) throws Exception {
        JSONObject newError = new JSONObject();

        newError.accumulate("message", ValidationRunner.getErrorMessage());

        JSONFileCreator.saveJSONFile(argument1, newError);
    }

    public static ArrayList<JSONArrayObject> createListOfIndividualReclamationJSONObject(String jsonArrayName, JSONFileCreator file) throws Exception {
        try {
            ArrayList<JSONArrayObject> individualReclamationJSONObjectList = new ArrayList<JSONArrayObject>();

            for (int i = 0; i < file.getJSONArrayByName(jsonArrayName).size(); i++) {
                individualReclamationJSONObjectList.add(new JSONArrayObject(i, file));
            }
            
            return individualReclamationJSONObjectList;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
