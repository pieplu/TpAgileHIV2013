package RefundCalculator;

public class ContractTemplate{
      
  double selectNumSoinContrat(int numSoin) {
        double result = 0;
        if(numSoin==0){result = refundForContractNumSoin0 ();}
        if(numSoin==100){result = refundForContractNumSoin100 ();}
        if(numSoin==150){result = refundForContractNumSoin150 ();}
        if(numSoin==175){result = refundForContractNumSoin175 ();}
        if(numSoin==200){result = refundForContractNumSoin200 ();}
        if(numSoin>=300 && numSoin<=399){result = refundForContractNumSoin300 ();}
        if(numSoin==400){result = refundForContractNumSoin400 ();}
        if(numSoin==500){result = refundForContractNumSoin500 ();}
        if(numSoin==600){result = refundForContractNumSoin600 ();}
        if(numSoin==700){result = refundForContractNumSoin700 ();}
        return result;
    }
 
 
 
      int refundForContractNumSoin0 (){
        return 0;
    }
    
      int refundForContractNumSoin100 (){
        return 0;
    }
    
      int refundForContractNumSoin150 (){
        return 0;
    }
    
      int refundForContractNumSoin175 (){
        return 0;
    }
    
      int refundForContractNumSoin200 (){
        return 0;
    }
    
      int refundForContractNumSoin300 (){
        return 0;
    }
    
      int refundForContractNumSoin400 (){
        return 0;
    }
    
      int refundForContractNumSoin500 (){
        return 0;
    }
    
      int refundForContractNumSoin600 (){
        return 0;
    }
    
      int refundForContractNumSoin700 (){
        return 0;
    }
}
