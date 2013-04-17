package RefundCalculator;

import InsuranceSoftware.FamilyData;
import InsuranceSoftware.FamilyMemberData;
import InsuranceSoftware.MonthlyMaxRestriction;
import InsuranceSoftware.ValidationRunner;
import Validator.Dollar;

public class Calculator {

    public static FamilyMemberData getJSONArrayObject(int index) {
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
        for (int i = 0; i < MonthlyMaxRestriction.numSoinWithMaximum.length; i++) {
            if (numSoin == (MonthlyMaxRestriction.numSoinWithMaximum[i])) {
                return i;
            }
        }
        return -1;
    }

    public static int refundCalculator(FamilyMemberData reclamation) {
        amountFromJsonFile = formatDollar(reclamation);
        refundForThisReclamation = contractSelector(FamilyMemberData.contractType).selectNumSoinContrat(Integer.parseInt(reclamation.getSoin()));
        refundForThisReclamation = ajustRefundIfCodeH(reclamation);
        int index = getIndexOfMaxAmountForNumSoin(Integer.parseInt(reclamation.getSoin()));
        if (index >= 0) {
            setFamilyMemberMonthlyMax(reclamation.getIndexFamilyMember(), index);
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

    private static int ajustRefundIfCodeH(FamilyMemberData reclamation) {
        if (reclamation.contractType.equals("H")) {
            return refundForThisReclamation / 2;
        } else {
            return refundForThisReclamation;
        }
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

    private static int formatDollar(FamilyMemberData reclamation) {
        String amountWithoutDollarSign = reclamation.getMontant().substring(0, reclamation.getMontant().length() - 1);
        amountWithoutDollarSign = Dollar.removeDotAndCommaFromString(amountWithoutDollarSign);
        int amountAsIntegers = Dollar.returnDollarValueInCents(amountWithoutDollarSign);
        return amountAsIntegers;
    }

    private static void setFamilyMemberMonthlyMax(int indexFamilyMember, int index) {
        if (!FamilyData.familyMembersMonthlyMaxList.get(indexFamilyMember).isMonthlyMaxAttained[index]) {
            ajustToMonthlyMax(indexFamilyMember, index);
        } else {
            refundForThisReclamation = 0;
        }
        FamilyData.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index] += refundForThisReclamation;
    }

    private static void ajustToMonthlyMax(int indexFamilyMember, int index) {
        if ((FamilyData.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index] + refundForThisReclamation) > MonthlyMaxRestriction.monthlyMaxForEachNumSoin[index]) {
            refundForThisReclamation = MonthlyMaxRestriction.monthlyMaxForEachNumSoin[index] - FamilyData.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index];
            FamilyData.familyMembersMonthlyMaxList.get(indexFamilyMember).isMonthlyMaxAttained[index] = true;
        }
    }
}
