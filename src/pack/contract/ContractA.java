/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

/**
 *
 * @author Dominique Menard
 */
public class ContractA extends ContractTemplate{
    
    
    
    static double reimbursementCalculationForContractNumSoin0 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractNumSoin100 (){
        return Contract.reimbursementCalculation(0.35);
    }
    
    static double reimbursementCalculationForContractNumSoin150 (){
        return reimbursementCalculation(0);
    }
    
    static double reimbursementCalculationForContractNumSoin175 (){
        return reimbursementCalculation(0.50);
    }
    
    static double reimbursementCalculationForContractNumSoin200 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractNumSoin300 (){
        return 0;
    }
    
    static double reimbursementCalculationForContractNumSoin400 (){
        return 0;
    }
    
    static double reimbursementCalculationForContractNumSoin500 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractNumSoin600 (){
        return Contract.reimbursementCalculation(0.4);
    }
    
    static double reimbursementCalculationForContractNumSoin700 (){
        return 0;
    }
}
