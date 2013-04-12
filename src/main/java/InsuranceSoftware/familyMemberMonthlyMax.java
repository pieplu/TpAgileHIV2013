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

   
    public void setRefundDollarForThisMonth(int index, int amount) {
        refundDollarForThisMonth[index] = amount;
    }
    public boolean[] isMonthlyMaxAttained = new boolean[]{false, false, false, false, false};
    
    public void setIsMonthlyMaxAttained(int index, boolean isAttained) {
        isMonthlyMaxAttained[index] = isAttained;
    }
    
    
    
}
