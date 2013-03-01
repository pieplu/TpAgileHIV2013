/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import pack.contrat.Contrat;
import org.w3c.dom.*;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import org.w3c.dom.Text;
import org.w3c.dom.Element;
import javax.xml.parsers.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.*;
import sun.org.mozilla.javascript.internal.regexp.*;

/**
 *
 * @author Dominique Ménard
 */
public class TP1AGILE {

    public static String lefichier = "";

    public static void main(String[] args) throws Exception {

        lefichier = args [0];
        
        if (ExecutionValidation.exexValid() == false) {
            Document nouveauError = DocumentXml.docInstanceBuilder().newDocument();

            Element remboursementsEcritError = nouveauError.createElement("remboursements");
            nouveauError.appendChild(remboursementsEcritError);

            Element messageError = nouveauError.createElement("message");
            remboursementsEcritError.appendChild(messageError);
            Text textMessageError = nouveauError.createTextNode("Données invalides");
            messageError.appendChild(textMessageError);
            
            DocumentXml.enregistrerSousDocumentXml("src\\pack\\result.xml", nouveauError);
        } else {

            DocumentXml document = new DocumentXml();

            NodeList formulaire = document.getNodesByName("reclamations");
            String clientID = document.obtainNodeContent(formulaire.item(0), "client");
            String contratType = document.obtainNodeContent(formulaire.item(0), "contrat");
            String mois = document.obtainNodeContent(formulaire.item(0), "mois");

            ArrayList<ReclamationObject> listeDesReclamationsDuClient = new <ReclamationObject> ArrayList();

            NodeList reclamationDuXML = document.getNodesByName("reclamation");
            for (int i = 0; i < reclamationDuXML.getLength(); i++) {
                listeDesReclamationsDuClient.add(new ReclamationObject(reclamationDuXML, i, document));
            }
            Document nouveauDocument = DocumentXml.docInstanceBuilder().newDocument();

            Element remboursementsEcrit = nouveauDocument.createElement("remboursements");
            nouveauDocument.appendChild(remboursementsEcrit);

            Element clientEcrit = nouveauDocument.createElement("client");
            remboursementsEcrit.appendChild(clientEcrit);
            Text textClient = nouveauDocument.createTextNode(clientID);
            clientEcrit.appendChild(textClient);

            Element moisEcrit = nouveauDocument.createElement("mois");
            remboursementsEcrit.appendChild(moisEcrit);
            Text textMois = nouveauDocument.createTextNode(mois);
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


            DocumentXml.enregistrerSousDocumentXml("src\\pack\\result.xml", nouveauDocument);
            System.out.println("Le fichier entree est : src\\pack\\" + args[0]+ ".xml");
            System.out.println("Le fichier a ete enregistre : src\\pack\\result.xml");
            
        }
    }
}
