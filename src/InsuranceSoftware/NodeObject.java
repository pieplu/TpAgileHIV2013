package InsuranceSoftware;

import org.w3c.dom.NodeList;

public class NodeObject {
    
    private String soin;
    private String date;
    private String montant;
    
    
    public NodeObject (NodeList list, int index, XMLFileCreator document){
        soin = document.obtainNodeContent(list.item(index),"soin");
        date = document.obtainNodeContent(list.item(index),"date");
        montant = document.obtainNodeContent(list.item(index),"montant");
    }
    
    public void setIndividualReclamationXmlNodeToTestNodeName(NodeList list, int index, XMLFileCreator document){
        soin = document.obtainNodeName(list.item(index),"soin");
        date = document.obtainNodeName(list.item(index),"date");
        montant = document.obtainNodeName(list.item(index),"montant");
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
