/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hj991118
 */
public class AmountTest {
    
    public AmountTest() {
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

    /**
     * Test of isAmountFormValid method, of class Amount.
     */
    @Test
    public void testIsAmountFormValid() {
        System.out.println("isAmountFormValid");
        String amount = "";
        boolean expResult = false;
        boolean result = Amount.isAmountFormValid(amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMinimumLengthForAmountValid method, of class Amount.
     */
    @Test
    public void testIsMinimumLengthForAmountValid() {
        System.out.println("isMinimumLengthForAmountValid");
        String amount = "";
        boolean expResult = false;
        boolean result = Amount.isMinimumLengthForAmountValid(amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsDollarSignAtTheEnd method, of class Amount.
     */
    @Test
    public void testContainsDollarSignAtTheEnd() {
        System.out.println("containsDollarSignAtTheEnd");
        String amountInDollars = "";
        boolean expResult = false;
        boolean result = Amount.containsDollarSignAtTheEnd(amountInDollars);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsDotForCents method, of class Amount.
     */
    @Test
    public void testContainsDotForCents() {
        System.out.println("containsDotForCents");
        String amountInDollars = "";
        boolean expResult = false;
        boolean result = Amount.containsDotForCents(amountInDollars);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
