package RefundCalculator;

public class Calculator {

    private static int amountInXmlFile;
    private static int amountToRefund = 0;
    private static int amountTotal = 0;
    
    
    //NumSoin:                          100   175    200   500    600 
    //Monthly maximum for each numSoin 25000 20000  25000 15000  30000 
    //Refund made for this month:        0     0      0     0      0
    //Maximum for month attained:      false false  false false  false
     
    final private static int[] numSoinWithMaximum = new int[]{100, 175, 200, 500, 600};
    final private static int[] monthlyMaxForEachNumSoin = new int[]{25000, 20000, 25000, 15000, 30000};
    private static int[] refundDollarForThisMonth = new int[]{0, 0, 0, 0, 0};
    private static boolean[] isMonthlyMaxAttained = new boolean[]{false, false, false, false, false};

    public static int getAmountInXmlFile() {
        return amountInXmlFile;
    }

    public static int getAmountTotal() {
        return amountTotal;
    }

    private static void setDollar(int dollar) {
        amountInXmlFile = dollar;
    }

    private static int getIndexOfMaxAmountForNumSoin(int numSoin) {
        for (int i = 0; i < numSoinWithMaximum.length; i++) {
            if (numSoin == numSoinWithMaximum[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int getNumSoinMaxAmount(int index) {
        return monthlyMaxForEachNumSoin[index];
    }

    private static int getRefundDollarForThisMonth(int index) {
        return refundDollarForThisMonth[index];
    }

    public static int refundCalculator(String contractType, int dollar, int numSoin) {
        setDollar(dollar);
        int index = getIndexOfMaxAmountForNumSoin(numSoin);
        if (index >= 0) {
            if (!isMonthlyMaxAttained[index]) {
                if(){
                    
                }
                }else{
            } else {
                return 0;
            } else {
                amountToRefund = contractSelector(contractType).selectNumSoinContrat(numSoin);
                amountTotal += amountToRefund;
                return amountToRefund;
            }
        } else {

            amountToRefund = contractSelector(contractType).selectNumSoinContrat(numSoin);
            amountTotal += amountToRefund;
        }
        return amountToRefund;
    }

    private static ContractTemplate contractSelector(String contractType) {
        ContractTemplate InstanceOfContract = new ContractTemplate();
        if (contractType.equals("A")) {
            InstanceOfContract = new ContractA();
        }
        if (contractType.equals("B")) {
            InstanceOfContract = new ContractB();
        }
        if (contractType.equals("C")) {
            InstanceOfContract = new ContractC();
        }
        if (contractType.equals("D")) {
            InstanceOfContract = new ContractD();
        }
        if (contractType.equals("E")) {
            InstanceOfContract = new ContractE();
        }
        return InstanceOfContract;
    }

    static int refundCalculator(int multipleToApplyOnAmountToRefund, int maxAmountToRefund) {
        amountToRefund = (amountInXmlFile * multipleToApplyOnAmountToRefund) / 100;
        if (amountToRefund > (maxAmountToRefund * 100)) {
            amountToRefund = maxAmountToRefund * 100;
        }
        return amountToRefund;
    }

    static int refundCalculator(int multiple) {
        return (amountInXmlFile * multiple) / 100;
    }
}
