/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Dominique Menard
 */
public class ContratB extends Contrat{
    
    static double selectionSoinContratB() {
        if(numSoin==0){calculRemboursementContratBnumSoin0 ();}
        if(numSoin==100){calculRemboursementContratBnumSoin100 ();}
        if(numSoin==150){calculRemboursementContratDnumSoin150 ();}
        if(numSoin==175){calculRemboursementContratDnumSoin175 ();}
        if(numSoin==200){calculRemboursementContratBnumSoin200 ();}
        if(numSoin>=300 && numSoin<=399){calculRemboursementContratBnumSoin300 ();}
        if(numSoin==400){calculRemboursementContratBnumSoin400 ();}
        if(numSoin==500){calculRemboursementContratBnumSoin500 ();}
        if(numSoin==600){calculRemboursementContratBnumSoin600 ();}
        if(numSoin==700){calculRemboursementContratBnumSoin700 ();}
        return montantRembourser;
    }
    
    static double calculRemboursementContratBnumSoin0 (){
        return montantRembourser = calculRemboursement(0.5,40);
    }
    
    static double calculRemboursementContratBnumSoin100 (){
        return montantRembourser = calculRemboursement(0.5,50);
    }
    
    static double calculRemboursementContratDnumSoin150 (){
        return montantRembourser = calculRemboursement(0);
    }
    
    static double calculRemboursementContratDnumSoin175 (){
        return montantRembourser = calculRemboursement(0.75);
    }
    
    static double calculRemboursementContratBnumSoin200 (){
        return montantRembourser = calculRemboursement(1);
    }
    
    static double calculRemboursementContratBnumSoin300 (){
        return montantRembourser = calculRemboursement(0.5);
    }
    
    static double calculRemboursementContratBnumSoin400 (){
        return 0;
    }
    
    static double calculRemboursementContratBnumSoin500 (){
        return montantRembourser = calculRemboursement(0.5,50);
    }
    
    static double calculRemboursementContratBnumSoin600 (){
        return montantRembourser = montant;
    }
    
    static double calculRemboursementContratBnumSoin700 (){
        return montantRembourser = calculRemboursement(0.7);
    }
}
