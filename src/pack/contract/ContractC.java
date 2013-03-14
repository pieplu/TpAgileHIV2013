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
      double refundForContractNumSoin0 (){
        return  Contract.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin100() {
        return  Contract.refundCalculator(0.95);
    }

    @Override
      double refundForContractNumSoin150() {
        return  Contract.refundCalculator(0.85);
    }
    
    @Override
      double refundForContractNumSoin175 (){
        return  Contract.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin200 (){
        return  Contract.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin300 (){
        return  Contract.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin400 (){
        return  Contract.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin500 (){
        return  Contract.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin600 (){
        return  Contract.refundCalculator(0.75);
    }
    
    @Override
      double refundForContractNumSoin700 (){
        return  Contract.refundCalculator(0.9);
    }
}
