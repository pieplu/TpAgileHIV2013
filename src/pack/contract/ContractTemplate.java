/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

import static pack.contract.Contract.ammountInXmlFile;

/**
 *
 * @author hj991118
 */
public class ContractTemplate extends Contract{
    
   
    
  double selectNumSoinContrat(int numSoin) {
        double result = 0;
        if(numSoin==0){result = reimbursementCalculationForContractNumSoin0 ();}
        if(numSoin==100){result = reimbursementCalculationForContractNumSoin100 ();}
        if(numSoin==150){result = reimbursementCalculationForContractNumSoin150 ();}
        if(numSoin==175){result = reimbursementCalculationForContractNumSoin175 ();}
        if(numSoin==200){result = reimbursementCalculationForContractNumSoin200 ();}
        if(numSoin>=300 && numSoin<=399){result = reimbursementCalculationForContractNumSoin300 ();}
        if(numSoin==400){result = reimbursementCalculationForContractNumSoin400 ();}
        if(numSoin==500){result = reimbursementCalculationForContractNumSoin500 ();}
        if(numSoin==600){result = reimbursementCalculationForContractNumSoin600 ();}
        if(numSoin==700){result = reimbursementCalculationForContractNumSoin700 ();}
        return result;
    }
 
 
 
      double reimbursementCalculationForContractNumSoin0 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin100 (){
        System.out.println("soin 100 a 0, pas cool");
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin150 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin175 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin200 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin300 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin400 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin500 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin600 (){
        return 0;
    }
    
      double reimbursementCalculationForContractNumSoin700 (){
        return 0;
    }
}
