package RefundCalculator;

public class ContractC extends ContractTemplate {

 
    @Override
      double refundForContractNumSoin0 (){
        return  Calculator.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin100() {
        return  Calculator.refundCalculator(0.95);
    }

    @Override
      double refundForContractNumSoin150() {
        return  Calculator.refundCalculator(0.85);
    }
    
    @Override
      double refundForContractNumSoin175 (){
        return  Calculator.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin200 (){
        return  Calculator.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin300 (){
        return  Calculator.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin400 (){
        return  Calculator.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin500 (){
        return  Calculator.refundCalculator(0.9);
    }
    
    @Override
      double refundForContractNumSoin600 (){
        return  Calculator.refundCalculator(0.75);
    }
    
    @Override
      double refundForContractNumSoin700 (){
        return  Calculator.refundCalculator(0.9);
    }
}
