package InsuranceSoftware;

public class JSONArrayObject {

    public static String month;
    public static String fileNumber;
    public static String contractType;
    private String soin;
    private String date;
    private String dollar;
    private String code;
    private int indexFamilyMember;

    public int getIndexFamilyMember() {
        return indexFamilyMember;
    }
    public void setIndexFamilyMember(String code) {
        indexFamilyMember = familyMemberMonthlyMax.familyCodeList.indexOf(code);
    }
    
    public JSONArrayObject(){
    }
    
    public JSONArrayObject(String soin,String dollar, String contracType) {
        this.soin = soin;
        this.dollar = dollar;
        this.contractType = contracType;
    }

    
    
    
   
   

    public JSONArrayObject(int index, JSONFileCreator file) throws Exception {
        insertValidSoinInJSONArrayObject(file, index);
        insertValidDateInJSONArrayObject(file, index);
        insertValidDollarInJSONArrayObject(file, index);
        insertValidCodeInJSONArrayObject(file, index);
    }

    private void insertValidCodeInJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            code = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("code");
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Une balise code est manquante.");
            throw new Exception();
        }
    }

    private void insertValidDollarInJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            dollar = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("montant");
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Une balise montant est manquante.");
            throw new Exception();
        }
    }

    private void insertValidDateInJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            date = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("date");
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Une balise date est manquante.");
            throw new Exception();
        }
    }

    private void insertValidSoinInJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            soin = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("soin");
        } catch (Exception e) {
            ValidationRunner.setErrorMessage("Une balise soin est manquante.");
            throw new Exception();
        }
    }

    public void setIndividualReclamationJSONArrayObjectToTestObjectName(int index, JSONFileCreator file) {
        if (file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).has("soin")) {
            soin = "soin";
        }
        if (file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).has("code")) {
            code = "code";
        }
        if (file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).has("date")) {
            date = "date";
        }
        if (file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).has("montant")) {
            dollar = "montant";
        }
    }

    public String getSoin() {

        return soin;
    }

    public String getDate() {
        return date;
    }

    public String getMontant() {
        return dollar;
    }

    public String getCode() {
        return code;
    }
    
}
