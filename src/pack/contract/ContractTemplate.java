/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

/**
 *
 * @author hj991118
 */
public class ContractTemplate extends Contract{
    
   
    
 static double selectNumSoinContrat() {
        if(getNumSoin()==0){reimbursementCalculationForContractNumSoin0 ();}
        if(getNumSoin()==100){reimbursementCalculationForContractNumSoin100 ();}
        if(getNumSoin()==150){reimbursementCalculationForContractNumSoin150 ();}
        if(getNumSoin()==175){reimbursementCalculationForContractNumSoin175 ();}
        if(getNumSoin()==200){reimbursementCalculationForContractNumSoin200 ();}
        if(getNumSoin()>=300 && getNumSoin()<=399){reimbursementCalculationForContractNumSoin300 ();}
        if(getNumSoin()==400){reimbursementCalculationForContractNumSoin400 ();}
        if(getNumSoin()==500){reimbursementCalculationForContractNumSoin500 ();}
        if(getNumSoin()==600){reimbursementCalculationForContractNumSoin600 ();}
        if(getNumSoin()==700){reimbursementCalculationForContractNumSoin700 ();}
        return ammountToReimburseInXmlElementRemboursement;
    }
 
 
 
    static double reimbursementCalculationForContractNumSoin0 (){
        return ammountToReimburseInXmlElementRemboursement = Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractNumSoin100 (){
        return ammountToReimburseInXmlElementRemboursement = Contract.reimbursementCalculation(0.35);
    }
    
    static double reimbursementCalculationForContractNumSoin150 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0);
    }
    
    static double reimbursementCalculationForContractNumSoin175 (){
        return ammountToReimburseInXmlElementRemboursement = reimbursementCalculation(0.50);
    }
    
    static double reimbursementCalculationForContractNumSoin200 (){
        return ammountToReimburseInXmlElementRemboursement = Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractNumSoin300 (){
        return 0;
    }
    
    static double reimbursementCalculationForContractNumSoin400 (){
        return 0;
    }
    
    static double reimbursementCalculationForContractNumSoin500 (){
        return ammountToReimburseInXmlElementRemboursement = Contract.reimbursementCalculation(0.25);
    }
    
    static double reimbursementCalculationForContractNumSoin600 (){
        return ammountToReimburseInXmlElementRemboursement = ammountInXmlFile * 0.4;
    }
    
    static double reimbursementCalculationForContractNumSoin700 (){
        return 0;
    }
}
