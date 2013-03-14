package RefundCalculator;

public class ContractD extends ContractTemplate{
    

    
    @Override
     double refundForContractNumSoin0 (){
        return  Calculator.refundCalculator(1,85);
    }
    
    @Override
     double refundForContractNumSoin100 (){
        return  Calculator.refundCalculator(1,75);
    }
    
    @Override
     double refundForContractNumSoin150 (){
        return  Calculator.refundCalculator(1,150);
    }
    
    @Override
     double refundForContractNumSoin175 (){
        return  Calculator.refundCalculator(0.95);
    }
    
    @Override
     double refundForContractNumSoin200 (){
        return  Calculator.refundCalculator(1,100);
    }
    
    @Override
     double refundForContractNumSoin300 (){
        return  Calculator.getAmountInXmlFile();
    }
    
    @Override
     double refundForContractNumSoin400 (){
        return  Calculator.refundCalculator(1,65);
    }
    
    @Override
     double refundForContractNumSoin500 (){
        return  Calculator.refundCalculator(1);
    }
    
    @Override
     double refundForContractNumSoin600 (){
        return  Calculator.refundCalculator(1,100);
    }
    
    @Override
     double refundForContractNumSoin700 (){
        return  Calculator.refundCalculator(1,90);
    }
    
}
