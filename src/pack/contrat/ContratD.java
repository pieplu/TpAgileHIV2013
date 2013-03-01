/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Killdom
 */
public class ContratD extends Contrat{
    
    static double selectionSoinContratD() {
        if(numSoin==0){calculRemboursementContratDnumSoin0 ();}
        if(numSoin==100){calculRemboursementContratDnumSoin100 ();}
        if(numSoin==200){calculRemboursementContratDnumSoin200 ();}
        if(numSoin==300){calculRemboursementContratDnumSoin300 ();}
        if(numSoin==400){calculRemboursementContratDnumSoin400 ();}
        if(numSoin==500){calculRemboursementContratDnumSoin500 ();}
        if(numSoin==600){calculRemboursementContratDnumSoin600 ();}
        if(numSoin==700){calculRemboursementContratDnumSoin700 ();}
        return montantRembourser;
    }
    
    static double calculRemboursementContratDnumSoin0 (){
        return montantRembourser = calculRemboursement(1,85);
    }
    
    static double calculRemboursementContratDnumSoin100 (){
        return montantRembourser = calculRemboursement(1,75);
    }
    
    static double calculRemboursementContratDnumSoin200 (){
        return montantRembourser = calculRemboursement(1,100);
    }
    
    static double calculRemboursementContratDnumSoin300 (){
        return montantRembourser = montant;
    }
    
    static double calculRemboursementContratDnumSoin400 (){
        return montantRembourser = calculRemboursement(1,65);
    }
    
    static double calculRemboursementContratDnumSoin500 (){
        return montantRembourser = calculRemboursement(1,75);
    }
    
    static double calculRemboursementContratDnumSoin600 (){
        return montantRembourser = calculRemboursement(1,100);
    }
    
    static double calculRemboursementContratDnumSoin700 (){
        return montantRembourser = calculRemboursement(1,90);
    }
    
}
