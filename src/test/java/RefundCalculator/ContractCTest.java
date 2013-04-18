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
public class ContractCTest {

    private Calculator mock;

    @Test
    public void testRefundForContractNumSoin0() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin0(), 9000);
    }

    @Test
    public void testRefundForContractNumSoin100() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin100(), 9500);
    }

    @Test
    public void testRefundForContractNumSoin150() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin150(), 8500);
    }

    @Test
    public void testRefundForContractNumSoin175() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin175(), 9000);
    }

    @Test
    public void testRefundForContractNumSoin200() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin200(), 9000);
    }

    @Test
    public void testRefundForContractNumSoin300() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin300(), 9000);
    }

    @Test
    public void testRefundForContractNumSoin400() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin400(), 9000);
    }

    @Test
    public void testRefundForContractNumSoin500() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin500(), 9000);
    }

    @Test
    public void testRefundForContractNumSoin600() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin600(), 7500);
    }

    @Test
    public void testRefundForContractNumSoin700() {
        ContractC contractMock = new ContractC();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "C"));
        assertEquals(contractMock.refundForContractNumSoin700(), 9000);
    }
}
