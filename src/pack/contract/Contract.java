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
    private static int numSoin;

    public static int getNumSoin() {
        return numSoin;
    }
    
    static double ammountToReimburseInXmlElementRemboursement = 0;
    
    static double reimbursementCalculation(double multipleToApplyOnAmmountToReimburse, double maxAmmountToReimburse){
        ammountToReimburseInXmlElementRemboursement = ammountInXmlFile * multipleToApplyOnAmmountToReimburse;
                if (ammountToReimburseInXmlElementRemboursement > maxAmmountToReimburse) {
                    ammountToReimburseInXmlElementRemboursement = maxAmmountToReimburse;
                }
        return ammountToReimburseInXmlElementRemboursement;
    }
    
    static double reimbursementCalculation(double multiple){
        return ammountInXmlFile * multiple;
    }

    public static double reimburseCalculationByContractTypeAmmountInXmlElementRemboursementNumSoin(String typeContrat, double montant, int numSoin) {
        setBasicContractInformation (montant, numSoin);
        if (typeContrat.equals("A")) {
            ammountToReimburseInXmlElementRemboursement = ContractA.selectNumSoinContrat();
        }
        if (typeContrat.equals("B")) {
            ammountToReimburseInXmlElementRemboursement = ContractB.selectNumSoinContrat();
        }
        if (typeContrat.equals("C")) {
            ammountToReimburseInXmlElementRemboursement = ContractC.selectNumSoinContratC();
        }
        if (typeContrat.equals("D")) {
            ammountToReimburseInXmlElementRemboursement = ContractD.selectNumSoinContratD();
        }     
        if (typeContrat.equals("E")) {
            ammountToReimburseInXmlElementRemboursement = ContractE.selectNumSoinContratE();
        }
        return roundUpDoubleNumberUpToTwoDecimals(ammountToReimburseInXmlElementRemboursement);
    }
    
    private static void setBasicContractInformation (double montant, int numSoin){
        setAmmount (montant);
        setNumSoin (numSoin);
    }
    
    private static void setAmmount (double montant){
        Contract.ammountInXmlFile = montant;
    }
    
    private static void setNumSoin (int numSoin){
        Contract.numSoin = numSoin;
    }
    
    private static double roundUpDoubleNumberUpToTwoDecimals (double numberToRoudUp){
        double numberRounded = Math.round(numberToRoudUp*100);
        return numberRounded/100;
    }
    
}
