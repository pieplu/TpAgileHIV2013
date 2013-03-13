/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

/**
 *
 * @author Mathieu Latour
 */
public class ContractE extends ContractTemplate {
   
    
    
    @Override
     double reimbursementCalculationForContractNumSoin0 (){
        return  Contract.reimbursementCalculation(0.15);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin100 (){
        return  Contract.reimbursementCalculation(0.25);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin150 (){
        return  Contract.reimbursementCalculation(0.15);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin175 (){
        return  Contract.reimbursementCalculation(0.25,20);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin200 (){
        return  Contract.reimbursementCalculation(0.12);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin300 (){
        return  Contract.reimbursementCalculation(0.60);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin400 (){
        return  Contract.reimbursementCalculation(0.25,15);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin500 (){
        return  Contract.reimbursementCalculation(0.30,20);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin600 (){
        return  Contract.reimbursementCalculation(0.15);
    }
    
    @Override
     double reimbursementCalculationForContractNumSoin700 (){
        return  Contract.reimbursementCalculation(0.22);
    }
    
}
