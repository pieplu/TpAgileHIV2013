/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Killdom
 */
public class ContraA {
    
    static double contratA(double montant, int numSoin) {
        double montantRembourser = 0;
        switch (Contrat.standardisationNumSoin(numSoin)) {
            case 0:case 100:case 200:case 500:
                montantRembourser = Contrat.calculRemboursement(montant,0.25);
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
}
