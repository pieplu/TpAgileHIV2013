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
    static double ammountToReimburseInXmlElementRemboursement = 0;
    
    
    public static double reimburseCalculationByContractTypeAmmountInXmlElementRemboursementNumSoin(String typeContrat, double montant, int numSoin) {
        setAmmount(montant);
        if (typeContrat.equals("A")) {
            ContractA yop = new ContractA();
            ammountToReimburseInXmlElementRemboursement = yop.selectNumSoinContrat(numSoin);
        }
        if (typeContrat.equals("B")) {
            ammountToReimburseInXmlElementRemboursement = ContractB.selectNumSoinContrat(numSoin);
        }
        if (typeContrat.equals("C")) {
            ammountToReimburseInXmlElementRemboursement = ContractC.selectNumSoinContrat(numSoin);
        }
        if (typeContrat.equals("D")) {
            ammountToReimburseInXmlElementRemboursement = ContractD.selectNumSoinContrat(numSoin);
        }     
        if (typeContrat.equals("E")) {
            ammountToReimburseInXmlElementRemboursement = ContractE.selectNumSoinContrat(numSoin);
        }
        return roundUpDoubleNumberUpToTwoDecimals(ammountToReimburseInXmlElementRemboursement);
    }
    
    /**
     * PAS ENCORE ANALYSÉ
    */
    static double reimbursementCalculation(double multipleToApplyOnAmmountToReimburse, double maxAmmountToReimburse){
        ammountToReimburseInXmlElementRemboursement = ammountInXmlFile * multipleToApplyOnAmmountToReimburse;
                if (ammountToReimburseInXmlElementRemboursement > maxAmmountToReimburse) {
                    ammountToReimburseInXmlElementRemboursement = maxAmmountToReimburse;
                }
        return ammountToReimburseInXmlElementRemboursement;
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
