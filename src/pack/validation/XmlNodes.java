/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import pack.DocumentXml;
import pack.ValidationExecution;

/**
 *
 * @author utilisateur
 */
public class XmlNodes {
    
     static final String LIST_OF_XML_TAGS[] = new String[]{"reclamations","dossier","mois","soin","date","montant"};
     static public final String TAG_ROOT = "reclamation";
     
     public static boolean isEssentialTagValid (DocumentXml tagToVerify,String expectedTagName) {
        try{
         tagToVerify.getNodesByName(expectedTagName);
        }catch(NullPointerException e){
            ValidationExecution.setErrorMessage("La balise " + expectedTagName + "n'est pas présente dans le document XML");
            return false;
        }
        return true;
        
    }
     
    public static boolean areNodeChildrenValid(){

    
    return true;
    }
    
}
