/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import java.io.*;
import org.w3c.dom.Text;
import org.w3c.dom.Element;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Killdom
 */
public class DocumentXml {

    //File fichierXML = new File("C:/Users/Mathieu Latour/Desktop/INPUT.xml");
    public static Document document;
    File file = new File("src\\pack\\" + TP1AGILE.lefichier + ".xml"); //Cette variable contient la location du XML

    public DocumentXml() throws Exception, SAXException, IOException { //Ces exceptions sont necessaire pour les fichiers
        this.document = interpretationDuXML(file);
    }
   

    //Cette methode retourne une interpretation d'un fichier XML, il faut absolument mettre le throw
    //Exception, sinon ça compile pas.
    private Document interpretationDuXML(File file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // for creating factory objects
        DocumentBuilder builder = factory.newDocumentBuilder(); //You use the factory object to create a DocumentBuilder 
        // object that encapsulates a DOM parser   
        return builder.parse(file); //nous retourne le fichier en type document
        // Il faut donc que la variable qui la reçoit
        // soit de 
    }

    //Retourne la liste de toutes les nodes qui correspondent au nom passé en paramètre
    public static NodeList getNodesByName(String NodeName) {
        return document.getElementsByTagName(NodeName);
    }

    public String obtainNodeContent(Node parent, String NodeName) {
        String content = null;

        //Liste des balises sous la balise parent.
        NodeList list = parent.getChildNodes();

        // On boucle pour bien prendre tout le contenu des enfants
        for (int i = 0; i < list.getLength(); i++) {

            //Compare le nom de la balise avec le nom de l'élement que l'on recherche
            if (list.item(i).getNodeName().equals(NodeName)) {
                content = list.item(i).getTextContent();
            }
        }


        return content;
    }
}
