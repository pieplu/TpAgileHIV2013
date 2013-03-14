/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import pack.contract.Contract;

/**
 *
 * @author Dominique Ménard
 */
public class DocumentXmlValidOutputFile {

    private DocumentXml document;
    private NodeList formulaire;
    private Document outputXmlFile;
    private ArrayList<IndividualReclamationXmlNode> clientReclamationList;
    private Element remboursementsWrittenInOutputXmlFile;
    private String[] argsFromMain;

    public DocumentXmlValidOutputFile(String[] argsFromMain) {
        this.argsFromMain = argsFromMain;
    }
    
    public Document getOutputXmlFile() {
        return outputXmlFile;
    }

    private DocumentXml loadXmlDocumentFromArg0(String[] argsFromMain) throws Exception {
        document = new DocumentXml(argsFromMain[0]);
        return document;
    }

    public void createElementsInXmlOutputFile() throws Exception {
        loadXmlDocumentFromArg0(argsFromMain);
        setRootNodeInXmlDocument("reclamations");
        setReclamationNodeListInXmlDocument("reclamation");
        outputXmlFile = DocumentXml.docInstanceBuilder().newDocument();
        remboursementsWrittenInOutputXmlFile = ElementXml.creationElementXmlRoot(outputXmlFile, "remboursements");
        insertChildElementsOfRoot("dossier");
        insertChildElementsOfRoot("mois");
        insertChildElementsOfRemboursementElement();
        insertChildElementMontantOfRoot("total");
    }

    private void setRootNodeInXmlDocument(String rootName) {
        formulaire = document.getNodesByName(rootName);
    }

    private void setReclamationNodeListInXmlDocument(String nodeName) {
        clientReclamationList = DocumentXml.createListOfIndividualReclamationXmlNode(nodeName, document);
    }

    private void insertChildElementsOfRoot(String nodeNameToInsert) {
        Element dossierWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, nodeNameToInsert, remboursementsWrittenInOutputXmlFile);
        Text textDossierWrittenInOutputXmlFile = outputXmlFile.createTextNode(document.obtainNodeContent(formulaire.item(0), nodeNameToInsert));
        dossierWrittenInOutputXmlFile.appendChild(textDossierWrittenInOutputXmlFile);
    }
    
    private void insertChildElementMontantOfRoot(String nodeNameToInsert) {
        Element dossierWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, nodeNameToInsert, remboursementsWrittenInOutputXmlFile);
        Text textDossierWrittenInOutputXmlFile = outputXmlFile.createTextNode(ElementXml.formatAmmountToStandartFormat( String.valueOf(Contract.getAmountTotal())+ ""));
        dossierWrittenInOutputXmlFile.appendChild(textDossierWrittenInOutputXmlFile);
    }
    
    private void insertChildElementsOfRemboursementElement(){
        for (int i = 0; i < clientReclamationList.size(); i++) {
                Element remboursementWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "remboursement", remboursementsWrittenInOutputXmlFile);

                Element soinWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "soin", remboursementWrittenInOutputXmlFile);
                Text textSoinWrittenInOutputXmlFile = outputXmlFile.createTextNode(clientReclamationList.get(i).getSoin());
                soinWrittenInOutputXmlFile.appendChild(textSoinWrittenInOutputXmlFile);

                Element dateWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "date", remboursementWrittenInOutputXmlFile);
                Text textDateWrittenInOutputXmlFile = outputXmlFile.createTextNode(clientReclamationList.get(i).getDate());
                dateWrittenInOutputXmlFile.appendChild(textDateWrittenInOutputXmlFile);

                Element montantWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "montant", remboursementWrittenInOutputXmlFile);
                String montantToReimburse = ElementXml.calculateAmountToReinburseInString(clientReclamationList, i);
                   
                Text textMontant = outputXmlFile.createTextNode(montantToReimburse);
                montantWrittenInOutputXmlFile.appendChild(textMontant);
            }
    }
}
