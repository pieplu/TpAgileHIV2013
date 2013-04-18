/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RefundCalculator;

import InsuranceSoftware.FamilyMemberData;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hj991118
 */
public class CalculatorTest {

    private Calculator mock;
    private FamilyMemberData client;

    @Before
    public void setUp() {
        mock = new Calculator();
    }

    @After
    public void tearDown() {
        mock = null;
    }

    @Test
    public void testRefundCalculator_int() {
        assertEquals(Calculator.refundCalculator(50), 0);
    }

    @Test
    public void testRefundCalculator_int2() {
        client = new FamilyMemberData("700", "0.00$", "A", "A");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(25), 0);
    }
    
     @Test
    public void testRefundCalculator_int3() {
        client = new FamilyMemberData("0", "100.00$", "A", "H1");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(25), 1250);
    }
     
    @Test
    public void testRefundCalculator_int4() {
        client = new FamilyMemberData("0", "100.00$", "A", "A");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(25), 2500);
    }
    
    @Test
    public void testRefundCalculator_int5() {
        client = new FamilyMemberData("0", "100.00$", "A", "C1");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(25), 2500);
    }
    
    @Test
    public void testRefundCalculator_int6() {
        client = new FamilyMemberData("0", "100.00$", "B", "B");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(25), 2500);
    }
    
    @Test
    public void testRefundCalculator_int7() {
        client = new FamilyMemberData("0", "100.00$", "B", "H1");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(25), 1250);
    }
    
    @Test
    public void testRefundCalculator_int8() {
        client = new FamilyMemberData("0", "100.00$", "B", "H2");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(25), 1250);
    }
    
    @Test
    public void testRefundCalculator_int9() {
        client = new FamilyMemberData("0", "100.00$", "C", "E1");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(90), 9000);
    }
    
    @Test
    public void testRefundCalculator_int10() {
        client = new FamilyMemberData("150", "100.00$", "C", "C");
        mock.refundCalculator(client);
        assertEquals(mock.refundCalculator(75), 7500);
    }
    
    @Test
    public void testGetIndexOfMaxAmountForNumSoin() {
    assertEquals(mock.getIndexOfMaxAmountForNumSoin(100), 0);
    }
}