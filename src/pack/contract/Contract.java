/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;
/**
 *
 * @author Dominique Ménard
 */
public class Contract {
    
    private static double ammountInXmlFile; 
    private static double amountToRefund = 0;
    private static double amountTotal = 0;
    
    
    public static double getAmmountInXmlFile() {
        return ammountInXmlFile;
    }

    public static double getAmountTotal() {
        return amountTotal;
    }
    
      private static void setAmmount (double montant){
        ammountInXmlFile = montant;
    } 
    
    public static double refundCalculator(String contractType, double amount, int numSoin) {
        setAmmount(amount);
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
    

    static double reimbursementCalculation(double multipleToApplyOnAmmountToReimburse, double maxAmmountToReimburse){
        amountToRefund = ammountInXmlFile * multipleToApplyOnAmmountToReimburse;
                if (amountToRefund > maxAmmountToReimburse) {
                    amountToRefund = maxAmmountToReimburse;
                }
        return amountToRefund;
    }
    
    
    static double reimbursementCalculation(double multiple){
        return ammountInXmlFile * multiple;
    }
    

    private static double roundUpDoubleNumberUpToTwoDecimals (double numberToRoudUp){
        double numberRounded = Math.round(numberToRoudUp*100);
        return numberRounded/100;
    }
    
}
