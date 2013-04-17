/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RefundCalculator;

import InsuranceSoftware.JSONArrayObject;
import RefundCalculator.Calculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author utilisateur
 */
public class ContractBTest {
    
    private Calculator mock ;

      
    @Test
    public void testRefundForContractNumSoin0() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin0(), 4000); 
    }
    
    @Test
    public void testRefundForContractNumSoin0noMax() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "50.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin0(), 2500); 
    }

    @Test
    public void testRefundForContractNumSoin100() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin100(), 5000);
    }

    @Test
    public void testRefundForContractNumSoin150() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin150(), 0);
    }

    @Test
    public void testRefundForContractNumSoin175() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin175(), 7500);
    }

    @Test
    public void testRefundForContractNumSoin200() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin200(), 10000);
    }

    @Test
    public void testRefundForContractNumSoin300() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin300(), 5000);
    }

    @Test
    public void testRefundForContractNumSoin400() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin400(), 0);
    }

    @Test
    public void testRefundForContractNumSoin500() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "80.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin500(), 4000);
    }
    
    @Test
    public void testRefundForContractNumSoin500Max() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "120.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin500(), 5000);
    }

    @Test
    public void testRefundForContractNumSoin600() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin600(), 10000);
    }

    @Test
    public void testRefundForContractNumSoin700() {
        ContractB contractMock = new ContractB();
        mock.refundCalculator (new JSONArrayObject("0", "100.00$", "B"));
        assertEquals(contractMock.refundForContractNumSoin700(), 7000);
    }

    
}
