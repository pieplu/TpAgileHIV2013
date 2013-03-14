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
    
    
    
    @Override
      double refundForContractNumSoin0 (){
        return  Contract.refundCalculator(0.5,40);
    }
    
    @Override
      double refundForContractNumSoin100 (){
        return  Contract.refundCalculator(0.5,50);
    }
    
    @Override
      double refundForContractNumSoin150 (){
        return  Contract.refundCalculator(0);
    }
    
    @Override
      double refundForContractNumSoin175 (){
        return  Contract.refundCalculator(0.75);
    }
    
    @Override
      double refundForContractNumSoin200 (){
        return  Contract.refundCalculator(1);
    }
    
    @Override
      double refundForContractNumSoin300 (){
        return  Contract.refundCalculator(0.5);
    }
    
    @Override
      double refundForContractNumSoin400 (){
        return 0;
    }
    
    @Override
      double refundForContractNumSoin500 (){
        return  Contract.refundCalculator(0.5,50);
    }
    
    @Override
      double refundForContractNumSoin600 (){
        return Contract.getAmountInXmlFile();
    }
    
    @Override
      double refundForContractNumSoin700 (){
        return Contract.refundCalculator(0.7);
    }
}
