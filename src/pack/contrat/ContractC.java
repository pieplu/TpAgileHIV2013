/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

/**
 *
 * @author Dominique Menard
 */
public class ContractC extends Contract {

    static double selectNumSoinContratC() {
        if (numSoin == 100) {reimbursementCalculationForContractCnumSoin100();}
        if (numSoin == 150) {reimbursementCalculationForContractCnumSoin150();}
        if(numSoin==600)    {reimbursementCalculationForContractCnumSoin600 ();}
        else {
            return ammountToReimburseInXmlElementRemboursement = ammountInXmlFile * 0.9;
        }
        return ammountToReimburseInXmlElementRemboursement;
    }

    static double reimbursementCalculationForContractCnumSoin100() {
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.95);
    }

    static double reimbursementCalculationForContractCnumSoin150() {
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.85);
    }
    
    static double reimbursementCalculationForContractCnumSoin600 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.75);
    }
}
