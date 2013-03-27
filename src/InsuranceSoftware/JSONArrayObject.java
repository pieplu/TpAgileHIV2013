package InsuranceSoftware;

public class JSONArrayObject {
    
    private String soin;
    private String date;
    private String montant;
    
    
    public JSONArrayObject (int index, JSONFileCreator file){
        soin = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("soin");
        date = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("date");
        montant = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("montant");
    }
    
    public void setIndividualReclamationJSONArrayObjectToTestObjectName(int index, JSONFileCreator file){
        if(file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).has("soin")){
        soin = "soin";
        }
        if(file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).has("date")){
        date = "date";
        }
        if(file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).has("montant")){
        montant = "montant";
        }
    }
    
    public String getSoin (){
        
        return soin;
    }
    
    public String getDate (){
        return date;
    }
    
    public String getMontant (){
        return montant;
    }
    
}
