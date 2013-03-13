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

    public static void main(String[] args) throws Exception {
        
        DocumentXml document = new DocumentXml(args[0]);
        
        if (!ValidationExecution.exexValid(document)) {
            DocumentXml.createErrorFile(args[1]);
        } else {

            NodeList formulaire = document.getNodesByName("reclamations");
            String contratType = ContractLetter.getContractLetter();
            
            ArrayList<IndividualReclamationXmlNode> listeDesReclamationsDuClient = DocumentXml.createListOfIndividualReclamationXmlNode("reclamation",document);
            
            Document outputXmlFile = DocumentXml.docInstanceBuilder().newDocument();

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
                String montantWrittenInOutputXmlFile = ElementXml.calculateAmountToReinburseInString(listeDesReclamationsDuClient, i);
                   
                Text textMontantWrittenInOutputXmlFile = outputXmlFile.createTextNode(montantWrittenInOutputXmlFile);
                montantWrittenInOutputXmlFile.appendChild(textMontantWrittenInOutputXmlFile);
            }

            DocumentXml.saveXmlDocument(args[1], outputXmlFile);
            System.out.println("Le fichier entree est : " + args[0]);
            System.out.println("Le fichier a ete enregistre : " + args[1]);
        }
    }
}