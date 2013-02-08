/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;
import org.w3c.dom.NodeList;


/**
 *
 * @Mathieu Latour
 */
public class ExecutionValidation {

    /**
     * @param args the command line arguments
     */
    public static boolean exexValid() throws Exception {

        boolean testValid = true;

        DocumentXml document = new DocumentXml();
        //Entrer Ã  la main le tag parent qui contient ce que vous cherchez
        NodeList formulaire = DocumentXml.getNodesByName("reclamations");
        String clientID = document.obtainNodeContent(formulaire.item(0), "client");
        String contratType = document.obtainNodeContent(formulaire.item(0), "contrat");
        String mois = document.obtainNodeContent(formulaire.item(0), "mois");

        ArrayList<ReclamationObject> listeDesReclamationsDuClient = new <ReclamationObject> ArrayList();

        NodeList reclamationDuXML = DocumentXml.getNodesByName("reclamation");
        for (int i = 0; i < reclamationDuXML.getLength(); i++) {
            listeDesReclamationsDuClient.add(new ReclamationObject(reclamationDuXML, i, document));
        }

        if (Validation.isClientNumberValid(clientID)) {
            //System.out.println("Ça fonctionne");
            //METHODE POUR FICHIER DEFECT.
        }else{
            //System.out.print("Le numero de client n'est pas valide");
            testValid = false;
        }
        
        if (Validation.isContractLetterValid(contratType)) {
            //System.out.println("Ça fonctionne");
            //METHODE POUR FICHIER DEFECT.
        }else{
            //System.out.print("La lettre du contrat n'est pas valide");
            testValid = false;
        }
        
        if (Validation.isActualMonthFormValid(mois)) {
            //System.out.println("Ça fonctionne");
            //METHODE POUR FICHIER DEFECT.
        }else{
            //System.out.print("Le mois n'est pas valide");
            testValid = false;
        }

        for (int i = 0; i < listeDesReclamationsDuClient.size(); i++) {
            //System.out.println("\n\n");
            if (Validation.isAmountFormValid(listeDesReclamationsDuClient.get(i).getMontant())) {
            //    System.out.println("La forme du montant en $ est valide");
                
            }else{
            //    System.out.println("La forme du montant en $ n'est pas valide");
                //METHODE DE FICHIER DEFECT.
                testValid = false;
            }
            
            if (Validation.dateValide((listeDesReclamationsDuClient.get(i).getDate()))){
            //    System.out.println("La date est valide");
                
            }else{
            //    System.out.println("La date n'est pas valide");
                //METHODE DE FICHIER DEFECT.
                testValid = false;
            }
            
             if (Validation.monthValide(mois)){
            //    System.out.println("La date est valide");
                
            }else{
            //    System.out.println("La date n'est pas valide");
                //METHODE DE FICHIER DEFECT.
                testValid = false;
            }
            
            if (Validation.isServiceNumberValid(listeDesReclamationsDuClient.get(i).getSoin())) {
            //    System.out.println("Le numero de service est valide");
            }else{
            //    System.out.println("Le numero de service n'est pas valide");
                //METHODE DE FICHIER DEFECT.
                testValid = false;
            }
            
            //System.out.println("Numero:"+listeDesReclamationsDuClient.get(i).getDate());
            if (Validation.isDateValid(listeDesReclamationsDuClient.get(i).getDate(), mois)) {
                
            //    System.out.println("La date est valide");
            }else{
            //    System.out.println("La date n'est pas valide");
                //METHODE DE FICHIER DEFECT.
                testValid = false;
                
            //  System.out.println("\n");
            }
        }

        //System.out.println(testValid);
        return testValid;
    }
}
