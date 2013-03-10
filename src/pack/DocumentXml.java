/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Killdom
 */
public class DocumentXml {

    public static void enregistrerSousDocumentXml(String nomFichier, Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(doc);
        Result result = new StreamResult(new File(nomFichier));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
    }

    public static DocumentBuilder docInstanceBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        return docBuilder;
    }

    private Document document;
   
    
    public DocumentXml(String cheminAcces) throws Exception, SAXException, IOException{
        File file = new File(cheminAcces);
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
    
    public static void createErrorFile(String argument1) throws Exception, ParserConfigurationException, DOMException {
        Document nouveauError = DocumentXml.docInstanceBuilder().newDocument();

        Element remboursementsEcritError = nouveauError.createElement("remboursements");
        nouveauError.appendChild(remboursementsEcritError);

        Element messageError = nouveauError.createElement("message");
        remboursementsEcritError.appendChild(messageError);
        Text textMessageError = nouveauError.createTextNode("Données invalides");
        messageError.appendChild(textMessageError);
        
        DocumentXml.enregistrerSousDocumentXml(argument1, nouveauError);
    }
}
