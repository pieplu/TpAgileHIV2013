/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RefundCalculator;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hj991118
 */
public class ContractTemplateTest {

    public ContractTemplateTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSelectNumSoinContrat() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.selectNumSoinContrat(100), 0);
    }

    @Test
    public void testRefundForContractNumSoin0() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin0(), 0);
    }

    @Test
    public void testRefundForContractNumSoin100() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin100(), 0);
    }

    @Test
    public void testRefundForContractNumSoin150() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin150(), 0);
    }

    @Test
    public void testRefundForContractNumSoin175() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin175(), 0);
    }

    @Test
    public void testRefundForContractNumSoin200() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin200(), 0);
    }

    @Test
    public void testRefundForContractNumSoin300() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin300(), 0);
    }

    @Test
    public void testRefundForContractNumSoin400() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin400(), 0);
    }

    @Test
    public void testRefundForContractNumSoin500() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin500(), 0);
    }

    @Test
    public void testRefundForContractNumSoin600() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin600(), 0);
    }

    @Test
    public void testRefundForContractNumSoin700() {
        ContractTemplate mock = new ContractTemplate();
        assertEquals(mock.refundForContractNumSoin700(), 0);
    }
}
