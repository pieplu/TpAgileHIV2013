package RefundCalculator;

public class ContractD extends ContractTemplate {

    @Override
    int refundForContractNumSoin0() {
        return Calculator.refundCalculator(100, 85);
    }

    @Override
    int refundForContractNumSoin100() {
        return Calculator.refundCalculator(100, 75);
    }

    @Override
    int refundForContractNumSoin150() {
        return Calculator.refundCalculator(100, 150);
    }

    @Override
    int refundForContractNumSoin175() {
        return Calculator.refundCalculator(95);
    }

    @Override
    int refundForContractNumSoin200() {
        return Calculator.refundCalculator(100, 100);
    }

    @Override
    int refundForContractNumSoin300() {
        return Calculator.refundCalculator(100);
    }

    @Override
    int refundForContractNumSoin400() {
        return Calculator.refundCalculator(100, 65);
    }

    @Override
    int refundForContractNumSoin500() {
        return Calculator.refundCalculator(100);
    }

    @Override
    int refundForContractNumSoin600() {
        return Calculator.refundCalculator(100, 100);
    }

    @Override
    int refundForContractNumSoin700() {
        return Calculator.refundCalculator(100, 90);
    }
}
