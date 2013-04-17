
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RefundCalculator;

import InsuranceSoftware.JSONArrayObject;
import InsuranceSoftware.familyMemberMonthlyMax;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hj991118
 */
public class CalculatorTest {
    
    private Calculator mock ;
    private JSONArrayObject client ;
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
         client = new JSONArrayObject("700", "0.00$", "A");
         mock.refundCalculator (client);
        assertEquals(mock.refundCalculator(632), 0);
    }
    
     @Test 
     public void testgetIndexOfMaxAmountForNumSoin() {
         client = new JSONArrayObject("600", "90.00$", "A");
        assertEquals(mock.getIndexOfMaxAmountForNumSoin(600), 4);
    }
     @Test 
     public void testgetIndexOfMaxAmountForNumSoin2() {
         client = new JSONArrayObject("600", "90.00$", "A");
        assertEquals(mock.getIndexOfMaxAmountForNumSoin(600),4);
    }
     
       @Test 
        public void testgetIndexOfMaxAmountForNumSoin3() {
          client  = new JSONArrayObject("700", "50.00$", "A");
        assertEquals(mock.getIndexOfMaxAmountForNumSoin(700), -1);
    }
       @Test   
       public void testgetIndexOfMaxAmountForNumSoin4() {
         client = new JSONArrayObject("100", "0.00$", "A");
        assertEquals(mock.getIndexOfMaxAmountForNumSoin(100), 0);
    }
       
       @Test   
       public void testRefundCalculator() {
         familyMemberMonthlyMax.familyCodeList.clear();
         familyMemberMonthlyMax.familyMembersMonthlyMaxList.clear();
         familyMemberMonthlyMax.familyCodeList.add("A");
         familyMemberMonthlyMax.familyMembersMonthlyMaxList.add(new familyMemberMonthlyMax() );
         assertEquals(mock.refundCalculator(new JSONArrayObject("100", "100.00$", "A")), 34);
    }

     
}
