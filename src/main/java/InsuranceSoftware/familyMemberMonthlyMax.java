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

    public static ArrayList<familyMemberMonthlyMax> familyMembersMonthlyMaxList = new ArrayList<familyMemberMonthlyMax>();
    public static ArrayList<String> familyCodeList = new ArrayList<String>();
    
    final public static int[] numSoinWithMaximum = new int[]{100, 175, 200, 500, 600};
    final public static int[] monthlyMaxForEachNumSoin = new int[]{25000, 20000, 25000, 15000, 30000};
    
    //Each array slot corresponds to a specific numSoin for a specific family member
    public int[] refundDollarForThisMonth = new int[]{0, 0, 0, 0, 0};
    public boolean[] isMonthlyMaxAttained = new boolean[]{false, false, false, false, false};

    public static void setFamilyMembersMonthlyMaxReference(JSONArrayObject reclamation) {
        if (!familyCodeList.contains(reclamation.getCode())) {
            familyCodeList.add(reclamation.getCode());
            familyMembersMonthlyMaxList.add(new familyMemberMonthlyMax());
        }
    }

    public static int getFamilyMembersMonthlyMaxIndex(String code) {
        for (int i = 0; i < familyCodeList.size(); i++) {
            if (code.equals(familyCodeList.get(i))) {
                return i;
            }
        }
        return 0;

    }

    public static void setRefundDollarForThisMonth(int index,int indexFamilyMember, int amount) {
        familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index] = amount;
    }

    public static void setIsMonthlyMaxAttained(int index, int indexFamilyMember,  boolean isAttained) {
        familyMembersMonthlyMaxList.get(indexFamilyMember).isMonthlyMaxAttained[index] = isAttained;
    }
}
