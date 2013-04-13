/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsuranceSoftware;

import java.util.ArrayList;

/**
 *
 * @author Mathieu Latour
 */
public class familyMemberMonthlyMax {

    public static ArrayList<familyMemberMonthlyMax> familyMembersMonthlyMaxList;
    public static ArrayList<String> familyCodeList;

    
    //Refund made for this month:        0     0      0     0      0
    //Maximum for month attained:      false false  false false  false
    public int[] refundDollarForThisMonth = new int[]{0, 0, 0, 0, 0};

    public static void setAllFamilyMembersMonthlyMaxReference() {
        for (int i = 0; i < ValidationRunner.listOfAllReclamations.size(); i++) {
            if (!familyCodeList.contains(ValidationRunner.listOfAllReclamations.get(i).getCode())) {
                familyCodeList.add(ValidationRunner.listOfAllReclamations.get(i).getCode());
                ValidationRunner.listOfAllReclamations.get(i).setMonthlyMaxReference(new familyMemberMonthlyMax());
            } else {
                ValidationRunner.listOfAllReclamations.get(i).setMonthlyMaxReference(findMonthlyMaxReference(ValidationRunner.listOfAllReclamations.get(i).getCode()));
            }
        }
    }
    
    private static familyMemberMonthlyMax findMonthlyMaxReference(String code) {
        for (int j = 0; j < ValidationRunner.listOfAllReclamations.size(); j++) {
            if (code.equals(ValidationRunner.listOfAllReclamations.get(j).getCode())) {
                return ValidationRunner.listOfAllReclamations.get(j).getMonthlyMaxReference();
            }
        }
        return null;
    }

    public void setRefundDollarForThisMonth(int index, int amount) {
        refundDollarForThisMonth[index] = amount;
    }
    public boolean[] isMonthlyMaxAttained = new boolean[]{false, false, false, false, false};

    public void setIsMonthlyMaxAttained(int index, boolean isAttained) {
        isMonthlyMaxAttained[index] = isAttained;
    }
}
