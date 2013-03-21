package RefundCalculator;

public class ContractA extends ContractTemplate{

    
    
    @Override
       int refundForContractNumSoin0 (){
        return Calculator.refundCalculator(25);
    }
    
    @Override
       int refundForContractNumSoin100 (){
        return Calculator.refundCalculator(35);
    }
    
    @Override
       int refundForContractNumSoin150 (){
        return 0;
    }
    
    @Override
       int refundForContractNumSoin175 (){
        return Calculator.refundCalculator(50);
    }
    
    @Override
       int refundForContractNumSoin200 (){
        return Calculator.refundCalculator(25);
    }
    
    @Override
       int refundForContractNumSoin300 (){
        return 0;
    }
    
    @Override
       int refundForContractNumSoin400 (){
        return 0;
    }
    
    @Override
       int refundForContractNumSoin500 (){
        return Calculator.refundCalculator(25);
    }
    
    @Override
       int refundForContractNumSoin600 (){
        return Calculator.refundCalculator(40);
    }
    
    @Override
       int refundForContractNumSoin700 (){
        return 0;
    }
}
