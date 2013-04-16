package RefundCalculator;

import InsuranceSoftware.JSONArrayObject;
import InsuranceSoftware.ValidationRunner;
import InsuranceSoftware.familyMemberMonthlyMax;
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

    public static String getSumOfAllReclamations() {
        return Dollar.formatAmountToStandardFormat(sumOfAllReclamations);
    }

    static int getIndexOfMaxAmountForNumSoin(int numSoin) {
        for (int i = 0; i < numSoinWithMaximum.length; i++) {
            if (numSoin == (numSoinWithMaximum[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int refundCalculator(JSONArrayObject reclamation) {
        amountFromJsonFile = formatDollar(reclamation);
        int index = getIndexOfMaxAmountForNumSoin(Integer.parseInt(reclamation.getSoin()));
        refundForThisReclamation = contractSelector(JSONArrayObject.contractType).selectNumSoinContrat(Integer.parseInt(reclamation.getSoin()));
        
        int indexFamilyMember = familyMemberMonthlyMax.getFamilyMembersMonthlyMaxIndex(reclamation.getCode());
        if (index >= 0) {
            if (!familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).isMonthlyMaxAttained[index]) {
                refundForThisReclamation = contractSelector(reclamation.contractType).selectNumSoinContrat(Integer.parseInt(reclamation.getSoin()));
                if (reclamation.getCode().substring(0, 1).equals("H")) {
                    refundForThisReclamation = refundForThisReclamation / 2;
                }
                if ((familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index] + refundForThisReclamation) > monthlyMaxForEachNumSoin[index]) {
                    refundForThisReclamation = monthlyMaxForEachNumSoin[index] - familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index];
                    familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).isMonthlyMaxAttained[index] = true;
                }
                
            } else {
                refundForThisReclamation = 0;
            }


            familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index] += refundForThisReclamation;
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

    private static int formatDollar(JSONArrayObject reclamation) {
        String amountWithoutDollarSign = reclamation.getMontant().substring(0, reclamation.getMontant().length() - 1);
        amountWithoutDollarSign = Dollar.removeDotAndCommaFromString(amountWithoutDollarSign);
        int amountAsIntegers = Dollar.returnDollarValueInCents(amountWithoutDollarSign);
        return amountAsIntegers;
    }
}
