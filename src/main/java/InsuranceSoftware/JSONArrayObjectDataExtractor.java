/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsuranceSoftware;

/**
 *
 * @author ff291104
 */
public class JSONArrayObjectDataExtractor {

    public static String getCodeFromJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            return file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("code");
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Une balise code est manquante.");
            throw new Exception();
        }
    }

    public static String getDollarFromJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            return file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("montant");
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Une balise montant est manquante.");
            throw new Exception();
        }
    }

    public static String getDateFromJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            return file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("date");
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Une balise date est manquante.");
            throw new Exception();
        }
    }

    public static String getSoinFromJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            return file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("soin");
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Une balise soin est manquante.");
            throw new Exception();
        }
    }
}
