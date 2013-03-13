/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    
    private Document document;
    
    public DocumentXml(String accessPath) throws Exception, SAXException, IOException{
        File file = new File(accessPath);
        this.document = xmlInterpretation(file); 
    }

    public static void saveXmlDocument(String xmlFileName, Document xmlDocumentToSave) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(xmlDocumentToSave);
        Result result = new StreamResult(new File(xmlFileName));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
    }

    public static DocumentBuilder docInstanceBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        return docBuilder;
    }
    
    private Document xmlInterpretation(File file) throws Exception {
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
        Document newError = DocumentXml.docInstanceBuilder().newDocument();
        
        Element remboursementsWrittenError = ElementXml.creationElementXmlRoot(newError, "remboursements");

        Element messageError = ElementXml.creationElementXmlChild(newError, "message", remboursementsWrittenError);
        Text textMessageError = newError.createTextNode(ValidationExecution.getErrorMessage());
        messageError.appendChild(textMessageError);
        
        DocumentXml.saveXmlDocument(argument1, newError);
    }
    
    public static ArrayList<IndividualReclamationXmlNode> createListOfIndividualReclamationXmlNode(String nodeName, DocumentXml document){
        ArrayList<IndividualReclamationXmlNode> individualReclamationXmlNodeList = new ArrayList <IndividualReclamationXmlNode> ();

        NodeList reclamationDuXML = document.getNodesByName(nodeName);
        for (int i = 0; i < reclamationDuXML.getLength(); i++) {
            individualReclamationXmlNodeList.add(new IndividualReclamationXmlNode(reclamationDuXML, i, document));
        }
        
        return individualReclamationXmlNodeList;
    }
}
