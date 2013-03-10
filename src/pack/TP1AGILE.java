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
            Element clientEcrit = ElementXml.creationElementXmlChild(nouveauDocument, "client", remboursementsEcrit);
            Text textClient = nouveauDocument.createTextNode(document.obtainNodeContent(formulaire.item(0), "client"));
            clientEcrit.appendChild(textClient);

            Element moisEcrit = nouveauDocument.createElement("mois");
            remboursementsEcrit.appendChild(moisEcrit);
            Text textMois = nouveauDocument.createTextNode(document.obtainNodeContent(formulaire.item(0), "mois"));
            moisEcrit.appendChild(textMois);

            for (int i = 0; i < listeDesReclamationsDuClient.size(); i++) {
                Element remboursementEcrit = nouveauDocument.createElement("remboursement");
                remboursementsEcrit.appendChild(remboursementEcrit);

                Element soinEcrit = nouveauDocument.createElement("soin");
                remboursementEcrit.appendChild(soinEcrit);
                Text textSoin = nouveauDocument.createTextNode(listeDesReclamationsDuClient.get(i).getSoin());
                soinEcrit.appendChild(textSoin);

                Element dateEcrit = nouveauDocument.createElement("date");
                remboursementEcrit.appendChild(dateEcrit);
                Text textDate = nouveauDocument.createTextNode(listeDesReclamationsDuClient.get(i).getDate());
                dateEcrit.appendChild(textDate);

                Element montantEcrit = nouveauDocument.createElement("montant");
                remboursementEcrit.appendChild(montantEcrit);
                String s = listeDesReclamationsDuClient.get(i).getMontant().substring(0, listeDesReclamationsDuClient.get(i).getMontant().length() - 1);
                double montantAjuster = Double.parseDouble(s);
                int numSoin = Integer.parseInt(listeDesReclamationsDuClient.get(i).getSoin());
                String montant = Contrat.remboursementParTypeContratMontantNumSoin(contratType, montantAjuster, numSoin)+"";
                if (montant.charAt(montant.length()-2) == '.'){
                    montant = montant + "0$";
                } else{
                    montant = montant +"$";
                }
                   
                Text textMontant = nouveauDocument.createTextNode(montant);
                montantEcrit.appendChild(textMontant);

            }


            DocumentXml.enregistrerSousDocumentXml(args[1], nouveauDocument);
            System.out.println("Le fichier entree est : " + args[0]);
            System.out.println("Le fichier a ete enregistre : " + args[1]);
            
        }
    }
}