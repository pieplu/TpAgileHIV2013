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

    
    
    @Override
       double reimbursementCalculationForContractNumSoin0 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin100 (){
        return Contract.reimbursementCalculation(0.35);
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin150 (){
        return 0;
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin175 (){
        return Contract.reimbursementCalculation(0.50);
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin200 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin300 (){
        return 0;
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin400 (){
        return 0;
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin500 (){
        return Contract.reimbursementCalculation(0.25);
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin600 (){
        return Contract.reimbursementCalculation(0.4);
    }
    
    @Override
       double reimbursementCalculationForContractNumSoin700 (){
        return 0;
    }
}
