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

    public CalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

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
        assertEquals(mock.refundCalculator(632), 0);
    }
}