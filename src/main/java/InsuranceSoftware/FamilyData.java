package InsuranceSoftware;

import java.util.ArrayList;

public class FamilyData {

    public static String month;
    public static String fileNumber;
    public static String contractType;
    public static ArrayList<MonthlyMaxRestriction> familyMembersMonthlyMaxList = new ArrayList<MonthlyMaxRestriction>();
    public static ArrayList<String> familyCodeList = new ArrayList<String>();

    public static void setAndCreateMonthlyMaxDependingOnNumSoin(FamilyMemberData reclamation) {
        if (!familyCodeList.contains(reclamation.getCode())) {
            createMonthlyMaxRestrictionForThisFamilyMember(reclamation);
        }
        reclamation.setIndexFamilyMember(reclamation.getCode());
    }

    private static void createMonthlyMaxRestrictionForThisFamilyMember(FamilyMemberData reclamation) {
        familyCodeList.add(reclamation.getCode());
        familyMembersMonthlyMaxList.add(new MonthlyMaxRestriction());
    }
}
