package RefundCalculator;

public class ContractE extends ContractTemplate {
   
    
    
    @Override
     double refundForContractNumSoin0 (){
        return  Calculator.refundCalculator(0.15);
    }
    
    @Override
     double refundForContractNumSoin100 (){
        return  Calculator.refundCalculator(0.25);
    }
    
    @Override
     double refundForContractNumSoin150 (){
        return  Calculator.refundCalculator(0.15);
    }
    
    @Override
     double refundForContractNumSoin175 (){
        return  Calculator.refundCalculator(0.25,20);
    }
    
    @Override
     double refundForContractNumSoin200 (){
        return  Calculator.refundCalculator(0.12);
    }
    
    @Override
     double refundForContractNumSoin300 (){
        return  Calculator.refundCalculator(0.60);
    }
    
    @Override
     double refundForContractNumSoin400 (){
        return  Calculator.refundCalculator(0.25,15);
    }
    
    @Override
     double refundForContractNumSoin500 (){
        return  Calculator.refundCalculator(0.30,20);
    }
    
    @Override
     double refundForContractNumSoin600 (){
        return  Calculator.refundCalculator(0.15);
    }
    
    @Override
     double refundForContractNumSoin700 (){
        return  Calculator.refundCalculator(0.22);
    }
    
}
