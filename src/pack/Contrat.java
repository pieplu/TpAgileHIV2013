/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author Dominique Ménard
 */
public class Contrat {

    private static int standardisationNumSoin(int numSoin) {
        int modificationNumSoin = numSoin;
        if (numSoin >= 300 && numSoin <= 399) {
            modificationNumSoin = 300;
        }
        return modificationNumSoin;
    }
    
    private static double calculRemboursement(double montant, double multiple, double maxMontant){
        double montantRembourser;
        montantRembourser = montant * multiple;
                if (montantRembourser > maxMontant) {
                    montantRembourser = maxMontant;
                }
                
        return montantRembourser;
    }
    
    private static double calculRemboursement(double montant, double multiple){
//System.out.println(montant);
        return montant * multiple;
    }

    private static double contratA(double montant, int numSoin) {
        double montantRembourser = 0;
        switch (standardisationNumSoin(numSoin)) {
            case 0:case 100:case 200:case 500:
                montantRembourser = calculRemboursement(montant,0.25);
                break;
            case 300:case 400:case 700:
                montantRembourser = 0;
                break;
            case 600:
                montantRembourser = montant * 0.4;
                break;
        }

        return montantRembourser;
    }

    private static double contratB(double montant, int numSoin) {
        double montantRembourser = 0;
        switch (standardisationNumSoin(numSoin)) {
            case 0:
                montantRembourser = calculRemboursement(montant,0.5,40);
                break;
            case 100:case 500:
                montantRembourser = calculRemboursement(montant,0.5,50);
                break;
            case 200:
                montantRembourser = calculRemboursement(montant,1,70);
                break;
            case 300:
                montantRembourser = calculRemboursement(montant,0.5);
                break;
            case 400:
                montantRembourser = 0;
                break;
            case 600:
                montantRembourser = montant;
                break;
            case 700:
                montantRembourser = calculRemboursement(montant,0.7);
                break;
        }

        return montantRembourser;
    }

    private static double contratC(double montant, int numSoin) {
        double montantRembourser = montant * 0.9;

        return montantRembourser;
    }

    private static double contratD(double montant, int numSoin) {
        double montantRembourser = 0;
        switch (standardisationNumSoin(numSoin)) {
            case 0:
                montantRembourser = calculRemboursement(montant,1,85);
                break;
            case 100:case 500:
                montantRembourser = calculRemboursement(montant,1,75);
                break;
            case 200:case 600:
                montantRembourser = calculRemboursement(montant,1,100);
                break;
            case 300:
                montantRembourser = montant;
                break;
            case 400:
                montantRembourser = calculRemboursement(montant,1,65);
                break;
            case 700:
                montantRembourser = calculRemboursement(montant,1,90);
                break;
        }

        return montantRembourser;
    }

    public static double remboursement(String typeContrat, double montant, int numSoin) {
        double montantRembourser = 0;
        if (typeContrat.equals("A")) {
            montantRembourser = contratA(montant, numSoin);
        }
        if (typeContrat.equals("B")) {
            montantRembourser = contratB(montant, numSoin);
        }
        if (typeContrat.equals("C")) {
            montantRembourser = contratC(montant, numSoin);
        }
        if (typeContrat.equals("D")) {
            montantRembourser = contratD(montant, numSoin);
        }
       // System.out.println(montantRembourser);
        return montantRembourser;
    }
}
