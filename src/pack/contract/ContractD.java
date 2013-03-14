/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

/**
 *
 * @author Dominique Menard
 */
public class ContractD extends ContractTemplate{
    

    
    @Override
     double refundForContractNumSoin0 (){
        return  Contract.refundCalculator(1,85);
    }
    
    @Override
     double refundForContractNumSoin100 (){
        return  Contract.refundCalculator(1,75);
    }
    
    @Override
     double refundForContractNumSoin150 (){
        return  Contract.refundCalculator(1,150);
    }
    
    @Override
     double refundForContractNumSoin175 (){
        return  Contract.refundCalculator(0.95);
    }
    
    @Override
     double refundForContractNumSoin200 (){
        return  Contract.refundCalculator(1,100);
    }
    
    @Override
     double refundForContractNumSoin300 (){
        return  Contract.getAmountInXmlFile();
    }
    
    @Override
     double refundForContractNumSoin400 (){
        return  Contract.refundCalculator(1,65);
    }
    
    @Override
     double refundForContractNumSoin500 (){
        return  Contract.refundCalculator(1);
    }
    
    @Override
     double refundForContractNumSoin600 (){
        return  Contract.refundCalculator(1,100);
    }
    
    @Override
     double refundForContractNumSoin700 (){
        return  Contract.refundCalculator(1,90);
    }
    
}
