/*
 * @author Dominique Ménard
 * equipe11
 */
package pack;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import pack.validation.ContractLetter;

public class TP1AGILE {
    
    private static DocumentXml document;
    private static NodeList formulaire;
    private static Document outputXmlFile;
    
    public static DocumentXml loadXmlDocumentFromArg0(String[] args) throws Exception {
        DocumentXml document = new DocumentXml(args[0]);
        return document;
    }
    
    public static void consoleMessageOutput(String[] args) {
        System.out.println("Le fichier entree est : " + args[0]);
        System.out.println("Le fichier a ete enregistre : " + args[1]);
    }

    public static void main(String[] args) throws Exception {
        document = loadXmlDocumentFromArg0(args);
        
        if (!ValidationExecution.exexValid(document)) {
            DocumentXml.createErrorFile(args[1]);
        } else {
            formulaire = document.getNodesByName("reclamations");
            outputXmlFile = DocumentXml.docInstanceBuilder().newDocument();
            
            ArrayList<IndividualReclamationXmlNode> listeDesReclamationsDuClient = DocumentXml.createListOfIndividualReclamationXmlNode("reclamation",document);
            

            Element remboursementsEcrit = ElementXml.creationElementXmlRoot(outputXmlFile, "remboursements");
            
            Element dossierWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "dossier", remboursementsEcrit);
            Text textDossierWrittenInOutputXmlFile = outputXmlFile.createTextNode(document.obtainNodeContent(formulaire.item(0), "dossier"));
            dossierWrittenInOutputXmlFile.appendChild(textDossierWrittenInOutputXmlFile);

            Element moisWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "mois", remboursementsEcrit);
            Text textMoisWrittenInOutputXmlFile = outputXmlFile.createTextNode(document.obtainNodeContent(formulaire.item(0), "mois"));
            moisWrittenInOutputXmlFile.appendChild(textMoisWrittenInOutputXmlFile);

            for (int i = 0; i < listeDesReclamationsDuClient.size(); i++) {
                Element remboursementWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "remboursement", remboursementsEcrit);

                Element soinWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "soin", remboursementWrittenInOutputXmlFile);
                Text textSoinWrittenInOutputXmlFile = outputXmlFile.createTextNode(listeDesReclamationsDuClient.get(i).getSoin());
                soinWrittenInOutputXmlFile.appendChild(textSoinWrittenInOutputXmlFile);

                Element dateWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "date", remboursementWrittenInOutputXmlFile);
                Text textDateWrittenInOutputXmlFile = outputXmlFile.createTextNode(listeDesReclamationsDuClient.get(i).getDate());
                dateWrittenInOutputXmlFile.appendChild(textDateWrittenInOutputXmlFile);

                Element montantWrittenInOutputXmlFile = ElementXml.creationElementXmlChild(outputXmlFile, "montant", remboursementWrittenInOutputXmlFile);
                String montantToReimburse = ElementXml.calculateAmountToReinburseInString(listeDesReclamationsDuClient, i);
                   
                Text textMontant = outputXmlFile.createTextNode(montantToReimburse);
                montantWrittenInOutputXmlFile.appendChild(textMontant);
            }

            DocumentXml.saveXmlDocument(args[1], outputXmlFile);
            consoleMessageOutput(args);
        }
    }
}