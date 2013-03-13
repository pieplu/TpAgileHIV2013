/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import org.w3c.dom.NodeList;

/**
 *
 * @author Killdom
 */
public class IndividualReclamationXmlNode {
    
    private String soin;
    private String date;
    private String montant;
    
    
    public IndividualReclamationXmlNode (NodeList liste, int index, DocumentXml document){
        soin = document.obtainNodeContent(liste.item(index),"soin");
        date = document.obtainNodeContent(liste.item(index),"date");
        montant = document.obtainNodeContent(liste.item(index),"montant");
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
