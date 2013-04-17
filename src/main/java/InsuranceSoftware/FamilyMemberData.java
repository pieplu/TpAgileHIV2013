package InsuranceSoftware;

public class FamilyMemberData extends FamilyData {

    
    private String soin;
    private String date;
    private String dollar;
    private String code;
    private int indexFamilyMember;
    
    
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

    public int getIndexFamilyMember() {
        return indexFamilyMember;
    }
    public void setIndexFamilyMember(String code) {
        indexFamilyMember = FamilyData.familyCodeList.indexOf(code);
    }
    
    public FamilyMemberData(){
    }
    
    public FamilyMemberData(String soin,String dollar, String contracType) {
        this.soin = soin;
        this.dollar = dollar;
        this.contractType = contracType;
    }

    public FamilyMemberData(int index, JSONFileCreator file) throws Exception {
        soin = JSONArrayObjectDataExtractor.getSoinFromJSONArrayObject(file, index);
        date = JSONArrayObjectDataExtractor.getDateFromJSONArrayObject(file, index);
        dollar = JSONArrayObjectDataExtractor.getDollarFromJSONArrayObject(file, index);
        code = JSONArrayObjectDataExtractor.getCodeFromJSONArrayObject(file, index);
    }


    
    
}
