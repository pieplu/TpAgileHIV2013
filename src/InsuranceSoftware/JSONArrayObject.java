package InsuranceSoftware;

public class JSONArrayObject {
    
    private String soin;
    private String date;
    private String montant;
    
    
    public JSONArrayObject (int index, JSONFileCreator file) throws Exception{
        try{
        soin = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("soin");
        }catch(Exception e){
            ValidationRunner.setErrorMessage("Une balise soin est manquante.");
            throw new Exception();
        }
        try{
        date = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("date");
        }catch(Exception e){
            ValidationRunner.setErrorMessage("Une balise date est manquante.");
            throw new Exception();
        }
        try{
        montant = file.getjsonFile().getJSONArray("reclamations").getJSONObject(index).getString("montant");
        }catch(Exception e){
            ValidationRunner.setErrorMessage("Une balise montant est manquante.");
            throw new Exception();
        }
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
