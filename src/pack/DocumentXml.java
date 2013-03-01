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
    private Document document;
    File file = new File("src\\pack\\" + TP1AGILE.lefichier + ".xml");

    public DocumentXml() throws Exception, SAXException, IOException {
        this.document = interpretationDuXML(file);
    }
    
    private Document interpretationDuXML(File file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder(); 
        return builder.parse(file);
    }

    public NodeList getNodesByName(String NodeName) {
        return document.getElementsByTagName(NodeName);
    }

    public String obtainNodeContent(Node parent, String NodeName) {
        String content = null;
        NodeList list = parent.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeName().equals(NodeName)) {
                content = list.item(i).getTextContent();
            }
        }
        return content;
    }
}
