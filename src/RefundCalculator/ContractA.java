package RefundCalculator;

public class ContractA extends ContractTemplate{

    
    
    @Override
       double refundForContractNumSoin0 (){
        return Calculator.refundCalculator(0.25);
    }
    
    @Override
       double refundForContractNumSoin100 (){
        return Calculator.refundCalculator(0.35);
    }
    
    @Override
       double refundForContractNumSoin150 (){
        return 0;
    }
    
    @Override
       double refundForContractNumSoin175 (){
        return Calculator.refundCalculator(0.50);
    }
    
    @Override
       double refundForContractNumSoin200 (){
        return Calculator.refundCalculator(0.25);
    }
    
    @Override
       double refundForContractNumSoin300 (){
        return 0;
    }
    
    @Override
       double refundForContractNumSoin400 (){
        return 0;
    }
    
    @Override
       double refundForContractNumSoin500 (){
        return Calculator.refundCalculator(0.25);
    }
    
    @Override
       double refundForContractNumSoin600 (){
        return Calculator.refundCalculator(0.4);
    }
    
    @Override
       double refundForContractNumSoin700 (){
        return 0;
    }
}
