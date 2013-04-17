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
public class MonthlyMaxRestriction {

    final public static int[] numSoinWithMaximum = new int[]{100, 175, 200, 500, 600};
    final public static int[] monthlyMaxForEachNumSoin = new int[]{25000, 20000, 25000, 15000, 30000};
    //Each array slot corresponds to a specific numSoin for a specific family member
    public int[] refundDollarForThisMonth = new int[]{0, 0, 0, 0, 0};
    public boolean[] isMonthlyMaxAttained = new boolean[]{false, false, false, false, false};

    public static void setRefundDollarForThisMonth(int index, int indexFamilyMember, int amount) {
        FamilyData.familyMembersMonthlyMaxList.get(indexFamilyMember).refundDollarForThisMonth[index] = amount;
    }

    public static void setIsMonthlyMaxAttained(int index, int indexFamilyMember, boolean isAttained) {
        FamilyData.familyMembersMonthlyMaxList.get(indexFamilyMember).isMonthlyMaxAttained[index] = isAttained;
    }
}
