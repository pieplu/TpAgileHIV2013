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
public class ServiceNumberTest {
    
    public ServiceNumberTest() {
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
     * Test of isServiceNumberValid method, of class ServiceNumber.
     */
    @Test
    public void testIsServiceNumberValid() {
        System.out.println("isServiceNumberValid");
        String serviceNumber = "";
        boolean expResult = false;
        boolean result = ServiceNumber.isServiceNumberValid(serviceNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of arrayServiceList method, of class ServiceNumber.
     */
    @Test
    public void testArrayServiceList() {
        System.out.println("arrayServiceList");
        String serviceNumber = "";
        boolean expResult = false;
        boolean result = ServiceNumber.arrayServiceList(serviceNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatServiceNumberToExpectedValue method, of class ServiceNumber.
     */
    @Test
    public void testFormatServiceNumberToExpectedValue() {
        System.out.println("formatServiceNumberToExpectedValue");
        String serviceNumber = "";
        int minValue = 0;
        int maxValue = 0;
        String expResult = "";
        String result = ServiceNumber.formatServiceNumberToExpectedValue(serviceNumber, minValue, maxValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
