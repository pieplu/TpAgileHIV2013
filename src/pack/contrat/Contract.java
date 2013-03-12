/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;
/**
 *
 * @author Dominique Ménard
 */
public class Contract {
    
    static double ammountInXmlFile;
    static int numSoin;
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
            ammountToReimburseInXmlElementRemboursement = ContractA.selectNumSoinContratA();
        }
        if (typeContrat.equals("B")) {
            ammountToReimburseInXmlElementRemboursement = ContractB.selectNumSoinContratB();
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
        ammountInXmlFile (montant);
        setNumSoin (numSoin);
    }
    
    private static void ammountInXmlFile (double montant){
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
