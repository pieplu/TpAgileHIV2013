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
public class ContractATest {

    private Calculator mock;

    @Test
    public void testSelectNumSoinContrat() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.selectNumSoinContrat(100), 3500);
    }

    @Test
    public void testSelectNumSoinContratfail() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.selectNumSoinContrat(99), 0);
    }

    @Test
    public void testRefundForContractNumSoin0() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin0(), 2500);

    }

    @Test
    public void testRefundForContractNumSoin100() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin100(), 3500);
    }

    @Test
    public void testRefundForContractNumSoin150() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin150(), 0);
    }

    @Test
    public void testRefundForContractNumSoin175() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin175(), 5000);
    }

    @Test
    public void testRefundForContractNumSoin200() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin200(), 2500);
    }

    @Test
    public void testRefundForContractNumSoin300() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin300(), 0);
    }

    @Test
    public void testRefundForContractNumSoin400() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin400(), 0);
    }

    @Test
    public void testRefundForContractNumSoin500() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin500(), 2500);
    }

    @Test
    public void testRefundForContractNumSoin600() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin600(), 4000);
    }

    @Test
    public void testRefundForContractNumSoin700() {
        ContractA contractMock = new ContractA();
        mock.refundCalculator(new FamilyMemberData("0", "100.00$", "A","A"));
        assertEquals(contractMock.refundForContractNumSoin700(), 0);
    }
}
