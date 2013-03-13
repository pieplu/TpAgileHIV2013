/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dominique Ménard
 */
public class DocumentXmlValidOutputFile {
    
    private static DocumentXml document;
    private static NodeList formulaire;
    private static Document outputXmlFile;
    private static String[] argsFromMain;
    
    public DocumentXmlValidOutputFile (String[] argsFromMain){
        this.argsFromMain = argsFromMain;
    }
    
    private static DocumentXml loadXmlDocumentFromArg0(String[] argsFromMain) throws Exception {
        DocumentXml document = new DocumentXml(argsFromMain[0]);
        return document;
    }
    

    
}
