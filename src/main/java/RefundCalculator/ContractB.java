package RefundCalculator;

public class ContractB extends ContractTemplate {

    @Override
    int refundForContractNumSoin0() {
        return Calculator.refundCalculator(50, 40);
    }

    @Override
    int refundForContractNumSoin100() {
        return Calculator.refundCalculator(50, 50);
    }

    @Override
    int refundForContractNumSoin150() {
        return Calculator.refundCalculator(0);
    }

    @Override
    int refundForContractNumSoin175() {
        return Calculator.refundCalculator(75);
    }

    @Override
    int refundForContractNumSoin200() {
        return Calculator.refundCalculator(100);
    }

    @Override
    int refundForContractNumSoin300() {
        return Calculator.refundCalculator(50);
    }

    @Override
    int refundForContractNumSoin400() {
        return 0;
    }

    @Override
    int refundForContractNumSoin500() {
        return Calculator.refundCalculator(50, 50);
    }

    @Override
    int refundForContractNumSoin600() {
        return Calculator.refundCalculator(100);
    }

    @Override
    int refundForContractNumSoin700() {
        return Calculator.refundCalculator(70);
    }
}
