/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Dominique Menard
 */
public class ContratA extends Contrat{
    
    static double selectionSoinContratA() {
        if(numSoin==0){calculRemboursementContratAnumSoin0 ();}
        if(numSoin==100){calculRemboursementContratAnumSoin100 ();}
        if(numSoin==150){calculRemboursementContratDnumSoin150 ();}
        if(numSoin==175){calculRemboursementContratDnumSoin175 ();}
        if(numSoin==200){calculRemboursementContratAnumSoin200 ();}
        if(numSoin>=300 && numSoin<=399){calculRemboursementContratAnumSoin300 ();}
        if(numSoin==400){calculRemboursementContratAnumSoin400 ();}
        if(numSoin==500){calculRemboursementContratAnumSoin500 ();}
        if(numSoin==600){calculRemboursementContratAnumSoin600 ();}
        if(numSoin==700){calculRemboursementContratAnumSoin700 ();}
        return montantRembourser;
    }
    
    static double calculRemboursementContratAnumSoin0 (){
        return montantRembourser = Contrat.calculRemboursement(0.25);
    }
    
    static double calculRemboursementContratAnumSoin100 (){
        return montantRembourser = Contrat.calculRemboursement(0.35);
    }
    
    static double calculRemboursementContratDnumSoin150 (){
        return montantRembourser = calculRemboursement(0);
    }
    
    static double calculRemboursementContratDnumSoin175 (){
        return montantRembourser = calculRemboursement(0.50);
    }
    
    static double calculRemboursementContratAnumSoin200 (){
        return montantRembourser = Contrat.calculRemboursement(0.25);
    }
    
    static double calculRemboursementContratAnumSoin300 (){
        return 0;
    }
    
    static double calculRemboursementContratAnumSoin400 (){
        return 0;
    }
    
    static double calculRemboursementContratAnumSoin500 (){
        return montantRembourser = Contrat.calculRemboursement(0.25);
    }
    
    static double calculRemboursementContratAnumSoin600 (){
        return montantRembourser = montant * 0.4;
    }
    
    static double calculRemboursementContratAnumSoin700 (){
        return 0;
    }
}
