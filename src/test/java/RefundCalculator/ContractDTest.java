/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RefundCalculator;

import InsuranceSoftware.FamilyMemberData;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author utilisateur
 */
public class ContractDTest {

    private Calculator mock;

    @Test
    public void testRefundForContractNumSoin0() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "50.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin0(), 5000);
    }

    @Test
    public void testRefundForContractNumSoin0Max() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin0(), 8500);
    }

    @Test
    public void testRefundForContractNumSoin100() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "50.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin100(), 5000);
    }

    @Test
    public void testRefundForContractNumSoin100Max() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin100(), 7500);
    }

    @Test
    public void testRefundForContractNumSoin150() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin150(), 10000);
    }

    @Test
    public void testRefundForContractNumSoin150Max() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "200.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin150(), 15000);
    }

    @Test
    public void testRefundForContractNumSoin175() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin175(), 9500);
    }

    @Test
    public void testRefundForContractNumSoin200() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "90.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin200(), 9000);
    }

    @Test
    public void testRefundForContractNumSoin200Max() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "200.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin200(), 10000);
    }

    @Test
    public void testRefundForContractNumSoin300() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin300(), 10000);
    }

    @Test
    public void testRefundForContractNumSoin400() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "50.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin400(), 5000);
    }

    @Test
    public void testRefundForContractNumSoin400Max() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin400(), 6500);
    }

    @Test
    public void testRefundForContractNumSoin500() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "80.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin500(), 8000);
    }

    @Test
    public void testRefundForContractNumSoin600() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "90.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin600(), 9000);
    }

    @Test
    public void testRefundForContractNumSoin600Max() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "200.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin600(), 10000);
    }

    @Test
    public void testRefundForContractNumSoin700() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "50.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin700(), 5000);
    }

    @Test
    public void testRefundForContractNumSoin700Max() {
        ContractD contractMock = new ContractD();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "D","A"));
        assertEquals(contractMock.refundForContractNumSoin700(), 9000);
    }
}
