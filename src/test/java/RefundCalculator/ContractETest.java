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
public class ContractETest {

    private Calculator mock;

    @Test
    public void testRefundForContractNumSoin0() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin0(), 1500);
    }

    @Test
    public void testRefundForContractNumSoin100() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin100(), 2500);
    }

    @Test
    public void testRefundForContractNumSoin150() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin150(), 1500);
    }

    @Test
    public void testRefundForContractNumSoin175() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "20.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin175(), 500);
    }

    @Test
    public void testRefundForContractNumSoin175Max() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin175(), 2000);
    }

    @Test
    public void testRefundForContractNumSoin200() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin200(), 1200);
    }

    @Test
    public void testRefundForContractNumSoin300() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin300(), 6000);
    }

    @Test
    public void testRefundForContractNumSoin400() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "10.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin400(), 250);
    }

    @Test
    public void testRefundForContractNumSoin400Max() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin400(), 1500);
    }

    @Test
    public void testRefundForContractNumSoin500() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "10.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin500(), 300);
    }

    @Test
    public void testRefundForContractNumSoin500Max() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "120.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin500(), 2000);
    }

    @Test
    public void testRefundForContractNumSoin600() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin600(), 1500);
    }

    @Test
    public void testRefundForContractNumSoin700() {
        ContractE contractMock = new ContractE();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "E","A"));
        assertEquals(contractMock.refundForContractNumSoin700(), 2200);
    }
}
