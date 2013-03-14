package RefundCalculator;

public class Calculator {
    
    private static double amountInXmlFile; 
    private static double amountToRefund = 0;
    private static double amountTotal = 0;
    
    
    public static double getAmountInXmlFile() {
        return amountInXmlFile;
    }

    public static double getAmountTotal() {
        return amountTotal;
    }
    
      private static void setAmount (double montant){
        amountInXmlFile = montant;
    } 
    
    public static double refundCalculator(String contractType, double amount, int numSoin) {
        setAmount(amount);
        amountToRefund = contractSelector(contractType).selectNumSoinContrat(numSoin);
        amountToRefund = roundUpDoubleNumberUpToTwoDecimals(amountToRefund);
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
    

    static double refundCalculator(double multipleToApplyOnAmmountToReimburse, double maxAmountToReimburse){
        amountToRefund = amountInXmlFile * multipleToApplyOnAmmountToReimburse;
                if (amountToRefund > maxAmountToReimburse) {
                    amountToRefund = maxAmountToReimburse;
                }
        return amountToRefund;
    }
    
    
    static double refundCalculator(double multiple){
        return amountInXmlFile * multiple;
    }
    

    private static double roundUpDoubleNumberUpToTwoDecimals (double numberToRoudUp){
        double numberRounded = Math.round(numberToRoudUp*100);
        return numberRounded/100;
    }
    
}
