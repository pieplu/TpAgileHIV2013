/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Mathieu Latour
 */
public class ContratE extends Contrat {
     static double selectionSoinContratE() {
        if(numSoin==0){calculRemboursementContratDnumSoin0 ();}
        if(numSoin==100){calculRemboursementContratDnumSoin100 ();}
        if(numSoin==150){calculRemboursementContratDnumSoin150 ();}
        if(numSoin==175){calculRemboursementContratDnumSoin175 ();}
        if(numSoin==200){calculRemboursementContratDnumSoin200 ();}
        if(numSoin==300){calculRemboursementContratDnumSoin300 ();}
        if(numSoin==400){calculRemboursementContratDnumSoin400 ();}
        if(numSoin==500){calculRemboursementContratDnumSoin500 ();}
        if(numSoin==600){calculRemboursementContratDnumSoin600 ();}
        if(numSoin==700){calculRemboursementContratDnumSoin700 ();}
        return montantRembourser;
    }
    
    static double calculRemboursementContratDnumSoin0 (){
        return montantRembourser = calculRemboursement(0.15);
    }
    
    static double calculRemboursementContratDnumSoin100 (){
        return montantRembourser = calculRemboursement(0.25);
    }
    
    static double calculRemboursementContratDnumSoin150 (){
        return montantRembourser = calculRemboursement(0.15);
    }
    
    static double calculRemboursementContratDnumSoin175 (){
        return montantRembourser = calculRemboursement(0.25,20);
    }
    
    static double calculRemboursementContratDnumSoin200 (){
        return montantRembourser = calculRemboursement(0.12);
    }
    
    static double calculRemboursementContratDnumSoin300 (){
        return montantRembourser = calculRemboursement(0.60);
    }
    
    static double calculRemboursementContratDnumSoin400 (){
        return montantRembourser = calculRemboursement(0.25,15);
    }
    
    static double calculRemboursementContratDnumSoin500 (){
        return montantRembourser = calculRemboursement(0.30,20);
    }
    
    static double calculRemboursementContratDnumSoin600 (){
        return montantRembourser = calculRemboursement(0.15);
    }
    
    static double calculRemboursementContratDnumSoin700 (){
        return montantRembourser = calculRemboursement(0.22);
    }
    
}
