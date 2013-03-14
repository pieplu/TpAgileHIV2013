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
     double refundForContractNumSoin0 (){
        return  Contract.refundCalculator(0.15);
    }
    
    @Override
     double refundForContractNumSoin100 (){
        return  Contract.refundCalculator(0.25);
    }
    
    @Override
     double refundForContractNumSoin150 (){
        return  Contract.refundCalculator(0.15);
    }
    
    @Override
     double refundForContractNumSoin175 (){
        return  Contract.refundCalculator(0.25,20);
    }
    
    @Override
     double refundForContractNumSoin200 (){
        return  Contract.refundCalculator(0.12);
    }
    
    @Override
     double refundForContractNumSoin300 (){
        return  Contract.refundCalculator(0.60);
    }
    
    @Override
     double refundForContractNumSoin400 (){
        return  Contract.refundCalculator(0.25,15);
    }
    
    @Override
     double refundForContractNumSoin500 (){
        return  Contract.refundCalculator(0.30,20);
    }
    
    @Override
     double refundForContractNumSoin600 (){
        return  Contract.refundCalculator(0.15);
    }
    
    @Override
     double refundForContractNumSoin700 (){
        return  Contract.refundCalculator(0.22);
    }
    
}
