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
    
    
    
      double reimbursementCalculationForContractNumSoin0 (){
        return  Contract.reimbursementCalculation(0.5,40);
    }
    
      double reimbursementCalculationForContractNumSoin100 (){
        return  Contract.reimbursementCalculation(0.5,50);
    }
    
      double reimbursementCalculationForContractNumSoin150 (){
        return  Contract.reimbursementCalculation(0);
    }
    
      double reimbursementCalculationForContractNumSoin175 (){
        return  Contract.reimbursementCalculation(0.75);
    }
    
      double reimbursementCalculationForContractNumSoin200 (){
        return  Contract.reimbursementCalculation(1);
    }
    
      double reimbursementCalculationForContractNumSoin300 (){
        return  Contract.reimbursementCalculation(0.5);
    }
    
      double reimbursementCalculationForContractNumSoin400 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin500 (){
        return  Contract.reimbursementCalculation(0.5,50);
    }
    
      double reimbursementCalculationForContractNumSoin600 (){
        return Contract.ammountInXmlFile;
    }
    
      double reimbursementCalculationForContractNumSoin700 (){
        return Contract.reimbursementCalculation(0.7);
    }
}
