package RefundCalculator;

public class ContractB extends ContractTemplate{
    
    
    
    @Override
      double refundForContractNumSoin0 (){
        return  Calculator.refundCalculator(0.5,40);
    }
    
    @Override
      double refundForContractNumSoin100 (){
        return  Calculator.refundCalculator(0.5,50);
    }
    
    @Override
      double refundForContractNumSoin150 (){
        return  Calculator.refundCalculator(0);
    }
    
    @Override
      double refundForContractNumSoin175 (){
        return  Calculator.refundCalculator(0.75);
    }
    
    @Override
      double refundForContractNumSoin200 (){
        return  Calculator.refundCalculator(1);
    }
    
    @Override
      double refundForContractNumSoin300 (){
        return  Calculator.refundCalculator(0.5);
    }
    
    @Override
      double refundForContractNumSoin400 (){
        return 0;
    }
    
    @Override
      double refundForContractNumSoin500 (){
        return  Calculator.refundCalculator(0.5,50);
    }
    
    @Override
      double refundForContractNumSoin600 (){
        return Calculator.getAmountInXmlFile();
    }
    
    @Override
      double refundForContractNumSoin700 (){
        return Calculator.refundCalculator(0.7);
    }
}
