/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import InsuranceSoftware.XMLFileCreator;
import InsuranceSoftware.NodeObject;
import InsuranceSoftware.ValidationRunner;

/**
 *
 * @author utilisateur
 */
public class XmlNodes {

    static final String LIST_OF_XML_TAGS[] = new String[]{"reclamations", "dossier", "mois", "soin", "date", "montant"};
    static public final String TAG_ROOT = "reclamation";
    private static XMLFileCreator tagToVerify;

    public XmlNodes(XMLFileCreator tagToVerify) {
        this.tagToVerify = tagToVerify;
    }

    public boolean verifyIfXmlFormIsValid() {
        if (!isEssentialTagValid("reclamations")
                || !areNodeChildrenValid("reclamations", "dossier")
                || !areNodeChildrenValid("reclamations", "mois")
                || !areNodeChildrenValid("reclamations", "reclamation")) {
            return false;
        }

        ArrayList<NodeObject> ListOfAllReclamations = XMLFileCreator.createListOfIndividualReclamationXmlNodeToTestNodeName("reclamation", tagToVerify);
        for (int i = 0; i < ListOfAllReclamations.size(); i++) {
            try {
                ListOfAllReclamations.get(i).getDate().equals("date");
            } catch (NullPointerException e) {
                ValidationRunner.setErrorMessage("Une balise date est manquante.");
                return false;
            }

            try {
                ListOfAllReclamations.get(i).getSoin().equals("soin");
            } catch (NullPointerException e) {
                ValidationRunner.setErrorMessage("Une balise soin est manquante.");
                return false;
            }

            try {
                ListOfAllReclamations.get(i).getMontant().equals("montant");
            } catch (NullPointerException e) {
                ValidationRunner.setErrorMessage("Une balise montant est manquante.");
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
            ValidationRunner.setErrorMessage("Le document XML est corrompu");
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
            ValidationRunner.setErrorMessage("La balise " + expectedTagName + " n'est pas présente dans le document XML");
            return false;
        }
        return false;
    }
}
