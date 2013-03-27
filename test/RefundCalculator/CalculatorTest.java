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
public class CalculatorTest {
    
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
          
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testRefundCalculator_int() {
        assertEquals(Calculator.refundCalculator(25), 0);
    }
}
