/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pack.DocumentXml;
import pack.IndividualReclamationXmlNode;
import pack.ValidationExecution;

/**
 *
 * @author utilisateur
 */
public class XmlNodes {

    static final String LIST_OF_XML_TAGS[] = new String[]{"reclamations", "dossier", "mois", "soin", "date", "montant"};
    static public final String TAG_ROOT = "reclamation";
    private static DocumentXml tagToVerify;

    public XmlNodes(DocumentXml tagToVerify) {
        this.tagToVerify = tagToVerify;
    }

    public boolean verifyIfXmlFormIsValid() {
        if (!isEssentialTagValid("reclamations")
                || !areNodeChildrenValid("reclamations", "dossier")
                || !areNodeChildrenValid("reclamations", "mois")
                || !areNodeChildrenValid("reclamations", "reclamation")) {
            return false;
        }

        ArrayList<IndividualReclamationXmlNode> ListOfAllReclamations = DocumentXml.createListOfIndividualReclamationXmlNodeToTestNodeName("reclamation", tagToVerify);
        for (int i = 0; i < ListOfAllReclamations.size(); i++) {
            try {
                ListOfAllReclamations.get(i).getDate().equals("date");
            } catch (NullPointerException e) {
                ValidationExecution.setErrorMessage("Une balise date est manquante.");
                return false;
            }

            try {
                ListOfAllReclamations.get(i).getSoin().equals("soin");
            } catch (NullPointerException e) {
                ValidationExecution.setErrorMessage("Une balise soin est manquante.");
                return false;
            }

            try {
                ListOfAllReclamations.get(i).getMontant().equals("montant");
            } catch (NullPointerException e) {
                ValidationExecution.setErrorMessage("Une balise montant est manquante.");
                return false;
            }


            if (!ListOfAllReclamations.get(i).getDate().equals("date")
                    || !ListOfAllReclamations.get(i).getSoin().equals("soin")
                    || !ListOfAllReclamations.get(i).getMontant().equals("montant")) {
                return false;

            }
        }
        return true;
    }

    public static boolean isEssentialTagValid(String expectedTagName) {
        try {
            tagToVerify.getNodesByName(expectedTagName);
        } catch (NullPointerException e) {
            ValidationExecution.setErrorMessage("Le document XML est corrompu");
            return false;
        }
        return true;

    }

    public boolean areNodeChildrenValid(String parentName, String expectedTagName) {
        NodeList XmlForm = tagToVerify.getNodesByName(parentName);
        try {
            if (tagToVerify.obtainNodeName(XmlForm.item(0), expectedTagName).equals(expectedTagName)) {
                return true;
            }
        } catch (NullPointerException e) {
            ValidationExecution.setErrorMessage("La balise " + expectedTagName + " n'est pas présente dans le document XML");
            return false;
        }
        return false;
    }
}
