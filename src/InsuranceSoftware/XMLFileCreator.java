package InsuranceSoftware;

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



public class XMLFileCreator {
    
    private Document document;
    
    public XMLFileCreator(String accessPath) throws Exception, SAXException, IOException{
        File file = new File(accessPath);
        try{
            this.document = xmlInterpretation(file); 
        }catch (Exception e){
            ValidationRunner.setErrorMessage("Le fichier xml est corrompu.");
        }
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
    
    public String obtainNodeName(Node parent, String NodeName) {
        String content = null;
        NodeList list = parent.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeName().equals(NodeName)) {
                content = list.item(i).getNodeName();
            }
        }
        return content;
    }
    
    /*
     * Create the result XML file(with indent). 
     */
    public static void saveXmlDocument(String xmlFileName, Document xmlDocumentToSave) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(xmlDocumentToSave);
        Result result = new StreamResult(new File(xmlFileName));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);
    }
    
    public static void createErrorFile(String argument1) throws Exception, ParserConfigurationException, DOMException {
        Document newError = XMLFileCreator.docInstanceBuilder().newDocument();
        
        Element remboursementsWrittenError = ElementXmlCreator.createElementXmlRoot(newError, "remboursements");

        Element messageError = ElementXmlCreator.createElementXmlChild(newError, "message", remboursementsWrittenError);
        Text textMessageError = newError.createTextNode(ValidationRunner.getErrorMessage());
        messageError.appendChild(textMessageError);
        
        XMLFileCreator.saveXmlDocument(argument1, newError);
    }
    
    public static ArrayList<NodeObject> createListOfIndividualReclamationXmlNode(String nodeName, XMLFileCreator document){
        ArrayList<NodeObject> individualReclamationXmlNodeList = new ArrayList <NodeObject> ();

        NodeList reclamationDuXML = document.getNodesByName(nodeName);
        for (int i = 0; i < reclamationDuXML.getLength(); i++) {
            individualReclamationXmlNodeList.add(new NodeObject(reclamationDuXML, i, document));
        }
        
        return individualReclamationXmlNodeList;
    }
    
    public static ArrayList<NodeObject> createListOfIndividualReclamationXmlNodeToTestNodeName(String nodeName, XMLFileCreator document){
        ArrayList<NodeObject> individualReclamationXmlNodeList = new ArrayList <NodeObject> ();
      
        NodeList reclamationDuXML = document.getNodesByName(nodeName);
        for (int i = 0; i < reclamationDuXML.getLength(); i++) {
            individualReclamationXmlNodeList.add(new NodeObject(reclamationDuXML, i, document));
            individualReclamationXmlNodeList.get(i).setIndividualReclamationXmlNodeToTestNodeName(reclamationDuXML, i, document);
        }
        
        return individualReclamationXmlNodeList;
    }
}
