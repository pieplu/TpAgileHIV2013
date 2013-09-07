/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsuranceSoftware;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author ff291104
 */
public class FamilyDataTest {
    
    @Test
    public void testRefundCalculator_int() {
        FamilyMemberData member = new FamilyMemberData("100", "2000", "A","A");
        FamilyData.setAndCreateMonthlyMaxDependingOnNumSoin(member);
        assertTrue(FamilyData.familyCodeList.size() == 1 && FamilyData.familyMembersMonthlyMaxList.size() == 1);
    }
}
