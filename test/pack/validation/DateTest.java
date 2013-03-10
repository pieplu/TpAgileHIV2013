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
public class DateTest {
    
    public DateTest() {
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
     * Test of isDateValid method, of class Date.
     */
    @Test
    public void testIsDateValid() {
        System.out.println("isDateValid");
        String reclamationMonth = "";
        String date = "";
        boolean expResult = false;
        boolean result = Date.isDateValid(reclamationMonth, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateFormatYearMonth method, of class Date.
     */
    @Test
    public void testDateFormatYearMonth() {
        System.out.println("dateFormatYearMonth");
        String monthFrom = "";
        boolean expResult = false;
        boolean result = Date.dateFormatYearMonth(monthFrom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateFormatYearMonthDay method, of class Date.
     */
    @Test
    public void testDateFormatYearMonthDay() {
        System.out.println("dateFormatYearMonthDay");
        String dateFrom = "";
        boolean expResult = false;
        boolean result = Date.dateFormatYearMonthDay(dateFrom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
