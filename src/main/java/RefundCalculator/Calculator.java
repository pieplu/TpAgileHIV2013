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
    private static int amountFromJsonFile = 0;
    private static int amountToRefund = 0;
    private static int refundForThisReclamation = 0;
    private static int sumOfAllReclamations = 0;
    

    public static String getSumOfAllReclamations() {
        return Dollar.formatAmountToStandardFormat(sumOfAllReclamations);
    }

    static int getIndexOfMaxAmountForNumSoin(int numSoin) {
        for (int i = 0; i < familyMemberMonthlyMax.numSoinWithMaximum.length; i++) {
            if (numSoin == (familyMemberMonthlyMax.numSoinWithMaximum[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int refundCalculator(JSONArrayObject reclamation) {
        amountFromJsonFile = formatDollar(reclamation);
        refundForThisReclamation = contractSelector(JSONArrayObject.contractType).selectNumSoinContrat(Integer.parseInt(reclamation.getSoin()));
        refundForThisReclamation = ajustRefundIfCodeH(reclamation);
        int index = getIndexOfMaxAmountForNumSoin(Integer.parseInt(reclamation.getSoin()));
        int indexFamilyMember = familyMemberMonthlyMax.getFamilyMembersMonthlyMaxIndex(reclamation.getCode());
        if (index >= 0) {
            setFamilyMemberMonthlyMax(indexFamilyMember, index);
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

    private static int ajustRefundIfCodeH(JSONArrayObject reclamation) {
        if (reclamation.contractType.equals("H")) {
            return refundForThisReclamation / 2;
        } else {
            return refundForThisReclamation;
        }
    }

   

    private static void setFamilyMemberMonthlyMax(int indexFamilyMember, int index) {
        if (!familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).isMonthlyMaxAttained[index]) {
            ajustToMonthlyMax(indexFamilyMember, index);
        } else {
            refundForThisReclamation = 0;
        }
        familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index] += refundForThisReclamation;
    }
    
     private static void ajustToMonthlyMax(int indexFamilyMember, int index) {
        if ((familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index] + refundForThisReclamation) > familyMemberMonthlyMax.monthlyMaxForEachNumSoin[index]) {
            refundForThisReclamation = familyMemberMonthlyMax.monthlyMaxForEachNumSoin[index] - familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index];
            familyMemberMonthlyMax.familyMembersMonthlyMaxList.get(indexFamilyMember).isMonthlyMaxAttained[index] = true;
        }
    }
}
