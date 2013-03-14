package InsuranceSoftware;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import RefundCalculator.Calculator;

public class XMLFileValidOutput {

    private XMLFileCreator document;
    private NodeList formulaire;
    private Document outputXmlFile;
    private ArrayList<NodeObject> clientReclamationList;
    private Element remboursementsWrittenInOutputXmlFile;
    private String[] argsFromMain;

    public XMLFileValidOutput(String[] argsFromMain) {
        this.argsFromMain = argsFromMain;
    }
    
    public Document getOutputXmlFile() {
        return outputXmlFile;
    }

    private XMLFileCreator loadXmlDocumentFromArg0(String[] argsFromMain) throws Exception {
        document = new XMLFileCreator(argsFromMain[0]);
        return document;
    }

    public void createElementsInXmlOutputFile() throws Exception {
        loadXmlDocumentFromArg0(argsFromMain);
        setRootNodeInXmlDocument("reclamations");
        setReclamationNodeListInXmlDocument("reclamation");
        outputXmlFile = XMLFileCreator.docInstanceBuilder().newDocument();
        remboursementsWrittenInOutputXmlFile = ElementXmlCreator.creationElementXmlRoot(outputXmlFile, "remboursements");
        insertChildElementsOfRoot("dossier");
        insertChildElementsOfRoot("mois");
        insertChildElementsOfRemboursementElement();
        insertChildElementMontantOfRoot("total");
    }

    private void setRootNodeInXmlDocument(String rootName) {
        formulaire = document.getNodesByName(rootName);
    }

    private void setReclamationNodeListInXmlDocument(String nodeName) {
        clientReclamationList = XMLFileCreator.createListOfIndividualReclamationXmlNode(nodeName, document);
    }

    private void insertChildElementsOfRoot(String nodeNameToInsert) {
        Element dossierWrittenInOutputXmlFile = ElementXmlCreator.creationElementXmlChild(outputXmlFile, nodeNameToInsert, remboursementsWrittenInOutputXmlFile);
        Text textDossierWrittenInOutputXmlFile = outputXmlFile.createTextNode(document.obtainNodeContent(formulaire.item(0), nodeNameToInsert));
        dossierWrittenInOutputXmlFile.appendChild(textDossierWrittenInOutputXmlFile);
    }
    
    private void insertChildElementMontantOfRoot(String nodeNameToInsert) {
        Element dossierWrittenInOutputXmlFile = ElementXmlCreator.creationElementXmlChild(outputXmlFile, nodeNameToInsert, remboursementsWrittenInOutputXmlFile);
        Text textDossierWrittenInOutputXmlFile = outputXmlFile.createTextNode(ElementXmlCreator.formatAmmountToStandartFormat( String.valueOf(Calculator.getAmountTotal())+ ""));
        dossierWrittenInOutputXmlFile.appendChild(textDossierWrittenInOutputXmlFile);
    }
    
    private void insertChildElementsOfRemboursementElement(){
        for (int i = 0; i < clientReclamationList.size(); i++) {
                Element remboursementWrittenInOutputXmlFile = ElementXmlCreator.creationElementXmlChild(outputXmlFile, "remboursement", remboursementsWrittenInOutputXmlFile);

                Element soinWrittenInOutputXmlFile = ElementXmlCreator.creationElementXmlChild(outputXmlFile, "soin", remboursementWrittenInOutputXmlFile);
                Text textSoinWrittenInOutputXmlFile = outputXmlFile.createTextNode(clientReclamationList.get(i).getSoin());
                soinWrittenInOutputXmlFile.appendChild(textSoinWrittenInOutputXmlFile);

                Element dateWrittenInOutputXmlFile = ElementXmlCreator.creationElementXmlChild(outputXmlFile, "date", remboursementWrittenInOutputXmlFile);
                Text textDateWrittenInOutputXmlFile = outputXmlFile.createTextNode(clientReclamationList.get(i).getDate());
                dateWrittenInOutputXmlFile.appendChild(textDateWrittenInOutputXmlFile);

                Element montantWrittenInOutputXmlFile = ElementXmlCreator.creationElementXmlChild(outputXmlFile, "montant", remboursementWrittenInOutputXmlFile);
                String montantToReimburse = ElementXmlCreator.calculateAmountToReinburseInString(clientReclamationList, i);
                   
                Text textMontant = outputXmlFile.createTextNode(montantToReimburse);
                montantWrittenInOutputXmlFile.appendChild(textMontant);
            }
    }
}
