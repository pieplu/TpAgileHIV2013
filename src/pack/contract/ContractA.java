/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

/**
 *
 * @author Dominique Menard
 */
public class ContractA extends Contract{
    
    static double selectNumSoinContratA() {
        if(numSoin==0){reimbursementCalculationForContractAnumSoin0 ();}
        if(numSoin==100){reimbursementCalculationForContractAnumSoin100 ();}
        if(numSoin==150){reimbursementCalculationForContractAnumSoin150 ();}
        if(numSoin==175){reimbursementCalculationForContractAnumSoin175 ();}
        if(numSoin==200){reimbursementCalculationForContractAnumSoin200 ();}
        if(numSoin>=300 && numSoin<=399){reimbursementCalculationForContractAnumSoin300 ();}
        if(numSoin==400){reimbursementCalculationForContractAnumSoin400 ();}
        if(numSoin==500){reimbursementCalculationForContractAnumSoin500 ();}
        if(numSoin==600){reimbursementCalculationForContractAnumSoin600 ();}
        if(numSoin==700){reimbursementCalculationForContractAnumSoin700 ();}
        return ammountToReimburseInXmlElementRemboursement;
    }
    
    static double reimbursementCalculationForContractAnumSoin0 (){
        return ammountToReimburseInXmlElementRemboursement = Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractAnumSoin100 (){
        return ammountToReimburseInXmlElementRemboursement = Contract.reimbursementCalculation(0.35);
    }
    
    static double reimbursementCalculationForContractAnumSoin150 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0);
    }
    
    static double reimbursementCalculationForContractAnumSoin175 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.50);
    }
    
    static double reimbursementCalculationForContractAnumSoin200 (){
        return ammountToReimburseInXmlElementRemboursement = Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractAnumSoin300 (){
        return 0;
    }
    
    static double reimbursementCalculationForContractAnumSoin400 (){
        return 0;
    }
    
    static double reimbursementCalculationForContractAnumSoin500 (){
        return ammountToReimburseInXmlElementRemboursement = Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractAnumSoin600 (){
        return ammountToReimburseInXmlElementRemboursement = ammountInXmlFile * 0.4;
    }
    
    static double reimbursementCalculationForContractAnumSoin700 (){
        return 0;
    }
}
