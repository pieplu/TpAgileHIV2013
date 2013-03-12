/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Mathieu Latour
 */
public class ContractE extends Contract {
     static double selectNumSoinContratE() {
        if(numSoin==0){reimbursementCalculationForContractDnumSoin0 ();}
        if(numSoin==100){reimbursementCalculationForContractDnumSoin100 ();}
        if(numSoin==150){reimbursementCalculationForContractDnumSoin150 ();}
        if(numSoin==175){reimbursementCalculationForContractDnumSoin175 ();}
        if(numSoin==200){reimbursementCalculationForContractDnumSoin200 ();}
        if(numSoin>=300 && numSoin<=399){reimbursementCalculationForContractDnumSoin300 ();}
        if(numSoin==400){reimbursementCalculationForContractDnumSoin400 ();}
        if(numSoin==500){reimbursementCalculationForContractDnumSoin500 ();}
        if(numSoin==600){reimbursementCalculationForContractDnumSoin600 ();}
        if(numSoin==700){reimbursementCalculationForContractDnumSoin700 ();}
        return ammountToReimburseInXmlElementRemboursement;
    }
    
    static double reimbursementCalculationForContractDnumSoin0 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.15);
    }
    
    static double reimbursementCalculationForContractDnumSoin100 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractDnumSoin150 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.15);
    }
    
    static double reimbursementCalculationForContractDnumSoin175 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.25,20);
    }
    
    static double reimbursementCalculationForContractDnumSoin200 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.12);
    }
    
    static double reimbursementCalculationForContractDnumSoin300 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.60);
    }
    
    static double reimbursementCalculationForContractDnumSoin400 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.25,15);
    }
    
    static double reimbursementCalculationForContractDnumSoin500 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.30,20);
    }
    
    static double reimbursementCalculationForContractDnumSoin600 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.15);
    }
    
    static double reimbursementCalculationForContractDnumSoin700 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.22);
    }
    
}
