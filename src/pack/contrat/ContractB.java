/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Dominique Menard
 */
public class ContractB extends Contract{
    
    static double selectNumSoinContratB() {
        if(numSoin==0){reimbursementCalculationForContractBnumSoin0 ();}
        if(numSoin==100){reimbursementCalculationForContractBnumSoin100 ();}
        if(numSoin==150){reimbursementCalculationForContractBnumSoin150 ();}
        if(numSoin==175){reimbursementCalculationForContractBnumSoin175 ();}
        if(numSoin==200){reimbursementCalculationForContractBnumSoin200 ();}
        if(numSoin>=300 && numSoin<=399){reimbursementCalculationForContractBnumSoin300 ();}
        if(numSoin==400){reimbursementCalculationForContractBnumSoin400 ();}
        if(numSoin==500){reimbursementCalculationForContractBnumSoin500 ();}
        if(numSoin==600){reimbursementCalculationForContractBnumSoin600 ();}
        if(numSoin==700){reimbursementCalculationForContractBnumSoin700 ();}
        return ammountToReimburseInXmlElementRemboursement;
    }
    
    static double reimbursementCalculationForContractBnumSoin0 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.5,40);
    }
    
    static double reimbursementCalculationForContractBnumSoin100 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.5,50);
    }
    
    static double reimbursementCalculationForContractBnumSoin150 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0);
    }
    
    static double reimbursementCalculationForContractBnumSoin175 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.75);
    }
    
    static double reimbursementCalculationForContractBnumSoin200 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(1);
    }
    
    static double reimbursementCalculationForContractBnumSoin300 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.5);
    }
    
    static double reimbursementCalculationForContractBnumSoin400 (){
        return 0;
    }
    
    static double reimbursementCalculationForContractBnumSoin500 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.5,50);
    }
    
    static double reimbursementCalculationForContractBnumSoin600 (){
        return ammountToReimburseInXmlElementRemboursement = ammountInXmlFile;
    }
    
    static double reimbursementCalculationForContractBnumSoin700 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.7);
    }
}
