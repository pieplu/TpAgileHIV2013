package InsuranceSoftware;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import RefundCalculator.Calculator;
import Validator.Dollar;
import org.w3c.dom.*;

public class XMLFileValidOutput {

    private XMLFileCreator document;
    private NodeList listOfRootElements;
    private Document outputXmlFile;
    private ArrayList<NodeObject> allReclamationsList;
    private Element refundsWrittenInOutputXmlFile;
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

    /**
     * Create tags for a valid output file
     */
    public void createElementsInXmlOutputFile() throws Exception {
        loadXmlDocumentFromArg0(argsFromMain);
        setRootNodeInXmlDocument("reclamations");
        setReclamationNodeListInXmlDocument("reclamation");
        outputXmlFile = XMLFileCreator.docInstanceBuilder().newDocument();
        refundsWrittenInOutputXmlFile = ElementXmlCreator.createElementXmlRoot(outputXmlFile, "remboursements");
        insertChildElementsOfRoot("dossier");
        insertChildElementsOfRoot("mois");
        assignChildrenNodeContent();
        insertChildElementMontantOfRoot("total");
    }

    private void setRootNodeInXmlDocument(String rootName) {
        listOfRootElements = document.getNodesByName(rootName);
    }

    /*
     * Affects the list of the reclamations made by the client
     */
    private void setReclamationNodeListInXmlDocument(String nodeName) {
        allReclamationsList = XMLFileCreator.createListOfIndividualReclamationXmlNode(nodeName, document);
    }

    private void insertChildElementsOfRoot(String nodeNameToInsert) {
        Element dossierWrittenInOutputXmlFile = ElementXmlCreator.createElementXmlChild(outputXmlFile, nodeNameToInsert, refundsWrittenInOutputXmlFile);
        Text textDossierWrittenInOutputXmlFile = outputXmlFile.createTextNode(document.obtainNodeContent(listOfRootElements.item(0), nodeNameToInsert));
        dossierWrittenInOutputXmlFile.appendChild(textDossierWrittenInOutputXmlFile);
    }

    private void insertChildElementMontantOfRoot(String nodeNameToInsert) {
        Element dossierWrittenInOutputXmlFile = ElementXmlCreator.createElementXmlChild(outputXmlFile, nodeNameToInsert, refundsWrittenInOutputXmlFile);
        Text textDossierWrittenInOutputXmlFile = outputXmlFile.createTextNode(ElementXmlCreator.formatAmmountToStandartFormat(Calculator.getSumOfAllReclamations()));
        dossierWrittenInOutputXmlFile.appendChild(textDossierWrittenInOutputXmlFile);
    }

    private void assignChildrenNodeContent() {
        for (int i = 0; i < allReclamationsList.size(); i++) {
            Element refundWrittenInOutputXmlFile = ElementXmlCreator.createElementXmlChild(outputXmlFile, "remboursement", refundsWrittenInOutputXmlFile);
            contentForSoin(refundWrittenInOutputXmlFile, i);
            contentForDate(refundWrittenInOutputXmlFile, i);
            contentForAmount(refundWrittenInOutputXmlFile, i);
        }
    }

    private void contentForSoin(Element refundWrittenInOutputXmlFile, int i) throws DOMException {
        Element soinWrittenInOutputXmlFile = ElementXmlCreator.createElementXmlChild(outputXmlFile, "soin", refundWrittenInOutputXmlFile);
        Text textSoinWrittenInOutputXmlFile = outputXmlFile.createTextNode(allReclamationsList.get(i).getSoin());
        soinWrittenInOutputXmlFile.appendChild(textSoinWrittenInOutputXmlFile);
    }

    private void contentForDate(Element refundWrittenInOutputXmlFile, int i) throws DOMException {
        Element dateWrittenInOutputXmlFile = ElementXmlCreator.createElementXmlChild(outputXmlFile, "date", refundWrittenInOutputXmlFile);
        Text textDateWrittenInOutputXmlFile = outputXmlFile.createTextNode(allReclamationsList.get(i).getDate());
        dateWrittenInOutputXmlFile.appendChild(textDateWrittenInOutputXmlFile);
    }

    private void contentForAmount(Element refundWrittenInOutputXmlFile, int i) throws NumberFormatException, DOMException {
        Element montantWrittenInOutputXmlFile = ElementXmlCreator.createElementXmlChild(outputXmlFile, "montant", refundWrittenInOutputXmlFile);
        String montantToRefund = ElementXmlCreator.calculateAmountToRefundInString(allReclamationsList, i);

        Text textMontant = outputXmlFile.createTextNode(montantToRefund);
        montantWrittenInOutputXmlFile.appendChild(textMontant);
    }
}
