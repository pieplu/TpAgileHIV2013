/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import pack.contrat.Contrat;

/**
 *
 * @author Dominique Ménard
 */
public class TP1AGILE {

    

    public static void main(String[] args) throws Exception {
        
        DocumentXml document = new DocumentXml(args[0]);
        
        
        ExecutionValidation fichierAValider = new ExecutionValidation();
        
        if (!fichierAValider.exexValid(document)) {
            DocumentXml.createErrorFile(args[1]);
        } else {

            NodeList formulaire = document.getNodesByName("reclamations");
            String contratType = document.obtainNodeContent(formulaire.item(0), "contrat");

            ArrayList<ReclamationObject> listeDesReclamationsDuClient = new <ReclamationObject> ArrayList();

            NodeList reclamationDuXML = document.getNodesByName("reclamation");
            for (int i = 0; i < reclamationDuXML.getLength(); i++) {
                listeDesReclamationsDuClient.add(new ReclamationObject(reclamationDuXML, i, document));
            }
            Document nouveauDocument = DocumentXml.docInstanceBuilder().newDocument();

            Element remboursementsEcrit = ElementXml.creationElementXmlRoot(nouveauDocument, "remboursements");
            
            Element writtenDossierElement = ElementXml.creationElementXmlChild(nouveauDocument, "dossier", remboursementsEcrit);
            Text textDossier = nouveauDocument.createTextNode(document.obtainNodeContent(formulaire.item(0), "dossier"));
            writtenDossierElement.appendChild(textDossier);

            Element moisEcrit = ElementXml.creationElementXmlChild(nouveauDocument, "mois", remboursementsEcrit);
            Text textMois = nouveauDocument.createTextNode(document.obtainNodeContent(formulaire.item(0), "mois"));
            moisEcrit.appendChild(textMois);

            for (int i = 0; i < listeDesReclamationsDuClient.size(); i++) {
                Element remboursementEcrit = ElementXml.creationElementXmlChild(nouveauDocument, "remboursement", remboursementsEcrit);

                Element soinEcrit = ElementXml.creationElementXmlChild(nouveauDocument, "soin", remboursementEcrit);
                Text textSoin = nouveauDocument.createTextNode(listeDesReclamationsDuClient.get(i).getSoin());
                soinEcrit.appendChild(textSoin);

                Element dateEcrit = ElementXml.creationElementXmlChild(nouveauDocument, "date", remboursementEcrit);
                Text textDate = nouveauDocument.createTextNode(listeDesReclamationsDuClient.get(i).getDate());
                dateEcrit.appendChild(textDate);

                Element montantEcrit = ElementXml.creationElementXmlChild(nouveauDocument, "montant", remboursementEcrit);
                String montant = ElementXml.calculateAmountToReinburseInString(listeDesReclamationsDuClient, i);
                   
                Text textMontant = nouveauDocument.createTextNode(montant);
                montantEcrit.appendChild(textMontant);

            }


            DocumentXml.enregistrerSousDocumentXml(args[1], nouveauDocument);
            System.out.println("Le fichier entree est : " + args[0]);
            System.out.println("Le fichier a ete enregistre : " + args[1]);
            
        }
    }
}