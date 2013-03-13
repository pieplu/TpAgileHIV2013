/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

/**
 *
 * @author Dominique Menard
 */
public class ContractB extends ContractTemplate{
    
    
    
    static double reimbursementCalculationForContractNumSoin0 (){
        return ammountToReimburse = reimbursementCalculation(0.5,40);
    }
    
    static double reimbursementCalculationForContractNumSoin100 (){
        return ammountToReimburse = reimbursementCalculation(0.5,50);
    }
    
    static double reimbursementCalculationForContractNumSoin150 (){
        return ammountToReimburse = reimbursementCalculation(0);
    }
    
    static double reimbursementCalculationForContractNumSoin175 (){
        return ammountToReimburse = reimbursementCalculation(0.75);
    }
    
    static double reimbursementCalculationForContractNumSoin200 (){
        return ammountToReimburse = reimbursementCalculation(1);
    }
    
    static double reimbursementCalculationForContractNumSoin300 (){
        return ammountToReimburse = reimbursementCalculation(0.5);
    }
    
    static double reimbursementCalculationForContractNumSoin400 (){
        return 0;
    }
    
    static double reimbursementCalculationForContractNumSoin500 (){
        return ammountToReimburse = reimbursementCalculation(0.5,50);
    }
    
    static double reimbursementCalculationForContractNumSoin600 (){
        return ammountToReimburse = ammountInXmlFile;
    }
    
    static double reimbursementCalculationForContractNumSoin700 (){
        return ammountToReimburse = reimbursementCalculation(0.7);
    }
}
