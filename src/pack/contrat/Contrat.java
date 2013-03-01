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
        double montantRembourser;
        montantRembourser = montant * multiple;
                if (montantRembourser > maxMontant) {
                    montantRembourser = maxMontant;
                }
        return montantRembourser;
    }
    
    static double calculRemboursement(double multiple){
        return montant * multiple;
    }

    static double remboursement(String typeContrat, double montant, int numSoin) {
        if (typeContrat.equals("A")) {
            montantRembourser = ContraA.selectionSoinContratA();
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
        return montantRembourser;
    }
}
