/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

/**
 *
 * @author Dominique Menard
 */
public class ContractC extends ContractTemplate {

 
    @Override
      double reimbursementCalculationForContractNumSoin0 (){
        return  Contract.reimbursementCalculation(0.9);
    }
    
    @Override
      double reimbursementCalculationForContractNumSoin100() {
        return  Contract.reimbursementCalculation(0.95);
    }

    @Override
      double reimbursementCalculationForContractNumSoin150() {
        return  Contract.reimbursementCalculation(0.85);
    }
    
    @Override
      double reimbursementCalculationForContractNumSoin175 (){
        return  Contract.reimbursementCalculation(0.9);
    }
    
    @Override
      double reimbursementCalculationForContractNumSoin200 (){
        return  Contract.reimbursementCalculation(0.9);
    }
    
    @Override
      double reimbursementCalculationForContractNumSoin300 (){
        return  Contract.reimbursementCalculation(0.9);
    }
    
    @Override
      double reimbursementCalculationForContractNumSoin400 (){
        return  Contract.reimbursementCalculation(0.9);
    }
    
    @Override
      double reimbursementCalculationForContractNumSoin500 (){
        return  Contract.reimbursementCalculation(0.9);
    }
    
    @Override
      double reimbursementCalculationForContractNumSoin600 (){
        return  Contract.reimbursementCalculation(0.75);
    }
    
    @Override
      double reimbursementCalculationForContractNumSoin700 (){
        return  Contract.reimbursementCalculation(0.9);
    }
}
