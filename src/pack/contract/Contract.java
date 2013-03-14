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
    
    public static double refundCalculator(String contractType, double amount, int numSoin) {
        setAmmount(amount);
        if (contractType.equals("A")) {
            ContractA InstanceOfContact = new ContractA();
            amountToRefund = InstanceOfContact.selectNumSoinContrat(numSoin);
        }
        if (contractType.equals("B")) {
            ContractB InstanceOfContact = new ContractB();
            amountToRefund = InstanceOfContact.selectNumSoinContrat(numSoin);
        }
        if (contractType.equals("C")) {
            ContractC InstanceOfContact = new ContractC();
            amountToRefund = InstanceOfContact.selectNumSoinContrat(numSoin);
        }
        if (contractType.equals("D")) {
            ContractD InstanceOfContact = new ContractD();
            amountToRefund = InstanceOfContact.selectNumSoinContrat(numSoin);
        }     
        if (contractType.equals("E")) {
            ContractE InstanceOfContact = new ContractE();
            amountToRefund = InstanceOfContact.selectNumSoinContrat(numSoin);
        }
        
        amountToRefund = roundUpDoubleNumberUpToTwoDecimals(amountToRefund);
        amountTotal += amountToRefund;
        
        return amountToRefund;
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
    
    
    private static void setAmmount (double montant){
        ammountInXmlFile = montant;
    }  

    
    private static double roundUpDoubleNumberUpToTwoDecimals (double numberToRoudUp){
        double numberRounded = Math.round(numberToRoudUp*100);
        return numberRounded/100;
    }
    
}
