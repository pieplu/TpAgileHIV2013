package RefundCalculator;

public class Calculator {
    
    private static int amountInXmlFile; 
    private static int amountToRefund = 0;
    private static int amountTotal = 0;
     
    final private static int[] numSoinWithMaximum = new int[] {100,175,200,500,600}; 
    final private static int[] numSoinMaximum = new int[] {25000,20000,25000,15000,30000};
    private static int[] maximum = new int[] {0,0,0,0,0};
    
    public static int getAmountInXmlFile() {
        return amountInXmlFile;
    }

    public static int getAmountTotal() {
        return amountTotal;
    }
    
      private static void setAmount (int montant){
        amountInXmlFile = montant;
    }
      
       private static boolean doesNumSoinHasMaxAmount(int numSoin){
        for (int i = 0 ; i < numSoinWithMaximum.length; i++)
            if (numSoin == numSoinWithMaximum[i])
                return true;
        return false;
      }
      

      private static int getNumSoinMaxAmount(int numSoin){
        
        for (int i = 0 ; i < numSoinWithMaximum.length; i++)
            if (numSoin == numSoinWithMaximum[i])
                return numSoinMaximum[i];
       
        return 0;
      }
      
      
      private static int getMaxTemp(int numSoin){
          for (int i = 0 ; i < numSoinMaximum.length; i++)
            if (numSoin == numSoinWithMaximum[i])
                return maximum[i];
       
        return 0;
      }
     
      
    public static int refundCalculator(String contractType, int amount, int numSoin) {
        setAmount(amount);
        amountToRefund = contractSelector(contractType).selectNumSoinContrat(numSoin);
        if(amountToRefund + getMaxTemp(numSoin) >= getNumSoinMaxAmount(numSoin) ){
    
    }
        
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
