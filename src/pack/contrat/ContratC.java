/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Dominique Menard
 */
public class ContratC extends Contrat {

    static double selectionSoinContratC() {
        if (numSoin == 100) {calculRemboursementContratDnumSoin100();}
        if (numSoin == 150) {calculRemboursementContratDnumSoin150();}
        if(numSoin==600)    {calculRemboursementContratDnumSoin600 ();}
        else {
            return montantRembourser = montant * 0.9;
        }
        return montantRembourser;
    }

    static double calculRemboursementContratDnumSoin100() {
        return montantRembourser = calculRemboursement(0.95);
    }

    static double calculRemboursementContratDnumSoin150() {
        return montantRembourser = calculRemboursement(0.85);
    }
    
    static double calculRemboursementContratDnumSoin600 (){
        return montantRembourser = calculRemboursement(0.75);
    }
}
