package RefundCalculator;

public class Calculator {
    
    private static int amountInXmlFile; 
    private static int amountToRefund = 0;
    private static int amountTotal = 0;
    
    
    public static int getAmountInXmlFile() {
        return amountInXmlFile;
    }

    public static int getAmountTotal() {
        return amountTotal;
    }
    
      private static void setAmount (int montant){
        amountInXmlFile = montant;
    } 
    
    public static int refundCalculator(String contractType, int amount, int numSoin) {
        setAmount(amount);
        amountToRefund = (int) contractSelector(contractType).selectNumSoinContrat(numSoin);
        amountTotal += amountToRefund;
        return amountToRefund;
    }

    private static ContractTemplate contractSelector(String contractType) {
        ContractTemplate InstanceOfContract = new ContractTemplate();
        if (contractType.equals("A")) {InstanceOfContract = new ContractA();}
        if (contractType.equals("B")) {InstanceOfContract = new ContractB();}
        if (contractType.equals("C")) {InstanceOfContract = new ContractC();}
        if (contractType.equals("D")) {InstanceOfContract = new ContractD();}     
        if (contractType.equals("E")) {InstanceOfContract = new ContractE();}
        return InstanceOfContract;
    }
    

    static int refundCalculator(int multipleToApplyOnAmountToRefund, int maxAmountToRefund){
        amountToRefund = (amountInXmlFile * multipleToApplyOnAmountToRefund) / 100;
                if (amountToRefund > (maxAmountToRefund*100) ) {
                    amountToRefund = maxAmountToRefund*100;
                }
        return amountToRefund;
    }
    
    
    static int refundCalculator(int multiple){
        return (amountInXmlFile * multiple) /100;
    }
    

    
    
}
