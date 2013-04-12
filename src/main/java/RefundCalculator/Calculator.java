package RefundCalculator;

import InsuranceSoftware.JSONArrayObject;
import InsuranceSoftware.ValidationRunner;
import Validator.Dollar;
import java.util.ArrayList;

public class Calculator {
    
    public static JSONArrayObject getJSONArrayObject(int index) {
        return ValidationRunner.listOfAllReclamations.get(index);
    }

    private static int amountFromJsonFile;
    private static int amountToRefund = 0;
    private static int refundForThisReclamation = 0;
    private static int sumOfAllReclamations = 0;
    
    //                 CHARTE GRAPHIQUE DES TABLEAUX 
    //NumSoin:                          100   175    200   500    600 
    //Monthly maximum for each numSoin 25000 20000  25000 15000  30000 
     
    final private static int[] numSoinWithMaximum = new int[]{100, 175, 200, 500, 600};
    final private static int[] monthlyMaxForEachNumSoin = new int[]{25000, 20000, 25000, 15000, 30000};

    
    
    public static String getSumOfAllReclamations(){
        return Dollar.formatAmountToStandardFormat(sumOfAllReclamations);
    }

    static int getIndexOfMaxAmountForNumSoin(int numSoin) {
        for (int i = 0; i < numSoinWithMaximum.length; i++) {
            if (numSoin == numSoinWithMaximum[i]) {
                return i;
            }
        }
        return -1;
    }
    
    

    public static int refundCalculator(String contractType, int dollar, int numSoin, int client) {
        System.out.println(getJSONArrayObject(client));
        int index = getIndexOfMaxAmountForNumSoin(numSoin);
        amountFromJsonFile = dollar;
        refundForThisReclamation = contractSelector(contractType).selectNumSoinContrat(numSoin);
        if(getJSONArrayObject(client).getCode().substring(0,1).equals("H")){
                refundForThisReclamation = refundForThisReclamation/2;
            }
        
        if (index >= 0) {
            if (!getJSONArrayObject(client).isMonthlyMaxAttained[index]) {
                 refundForThisReclamation  = contractSelector(contractType).selectNumSoinContrat(numSoin);
                 if ( (getJSONArrayObject(client).refundDollarForThisMonth[index] + refundForThisReclamation) > monthlyMaxForEachNumSoin[index] ){
                      refundForThisReclamation = monthlyMaxForEachNumSoin[index] - getJSONArrayObject(client).refundDollarForThisMonth[index];
                      getJSONArrayObject(client).setIsMonthlyMaxAttained(index, true);
                    }
            }else{
                  refundForThisReclamation = 0;   
                 } 
            
            
           getJSONArrayObject(client).setRefundDollarForThisMonth(index, refundForThisReclamation +  getJSONArrayObject(client).refundDollarForThisMonth[index]); 
            System.out.println(getJSONArrayObject(client).refundDollarForThisMonth[index]);
        } 
         sumOfAllReclamations += refundForThisReclamation;  
            
        return refundForThisReclamation;
    }

    private static ContractTemplate contractSelector(String contractType) {
        ContractTemplate InstanceOfContract = new ContractTemplate();
        if (contractType.equals("A")) {
            InstanceOfContract = new ContractA();
        }
        if (contractType.equals("B")) {
            InstanceOfContract = new ContractB();
        }
        if (contractType.equals("C")) {
            InstanceOfContract = new ContractC();
        }
        if (contractType.equals("D")) {
            InstanceOfContract = new ContractD();
        }
        if (contractType.equals("E")) {
            InstanceOfContract = new ContractE();
        }
        return InstanceOfContract;
    }

    static int refundCalculator(int multipleToApplyOnAmountToRefund, int maxAmountToRefund) {
        amountToRefund = (amountFromJsonFile * multipleToApplyOnAmountToRefund) / 100;
        if (amountToRefund > (maxAmountToRefund * 100)) {
            amountToRefund = maxAmountToRefund * 100;
        }
        return amountToRefund;
    }

    static int refundCalculator(int multiple) {
        return (amountFromJsonFile * multiple) / 100;
    }
}
