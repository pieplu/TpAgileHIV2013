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
    
    static double ammountInXmlFile; 
    static double ammountToReimburse = 0;
    
    
    public static double reimburseCalculationByContractTypeAmmountInXmlElementRemboursementNumSoin(String typeContrat, double montant, int numSoin) {
        setAmmount(montant);
        if (typeContrat.equals("A")) {
            ContractA InstenceOfContact = new ContractA();
            ammountToReimburse = InstenceOfContact.selectNumSoinContrat(numSoin);
        }
        if (typeContrat.equals("B")) {
            ContractB InstenceOfContact = new ContractB();
            ammountToReimburse = InstenceOfContact.selectNumSoinContrat(numSoin);
        }
        if (typeContrat.equals("C")) {
            ContractC InstenceOfContact = new ContractC();
            ammountToReimburse = InstenceOfContact.selectNumSoinContrat(numSoin);
        }
        if (typeContrat.equals("D")) {
            ContractD InstenceOfContact = new ContractD();
            ammountToReimburse = InstenceOfContact.selectNumSoinContrat(numSoin);
        }     
        if (typeContrat.equals("E")) {
            ContractE InstenceOfContact = new ContractE();
            ammountToReimburse = InstenceOfContact.selectNumSoinContrat(numSoin);
        }
        return roundUpDoubleNumberUpToTwoDecimals(ammountToReimburse);
    }
    
    /**
     * PAS ENCORE ANALYSÉ
    */
    static double reimbursementCalculation(double multipleToApplyOnAmmountToReimburse, double maxAmmountToReimburse){
        ammountToReimburse = ammountInXmlFile * multipleToApplyOnAmmountToReimburse;
                if (ammountToReimburse > maxAmmountToReimburse) {
                    ammountToReimburse = maxAmmountToReimburse;
                }
        return ammountToReimburse;
    }
    
    
    static double reimbursementCalculation(double multiple){
        System.out.println("calcul " + ammountInXmlFile);
        return ammountInXmlFile * multiple;
    }
    

    
    
    
    private static void setAmmount (double montant){
        ammountInXmlFile = montant;
        System.out.println("set ammount" + ammountInXmlFile);
    }  

    
    private static double roundUpDoubleNumberUpToTwoDecimals (double numberToRoudUp){
        double numberRounded = Math.round(numberToRoudUp*100);
        return numberRounded/100;
    }
    
}
