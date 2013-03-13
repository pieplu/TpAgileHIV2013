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

    
    
       double reimbursementCalculationForContractNumSoin0 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
       double reimbursementCalculationForContractNumSoin100 (){
        return Contract.reimbursementCalculation(0.35);
    }
    
       double reimbursementCalculationForContractNumSoin150 (){
        return 0;
    }
    
       double reimbursementCalculationForContractNumSoin175 (){
        return Contract.reimbursementCalculation(0.50);
    }
    
       double reimbursementCalculationForContractNumSoin200 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
       double reimbursementCalculationForContractNumSoin300 (){
        return 0;
    }
    
       double reimbursementCalculationForContractNumSoin400 (){
        return 0;
    }
    
       double reimbursementCalculationForContractNumSoin500 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
       double reimbursementCalculationForContractNumSoin600 (){
        return Contract.reimbursementCalculation(0.4);
    }
    
       double reimbursementCalculationForContractNumSoin700 (){
        return 0;
    }
}
