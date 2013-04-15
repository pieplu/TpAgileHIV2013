package InsuranceSoftware;

public class JSONArrayObject {

    
    public static String month;
    public static String fileNumber;
    public static String contractType;
    private String soin;
    private String date;
    private String montant;
    private String code;
    private familyMemberMonthlyMax monthlyMaxReference;

    public familyMemberMonthlyMax getMonthlyMaxReference() {
        return monthlyMaxReference;
    }

    public void setMonthlyMaxReference(familyMemberMonthlyMax monthlyMaxReference) {
        this.monthlyMaxReference = monthlyMaxReference;
    }
    
    
    //Refund made for this month:        0     0      0     0      0
    //Maximum for month attained:      false false  false false  false
    public int[] refundDollarForThisMonth = new int[]{0, 0, 0, 0, 0};

   
    public void setRefundDollarForThisMonth(int index, int amount) {
        refundDollarForThisMonth[index] = amount;
    }
    public boolean[] isMonthlyMaxAttained = new boolean[]{false, false, false, false, false};
    
    public void setIsMonthlyMaxAttained(int index, boolean isAttained) {
        isMonthlyMaxAttained[index] = isAttained;
    }

    public JSONArrayObject(int index, JSONFileCreator file) throws Exception {
        insertValidSoinInJSONArrayObject(file, index);
        insertValidDateInJSONArrayObject(file, index);
        insertValidMontantInJSONArrayObject(file, index);
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

    private void insertValidMontantInJSONArrayObject(JSONFileCreator file, int index) throws Exception {
        try {
            montant = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("montant");
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
            montant = "montant";
        }
    }

    public String getSoin() {

        return soin;
    }

    public String getDate() {
        return date;
    }

    public String getMontant() {
        return montant;
    }

    public String getCode() {
        return code;
    }
}
