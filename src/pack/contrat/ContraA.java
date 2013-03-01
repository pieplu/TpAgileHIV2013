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
    
    static double selectionSoinContratA(double montant, int numSoin) {
        double montantRembourser = 0;
        if(numSoin==0){calculRemboursementContratAnumSoin0 (montant,numSoin);}
        if(numSoin==100){calculRemboursementContratAnumSoin100 (montant,numSoin);}
        if(numSoin==200){calculRemboursementContratAnumSoin200 (montant,numSoin);}
        if(numSoin==300){calculRemboursementContratAnumSoin300 (montant,numSoin);}
        if(numSoin==400){calculRemboursementContratAnumSoin400 (montant,numSoin);}
        if(numSoin==500){calculRemboursementContratAnumSoin500 (montant,numSoin);}
        if(numSoin==600){calculRemboursementContratAnumSoin600 (montant,numSoin);}
        if(numSoin==700){calculRemboursementContratAnumSoin700 (montant,numSoin);}
        return montantRembourser;
    }
    
    static double calculRemboursementContratAnumSoin0 (double montant, int numSoin){
        double montantRembourser;
        return montantRembourser = Contrat.calculRemboursement(montant,0.25);
    }
    
    static double calculRemboursementContratAnumSoin100 (double montant, int numSoin){
        double montantRembourser;
        return montantRembourser = Contrat.calculRemboursement(montant,0.25);
    }
    
    static double calculRemboursementContratAnumSoin200 (double montant, int numSoin){
        double montantRembourser;
        return montantRembourser = Contrat.calculRemboursement(montant,0.25);
    }
    
    static double calculRemboursementContratAnumSoin500 (double montant, int numSoin){
        double montantRembourser;
        return montantRembourser = Contrat.calculRemboursement(montant,0.25);
    }
    
    static double calculRemboursementContratAnumSoin300 (double montant, int numSoin){
        return 0;
    }
    
    static double calculRemboursementContratAnumSoin400 (double montant, int numSoin){
        return 0;
    }
    
    static double calculRemboursementContratAnumSoin700 (double montant, int numSoin){
        return 0;
    }
    
    static double calculRemboursementContratAnumSoin600 (double montant, int numSoin){
        double montantRembourser;
        return montantRembourser = montant * 0.4;
    }
}
