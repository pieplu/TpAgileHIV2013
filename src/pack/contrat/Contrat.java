/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;
/**
 *
 * @author Dominique Ménard
 */
public class Contrat {
    
    static double montant;
    static int numSoin;
    static double montantRembourser = 0;
    
    static double calculRemboursement(double multiple, double maxMontant){
        montantRembourser = montant * multiple;
                if (montantRembourser > maxMontant) {
                    montantRembourser = maxMontant;
                }
        return montantRembourser;
    }
    
    static double calculRemboursement(double multiple){
        return montant * multiple;
    }

    public static double remboursementParTypeContratMontantNumSoin(String typeContrat, double montant, int numSoin) {
        setBasicContractInformation (montant, numSoin);
        if (typeContrat.equals("A")) {
            montantRembourser = ContratA.selectionSoinContratA();
        }
        if (typeContrat.equals("B")) {
            montantRembourser = ContratB.selectionSoinContratB();
        }
        if (typeContrat.equals("C")) {
            montantRembourser = ContratC.selectionSoinContratC();
        }
        if (typeContrat.equals("D")) {
            montantRembourser = ContratD.selectionSoinContratD();
        }     
        if (typeContrat.equals("E")) {
            montantRembourser = ContratE.selectionSoinContratE();
        }
        return roundUpDoubleNumberUpToTwoDecimals(montantRembourser);
    }
    
    private static void setBasicContractInformation (double montant, int numSoin){
        setMontant (montant);
        setNumSoin (numSoin);
    }
    
    private static void setMontant (double montant){
        Contrat.montant = montant;
    }
    
    private static void setNumSoin (int numSoin){
        Contrat.numSoin = numSoin;
    }
    
    private static double roundUpDoubleNumberUpToTwoDecimals (double numberToRoudUp){
        double numberRounded = Math.round(numberToRoudUp*100);
        return numberRounded/100;
    }
    
}
